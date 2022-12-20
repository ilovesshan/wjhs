package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.dto.RecycleOrderUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */
public interface WxRecycleOrderService {
    RecycleOrder selectById(String id);

    List<RecycleOrder> selectListByStatus(String status);

    boolean deleteById(String id);

    boolean create(RecycleOrder recycleOrder);

    boolean updateOrderStatus(RecycleOrderUpdateDto recycleOrderUpdateDto);
}
