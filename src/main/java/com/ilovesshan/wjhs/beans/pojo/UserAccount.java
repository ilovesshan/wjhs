package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/27
 * @description:
 */

@Data
public class UserAccount {
    private String userId;
    private String username;
    private String avatarUrl;
    private double balance;
    private List<AccountRecord> accountRecords;
}
