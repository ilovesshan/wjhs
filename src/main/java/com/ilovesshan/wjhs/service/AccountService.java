package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.Account;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/20
 * @description:
 */
public interface AccountService {
    boolean insert(Account account);

    boolean updateMoneyWithDecrement(String userId, double balance);

    boolean updateMoneyWithIncrement(String userId, double balance);
}
