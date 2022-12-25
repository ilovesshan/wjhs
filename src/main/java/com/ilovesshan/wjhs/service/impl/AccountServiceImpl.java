package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.beans.pojo.AccountRecord;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.exception.AccessDeniedException;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.core.exception.TransactionalException;
import com.ilovesshan.wjhs.mapper.AccountMapper;
import com.ilovesshan.wjhs.service.AccountRecordService;
import com.ilovesshan.wjhs.service.AccountService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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

    @Autowired
    private AccountRecordService accountRecordService;

    @Autowired
    private AccountService accountService;

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

    @Override
    public Account selectByUserId(String userId) {
        Account account = accountMapper.selectByUserId(userId);
        if (Objects.isNull(account)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        List<AccountRecord> accountRecordList = accountRecordService.selectListByUserId(userId);
        account.setAccountRecords(accountRecordList);
        return account;
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean updateAccountBalance(AccountRecord accountRecord) {

        // 限制一下 暂时只能平台端调用充值接口
        if (!Objects.equals(UserCache.get("userType"), "0")) {
            throw new AccessDeniedException(R.ERROR_MESSAGE_FORBIDDEN);
        }

        // 支出账户出账、收入账户进账
        accountService.updateMoneyWithDecrement(accountRecord.getUserIdTo(), accountRecord.getTradingMoney());
        accountService.updateMoneyWithIncrement(accountRecord.getUserIdFrom(), accountRecord.getTradingMoney());

        // 新增账户流水记录
        accountRecord.setId(UuidUtil.generator());
        accountRecord.setPayStatus("36");
        accountRecord.setTradingId(null);
        accountRecord.setTradingType("28");
        accountRecord.setIsDelete("15");
        return accountRecordService.insert(accountRecord);
    }
}
