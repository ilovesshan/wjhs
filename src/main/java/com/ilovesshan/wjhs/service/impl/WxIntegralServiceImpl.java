package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.*;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.WxIntegralMapper;
import com.ilovesshan.wjhs.service.WxIntegralRecordService;
import com.ilovesshan.wjhs.service.WxIntegralService;
import com.ilovesshan.wjhs.service.WxUserService;
import com.ilovesshan.wjhs.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Autowired
    private WxIntegralRecordService wxIntegralRecordService;

    @Autowired
    private WxUserService wxUserService;


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


    @Override
    public WxIntegral selectByUserId(String userId) {
        WxIntegral wxIntegral = wxIntegralMapper.selectByUserId(userId);
        if (Objects.isNull(wxIntegral)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        List<WxIntegralRecord> wxIntegralRecordList = wxIntegralRecordService.selectListByUserId(userId);
        wxIntegral.setIntegralRecords(wxIntegralRecordList);
        return wxIntegral;
    }

    @Override
    public List<UserIntegral> selectList() {
        ArrayList<UserIntegral> userIntegrals = new ArrayList<>();
        // TODO: 这里可以通过编写sql来优化掉循环查询
        List<WxUser> wxUsers = wxUserService.selectList();
        for (WxUser wxUser : wxUsers) {
            UserIntegral userIntegral = new UserIntegral();
            WxIntegral wxIntegral = selectByUserId(wxUser.getId());
            userIntegral.setUserId(wxUser.getId());
            userIntegral.setUsername(wxUser.getNickName());
            userIntegral.setAvatarUrl(wxUser.getAvatarUrl());
            userIntegral.setIntegral(wxIntegral.getIntegral());
            userIntegral.setIntegralRecords(wxIntegral.getIntegralRecords());
            userIntegrals.add(userIntegral);
        }
        return userIntegrals;
    }
}
