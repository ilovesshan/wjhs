package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.SystemDict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Mapper
public interface SystemDictMapper {
    List<SystemDict> selectAll();
}
