package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.AccountRecord;
import com.ilovesshan.wjhs.mapper.AccountRecordMapper;
import com.ilovesshan.wjhs.service.AccountRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/20
 * @description:
 */

@Service
public class AccountRecordServiceImpl implements AccountRecordService {

    @Autowired
    private AccountRecordMapper accountRecordMapper;

    @Override
    public boolean insert(AccountRecord accountRecord) {
       return accountRecordMapper.insert(accountRecord) > 0;
    }

    @Override
    public AccountRecord selectByOrderId(String orderId) {
        return accountRecordMapper.selectByOrderId(orderId);
    }

    @Override
    public List<AccountRecord> selectListByUserId(String userId) {
        return accountRecordMapper.selectListByUserId(userId);
    }
}
