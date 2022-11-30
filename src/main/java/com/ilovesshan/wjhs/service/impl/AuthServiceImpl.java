package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.dto.UserAuthDto;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.service.AuthService;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Override
    public String auth(UserAuthDto userAuthDto) {
        User selectedUser = userService.findUserByUsername(userAuthDto.getUsername());

        if (selectedUser == null) {
            throw new CustomException(R.ERROR_USER_NOT_FOUND);
        }

        if (!userAuthDto.getPassword().equals(selectedUser.getPassword())) {
            throw new CustomException(R.ERROR_USER_NAME_OR_PASSWORD);
        }

        // 校验通过 返回Token
        return TokenUtil.generatorToken(selectedUser.getId(), selectedUser.getUsername());
    }
}
