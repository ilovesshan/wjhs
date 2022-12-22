package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */
public interface RecycleOrderService {
    List<RecycleOrder> selectListByStatusAndOrderType(String status, String orderType);

    List<RecycleOrder> selectListByOrderTypeAndUserId(String s, String userId);

    List<RecycleOrder> selectListByStatusAndOrderTypeAndUserId(String status, String orderType, String userId);
}
