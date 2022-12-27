package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.WxIntegral;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */

@Mapper
public interface WxIntegralMapper {

    int insert(WxIntegral integral);

    int updateMoneyWithIncrement(@Param("userId") String submitUserId, @Param("integral") double totalIntegral);

    int updateMoneyWithDecrement(@Param("userId") String submitUserId, @Param("integral") double totalIntegral);

    WxIntegral selectByUserId(String userId);

}
