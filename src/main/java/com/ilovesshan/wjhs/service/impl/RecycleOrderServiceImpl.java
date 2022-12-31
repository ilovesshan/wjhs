package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.mapper.RecycleOrderMapper;
import com.ilovesshan.wjhs.service.RecycleOrderService;
import com.ilovesshan.wjhs.service.WxRecycleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */

@Service
public class RecycleOrderServiceImpl implements RecycleOrderService {
    @Autowired
    private RecycleOrderMapper recycleOrderMapper;

    @Autowired
    private WxRecycleOrderService wxRecycleOrderService;

    @Override
    public List<RecycleOrder> selectListByStatusAndOrderType(String status, String orderType) {
        List<RecycleOrder> recycleOrders = recycleOrderMapper.selectListByStatusAndOrderType(orderType, status, UserCache.get("userType"));
        return wxRecycleOrderService.commonConditionsSelectHandlerList(recycleOrders);
    }

    @Override
    public List<RecycleOrder> selectListByOrderTypeAndUserId(String orderType, String userId) {
        List<RecycleOrder> recycleOrders = recycleOrderMapper.selectListByOrderTypeAndUserId(orderType, userId);
        return wxRecycleOrderService.commonConditionsSelectHandlerList(recycleOrders);
    }

    @Override
    public List<RecycleOrder> selectListByStatusAndOrderTypeAndUserId(String status, String orderType, String userId) {
        List<RecycleOrder> recycleOrders = recycleOrderMapper.selectListByStatusAndOrderTypeAndUserId(status, orderType, userId);
        return wxRecycleOrderService.commonConditionsSelectHandlerList(recycleOrders);
    }
}
