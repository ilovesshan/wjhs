package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.RecycleStatistical;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */

@Mapper
public interface RecycleStatisticalMapper {
    int insert(RecycleStatistical recycleStatistical);
}
