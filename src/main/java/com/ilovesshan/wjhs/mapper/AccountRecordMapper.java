package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.AccountRecord;
import org.apache.ibatis.annotations.Mapper;

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
}
