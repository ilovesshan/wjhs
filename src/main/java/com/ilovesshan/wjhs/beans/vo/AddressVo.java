package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AddressVo {
    private String id;
    private String userName;
    private String phone;
    private String area;
    private String city;
    private String province;
    private String detailAddress;
    private String longitude;
    private String latitude;
    private String isDefault;
    private String isDelete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
