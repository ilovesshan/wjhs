package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.AccountRecord;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/20
 * @description:
 */
public interface AccountRecordService {
    boolean insert(AccountRecord accountRecord);

    AccountRecord selectByOrderId(String orderId);

    List<AccountRecord> selectListByUserId(String userId);
}
