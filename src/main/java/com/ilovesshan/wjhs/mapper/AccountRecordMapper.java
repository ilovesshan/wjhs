package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.AccountRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/20
 * @description:
 */

@Mapper
public interface AccountRecordMapper {
    int insert(AccountRecord accountRecord);

    AccountRecord selectByOrderId(String orderId);

    List<AccountRecord> selectListByUserId(String userId);
}
