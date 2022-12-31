package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */

@Mapper
public interface RecycleOrderMapper {
    RecycleOrder selectById(String id);

    int deleteById(String id);

    int insert(RecycleOrder recycleOrder);

    int updateOrderStatusWithTimeOut(String userId);

    int updateOrderStatus(@Param("id") String id, @Param("status") String status, @Param("receiveUserId") String receiveUserId);

    List<RecycleOrder> selectListByStatusAndOrderType(@Param("orderType") String orderType, @Param("status") String status, @Param("userType") String userType);

    List<RecycleOrder> selectListByOrderTypeAndUserId(@Param("orderType") String orderType, @Param("userId") String userId);

    List<RecycleOrder> selectListByStatusAndOrderTypeAndUserId(@Param("status") String status, @Param("orderType") String orderType, @Param("userId") String userId);

    void updateOrderStatusWithSendToRecycleCenter(String orderId);
}
