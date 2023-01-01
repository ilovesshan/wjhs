package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.*;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.exception.AccessDeniedException;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.core.exception.TransactionalException;
import com.ilovesshan.wjhs.mapper.AccountMapper;
import com.ilovesshan.wjhs.service.AccountRecordService;
import com.ilovesshan.wjhs.service.AccountService;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.service.WxUserService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private WxUserService wxUserService;

    @Autowired
    private UserService userService;

    @Override
    public boolean insert(Account account) {
        return accountMapper.insert(account) > 0;
    }

    @Override
    public boolean updateMoneyWithDecrement(String userId, double balance) {
        return accountMapper.updateMoneyWithDecrement(userId, balance) > 0;
    }

    @Override
    public boolean updateMoneyWithDecrementBatch(List<String> userIds, double balance) {
        return accountMapper.updateMoneyWithDecrementBatch(userIds, balance) > 0;
    }

    @Override
    public boolean updateMoneyWithIncrement(String userId, double balance) {
        return accountMapper.updateMoneyWithIncrement(userId, balance) > 0;
    }

    @Override
    public boolean updateMoneyWithIncrementBatch(List<String> userIds, double balance) {
        return accountMapper.updateMoneyWithIncrementBatch(userIds, balance) > 0;
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

    @Override
    public List<UserAccount> selectListByType(String type) {
        ArrayList<UserAccount> userAccounts = new ArrayList<>();
        // TODO: 这里可以通过编写sql来优化掉循环查询
        if (Objects.equals(type, "1")) {
            // 查询 小程序用户账户信息列表
            List<WxUser> wxUsers = wxUserService.selectList();
            for (WxUser wxUser : wxUsers) {
                UserAccount userAccount = new UserAccount();
                Account account = selectByUserId(wxUser.getId());
                userAccount.setUserId(wxUser.getId());
                userAccount.setUsername(wxUser.getNickName());
                userAccount.setAvatarUrl(wxUser.getAvatarUrl());
                userAccount.setBalance(account.getBalance());
                userAccount.setAccountRecords(account.getAccountRecords());
                userAccounts.add(userAccount);
            }
        } else {
            // 查询 平台用户、骑手用户、回收中心用户 账户信息列表
            List<User> users = userService.selectListByType(type);
            for (User user : users) {
                UserAccount userAccount = new UserAccount();
                Account account = selectByUserId(user.getId());
                userAccount.setUserId(user.getId());
                userAccount.setUsername(user.getUsername());
                userAccount.setAvatarUrl(user.getAttachment().getUrl());
                userAccount.setBalance(account.getBalance());
                userAccount.setAccountRecords(account.getAccountRecords());
                userAccounts.add(userAccount);
            }
        }
        return userAccounts;
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean decrementAccountWithDriver(double balance, String tradingNote) {
        List<User> users = userService.selectListByType("2");
        User admin = userService.findUserByUsername("admin");
        for (User user : users) {
            // 支出账户出账、收入账户进账
            accountService.updateMoneyWithDecrement(user.getId(), balance);
            accountService.updateMoneyWithIncrement(admin.getId(), balance);

            // 新增账户流水记录
            AccountRecord accountRecord = new AccountRecord(
                    UuidUtil.generator(), "0", "2", admin.getId(), user.getId(), "36", null,
                    balance, "28", tradingNote, "15", null, null
            );
            accountRecordService.insert(accountRecord);
        }
        return true;
    }
}
