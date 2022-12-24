package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.WxIntegral;
import com.ilovesshan.wjhs.mapper.WxIntegralMapper;
import com.ilovesshan.wjhs.service.WxIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */

@Service
public class WxIntegralServiceImpl implements WxIntegralService {

    @Autowired
    private WxIntegralMapper wxIntegralMapper;


    @Override
    public boolean insert(WxIntegral integral) {
        return wxIntegralMapper.insert(integral) > 0;
    }

    @Override
    public boolean updateMoneyWithIncrement(String submitUserId, double totalIntegral) {
        return wxIntegralMapper.updateMoneyWithIncrement(submitUserId, totalIntegral) > 0;
    }

    @Override
    public boolean updateMoneyWithDecrement(String submitUserId, double totalIntegral) {
        return wxIntegralMapper.updateMoneyWithDecrement(submitUserId, totalIntegral) > 0;
    }
}
