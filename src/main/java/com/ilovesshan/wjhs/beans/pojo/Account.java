package com.ilovesshan.wjhs.beans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    private String userType;
    private String userId;
    private double balance;
    private String isDelete;
    private Date createTime;
    private Date updateTime;
}
