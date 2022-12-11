package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.RecycleGoods;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsAndType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/11
 * @description:
 */
public interface RecycleGoodsService {
    List<RecycleGoods> selectList();

    RecycleGoods selectById(String id);

    boolean deleteById(String id);

    boolean insert(RecycleGoods recycleGoods);

    boolean update(RecycleGoods recycleGoods);

    List<RecycleGoods> selectListByType(String type);

    List<RecycleGoodsAndType> selectAllListWithType();

}
