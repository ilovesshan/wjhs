package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.RecycleOrderDetail;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */
public interface RecycleOrderDetailService {

    boolean deleteByOrderId(String id);

    boolean insert(List<RecycleOrderDetail> recycleOrderDetails);

    List<RecycleOrderDetail> selectListByOrderId(String orderId);

}
