package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Address {
    private String id;
    private String detailAddress;
    private String area;
    private String city;
    private String province;
    private String phone;
    private String userName;
    private String longitude;
    private String latitude;
    private String isDefault;
    private String isDelete;
    private Date createTime;
    private Date updateTime;
}
