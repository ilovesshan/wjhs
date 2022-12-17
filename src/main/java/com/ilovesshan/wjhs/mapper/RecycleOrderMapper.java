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

    List<RecycleOrder> selectListByStatus(String status);

    int deleteById(String id);

    int insert(RecycleOrder recycleOrder);

    int updateOrderStatus(@Param("id") String id, @Param("status") String status, @Param("receiveUserId") String receiveUserId);
}
