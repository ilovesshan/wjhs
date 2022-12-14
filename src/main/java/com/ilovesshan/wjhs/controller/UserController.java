package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AttachmentConverter;
import com.ilovesshan.wjhs.beans.converter.UserConverter;
import com.ilovesshan.wjhs.beans.dto.UserCreateDto;
import com.ilovesshan.wjhs.beans.dto.UserUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.beans.vo.UserVo;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Api(tags = "用户模块")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AttachmentConverter attachmentConverter;

    @ApiOperation("根据类型获取用户列表")
    @GetMapping
    public R selectListByType(@RequestParam String type) {
        List<User> users = userService.selectListByType(type);
        List<UserVo> userVos = users.stream().map(user -> {
            UserVo userVo = userConverter.po2vo(user);
            if (user.getAttachment().getId() != null) {
                userVo.setAttachment(attachmentConverter.po2vo(user.getAttachment()));
            } else {
                userVo.setAttachment(null);
            }
            return userVo;
        }).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, userVos);
    }

    @ApiOperation("根据ID获取用户信息")
    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        User user = userService.findUserById(id);
        UserVo userVo = userConverter.po2vo(user);
        if (userVo.getAttachment().getId() != null) {
            userVo.setAttachment(attachmentConverter.po2vo(user.getAttachment()));
        } else {
            userVo.setAttachment(null);
        }
        return R.success(R.SUCCESS_MESSAGE_SELECT, userVo);
    }

    @ApiOperation("更新用户信息")
    @PutMapping
    public R update(@Validated @RequestBody UserUpdateDto userUpdateDto) {
        boolean isSuccess = userService.update(userConverter.dto2po(userUpdateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.SUCCESS_MESSAGE_UPDATE);
    }


    @Log(businessModule = "用户模块", businessType = "INSERT", businessDescribe = "新增用户")
    @ApiOperation("新增用户")
    @PostMapping
    public R create(@Validated @RequestBody UserCreateDto userUpdateDto) {
        String id = userService.create(userConverter.dto2po(userUpdateDto));
        User user = userService.findUserById(id);
        return R.success(R.SUCCESS_MESSAGE_INSERT, userConverter.po2vo(user));
    }

    @Log(businessModule = "用户模块", businessType = "DELETE", businessDescribe = "根据ID删除用户")
    @ApiOperation("根据ID删除用户")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = userService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }
}
