package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.dto.UserAuthDto;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.config.RedisCache;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.service.AuthService;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.utils.AesUtils;
import com.ilovesshan.wjhs.utils.JwtUtil;
import com.ilovesshan.wjhs.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private UserService userService;

    @Override
    public String auth(UserAuthDto userAuthDto) {
        User finedUser = userService.findUserByUsername(userAuthDto.getUsername());
        // 用户不存在
        if (Objects.isNull(finedUser)) {
            throw new CustomException(R.ERROR_USER_NOT_FOUND);
        }

        // 用户名或者密码错误
        if (!userAuthDto.getPassword().equals(AesUtils.decrypt(finedUser.getPassword()))) {
            throw new CustomException(R.ERROR_USER_NAME_OR_PASSWORD);
        }

        // 将用户登录信息存在redis中
        redisCache.set(Constants.REDIS_USER_PREFIX + finedUser.getId(), finedUser, Constants.JWT_EXPIRATION);

        // 更新用户近一次登录时间
        finedUser.setLastVisitTime(new Date());
        userService.update(finedUser);

        //  返回Token
        return JwtUtil.generatorToken(finedUser.getId(), finedUser.getUsername());
    }

    @Override
    public void logout() {
        String userId = UserCache.get("userId");
        String username = UserCache.get("username");

        // 从redis中删除用户信息
        redisCache.remove(Constants.REDIS_USER_PREFIX + userId);

        log.debug("{}退出登录, 用户ID: {}", username, userId);
    }
}
