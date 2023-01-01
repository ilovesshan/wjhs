package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/20
 * @description:
 */

@Mapper
public interface AccountMapper {
    int insert(Account account);

    int updateMoneyWithDecrement(@Param("userId") String userId, @Param("balance") double balance);

    int updateMoneyWithIncrement(@Param("userId") String userId, @Param("balance") double balance);

    Account selectByUserId(String userId);

    int updateMoneyWithDecrementBatch(@Param("userIds")List<String> userIds, @Param("balance")double balance);

    int updateMoneyWithIncrementBatch(@Param("userIds")List<String> userIds, @Param("balance")double balance);
}
