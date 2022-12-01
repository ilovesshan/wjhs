package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.dto.UserAuthDto;
import com.ilovesshan.wjhs.beans.pojo.AuthUser;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.config.RedisCache;
import com.ilovesshan.wjhs.core.exception.AuthorizationException;
import com.ilovesshan.wjhs.service.AuthService;
import com.ilovesshan.wjhs.utils.JwtUtil;
import com.ilovesshan.wjhs.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

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
    private AuthenticationManager authenticationManager;

    @Override
    public String auth(UserAuthDto userAuthDto) {
        // 封装一个Authentication对象 交给authenticationManager去进去认证
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userAuthDto.getUsername(), userAuthDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果为空 表示认证失败了
        if (Objects.isNull(authenticate)) {
            throw new AuthorizationException(R.ERROR_USER_NAME_OR_PASSWORD);
        }

        // 取出用户信息
        AuthUser principal = (AuthUser) authenticate.getPrincipal();

        // 将用户登录信息存在redis中
        String userId = principal.getUser().getId();
        redisCache.set(Constants.REDIS_USER_PREFIX + userId, principal, Constants.JWT_EXPIRATION);

        // 校验通过 返回Token
        return JwtUtil.generatorToken(userId, principal.getUsername());
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
