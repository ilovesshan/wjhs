package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.mapper.AccountMapper;
import com.ilovesshan.wjhs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/20
 * @description:
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean insert(Account account) {
        return accountMapper.insert(account) > 0;
    }

    @Override
    public boolean updateMoneyWithDecrement(String userId, double balance) {
        return accountMapper.updateMoneyWithDecrement(userId, balance) > 0;
    }

    @Override
    public boolean updateMoneyWithIncrement(String userId, double balance) {
        return accountMapper.updateMoneyWithIncrement(userId, balance) > 0;
    }
}
