package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/9
 * @description:
 */

@Data
public class UserUpdatePasswordDto {
    @NotNull(message = "用户ID不能为空")
    private String id;

    @Size(max = 32, min = 6, message = "旧密码长度在6到32个字符之间")
    private String oldPassword;

    @Size(max = 32, min = 6, message = "新密码长度在6到32个字符之间")
    private String newPassword;
}
