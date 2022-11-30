package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String userType;
    private String gender;
    private String attachmentId;
    private String nickName;
    private String phone;
    private String isDelete;
    private Date lastVisitTime;
    private Date createTime;
    private Date updateTime;

}
