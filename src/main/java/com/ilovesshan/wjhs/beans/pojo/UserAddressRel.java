package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserAddressRel {
    private String id;
    private String userId;
    private String addressId;
    private String isDelete;
    private Date createTime;
    private Date updateTime;
}
