package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.OperationLog;
import com.ilovesshan.wjhs.mapper.OperationLogMapper;
import com.ilovesshan.wjhs.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Autowired
    private OperationLogMapper operationLogMapper;


    @Async
    @Override
    public void insert(OperationLog operationLog) {
        operationLogMapper.insert(operationLog);
    }
}
