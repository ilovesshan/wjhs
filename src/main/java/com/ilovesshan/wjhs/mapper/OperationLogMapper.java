package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.OperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Mapper
public interface OperationLogMapper {
    int insert(OperationLog operationLog);
}
