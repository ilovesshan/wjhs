package com.ilovesshan.wjhs.beans.dto;

import com.ilovesshan.wjhs.utils.RegexpUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/9
 * @description:
 */

@Data
public class UserUpdateDto {
    @NotNull(message = "用户ID不能为空")
    private String id;
    @NotNull(message = "用户名称不能为空")
    @Size(max = 24, min = 4, message = "用户名长度在4到24个字符之间")
    private String username;
    @NotNull(message = "用户类型不能为空")
    private String userType;
    private String gender;
    private String attachmentId;
    private String nickName;
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = RegexpUtil.MOBILE_PHONE_REGEXP, message = "请输入正确手机号")
    private String phone;
}
