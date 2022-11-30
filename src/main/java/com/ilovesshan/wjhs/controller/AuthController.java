package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.dto.UserAuthDto;
import com.ilovesshan.wjhs.service.AuthService;
import com.ilovesshan.wjhs.utils.JwtUtil;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */


@Api(tags = "授权模块")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation("用户授权")
    @PostMapping
    public R auth(@Validated @RequestBody UserAuthDto userAuthDto) {
        String token = authService.auth(userAuthDto);
        HashMap<String, String> data = new HashMap<>();
        data.put("id", JwtUtil.getUserId(token));
        data.put("username", userAuthDto.getUsername());
        data.put("token", token);
        return R.success(R.SUCCESS_MESSAGE_LOGIN, data);
    }

    @ApiOperation("用户注销")
    @DeleteMapping
    public R logout() {
        authService.logout();
        return R.success(R.SUCCESS_MESSAGE_LOGOUT);
    }

}
