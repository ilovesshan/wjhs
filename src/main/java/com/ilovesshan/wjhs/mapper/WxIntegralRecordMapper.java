package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.WxIntegralRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */

@Mapper
public interface WxIntegralRecordMapper {
    int insert(WxIntegralRecord integralRecord);

    List<WxIntegralRecord> selectListByUserId(String userId);
}
