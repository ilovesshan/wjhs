package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class WxUser {
    private String id;
    private String openId;
    private String skey;
    private String sessionKey;
    private String gender;
    private String avatarUrl;
    private String city;
    private String province;
    private String country;
    private String nickName;
    private String isDelete;
    private Date lastVisitTime;
    private Date createTime;
    private Date updateTime;
}
