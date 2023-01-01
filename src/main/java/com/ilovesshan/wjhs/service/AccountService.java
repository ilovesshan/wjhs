package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.beans.pojo.AccountRecord;
import com.ilovesshan.wjhs.beans.pojo.UserAccount;

import java.util.List;

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

    boolean updateMoneyWithDecrementBatch(List<String> userIds, double balance);
    boolean updateMoneyWithIncrementBatch(List<String> userIds, double balance);

    Account selectByUserId(String id);

    boolean updateAccountBalance(AccountRecord accountRecord);

    List<UserAccount>  selectListByType(String type);

    boolean decrementAccountWithDriver(double balance, String tradingNote);
}
