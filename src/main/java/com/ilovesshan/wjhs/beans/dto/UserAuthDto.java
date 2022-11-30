package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Data
public class UserAuthDto {

    @NotNull(message = "用户名不能为空")
    @Size(max = 24, min = 4, message = "用户名长度在4到24个字符之间")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(max = 32, min = 10, message = "密码长度在10到32个字符之间")
    private String password;
}
