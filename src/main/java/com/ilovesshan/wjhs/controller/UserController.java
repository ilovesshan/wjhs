package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.UserConverter;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;


    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        User user = userService.findUserById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, userConverter.po2vo(user));
    }
}
