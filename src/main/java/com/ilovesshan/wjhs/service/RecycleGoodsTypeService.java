package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/11
 * @description:
 */
public interface RecycleGoodsTypeService {
    List<RecycleGoodsType> selectList();

    RecycleGoodsType selectById(String id);

    boolean deleteById(String id);

    boolean insert(RecycleGoodsType recycleGoodsType);

    boolean update(RecycleGoodsType recycleGoodsType);
}
