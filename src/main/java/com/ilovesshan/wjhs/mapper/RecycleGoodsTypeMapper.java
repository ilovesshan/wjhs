package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsType;
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
public interface RecycleGoodsTypeMapper {

    List<RecycleGoodsType> selectList();

    RecycleGoodsType selectById(String id);

    RecycleGoodsType selectByName(String name);

    int deleteById(String id);

    int insert(RecycleGoodsType recycleGoodsType);

    int update(RecycleGoodsType recycleGoodsType);
}
