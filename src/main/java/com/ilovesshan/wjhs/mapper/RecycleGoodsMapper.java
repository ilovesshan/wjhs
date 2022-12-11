package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.RecycleGoods;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsAndType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/11
 * @description:
 */

@Mapper
public interface RecycleGoodsMapper {

    List<RecycleGoods> selectList();

    RecycleGoods selectById(String id);

    RecycleGoods selectByName(String name);

    int deleteById(String id);

    int insert(RecycleGoods recycleGoods);

    int update(RecycleGoods recycleGoods);

    List<RecycleGoods> selectListByType(String type);

    List<RecycleGoodsAndType> selectAllListWithType();
}
