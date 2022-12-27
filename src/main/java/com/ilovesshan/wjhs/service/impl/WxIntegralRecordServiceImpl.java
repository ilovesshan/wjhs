package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.WxIntegralRecord;
import com.ilovesshan.wjhs.mapper.WxIntegralRecordMapper;
import com.ilovesshan.wjhs.service.WxIntegralRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */

@Service
public class WxIntegralRecordServiceImpl implements WxIntegralRecordService{

    @Autowired
    private WxIntegralRecordMapper wxIntegralRecordMapper;

    @Override
    public boolean insert(WxIntegralRecord integralRecord) {
        return wxIntegralRecordMapper.insert(integralRecord) > 0;
    }

    @Override
    public List<WxIntegralRecord> selectListByUserId(String userId) {
        return wxIntegralRecordMapper.selectListByUserId(userId);
    }
}
