package com.ilovesshan.wjhs.beans.dto;

import com.ilovesshan.wjhs.utils.RegexpUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class AddressCreateDto {
    @NotNull(message = "用户名称不能为空")
    @Size(max = 10, min = 2, message = "用户名长度在2到10个字符之间")
    private String userName;

    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = RegexpUtil.MOBILE_PHONE_REGEXP, message = "请输入正确手机号")
    private String phone;

    @NotNull(message = "省不能为空")
    private String province;
    @NotNull(message = "市不能为空")
    private String city;
    @NotNull(message = "县/区不能为空")
    private String area;
    @NotNull(message = "详细地址不能为空")
    private String detailAddress;

    @NotNull(message = "经度不能为空")
    private String longitude;
    @NotNull(message = "纬度不能为空")
    private String latitude;
}
