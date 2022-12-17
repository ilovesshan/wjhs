package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.RecycleOrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */

@Mapper
public interface RecycleOrderDetailMapper {
    int deleteByOrderId(String id);

    int insert(List<RecycleOrderDetail> recycleOrderDetails);

    List<RecycleOrderDetail> selectListByOrderId(String orderId);
}
