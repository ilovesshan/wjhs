package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.RecycleOrderDetail;
import com.ilovesshan.wjhs.mapper.RecycleOrderDetailMapper;
import com.ilovesshan.wjhs.service.RecycleOrderDetailService;
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
public class RecycleOrderDetailServiceImpl implements RecycleOrderDetailService {
    @Autowired
    private RecycleOrderDetailMapper recycleOrderDetailMapper;

    public boolean deleteByOrderId(String id) {
        return recycleOrderDetailMapper.deleteByOrderId(id) > 0;
    }

    public boolean insert(List<RecycleOrderDetail> recycleOrderDetails) {
        return recycleOrderDetailMapper.insert(recycleOrderDetails) > 0;
    }

    @Override
    public List<RecycleOrderDetail> selectListByOrderId(String orderId) {
        return  recycleOrderDetailMapper.selectListByOrderId(orderId) ;
    }
}
