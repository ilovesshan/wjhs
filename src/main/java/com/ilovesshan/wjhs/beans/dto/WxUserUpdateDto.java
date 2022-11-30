package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Data
public class WxUserUpdateDto {
    @NotNull
    private String id;
    private String username;
    private String password;
    private String userType;
    private String gender;
    private String attachmentId;
    private String nickName;
    private String phone;
}
