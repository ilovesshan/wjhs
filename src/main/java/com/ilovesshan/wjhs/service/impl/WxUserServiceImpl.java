package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.mapper.WxUserMapper;
import com.ilovesshan.wjhs.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */


@Service
public class WxUserServiceImpl implements WxUserService {

    @Autowired
    private WxUserMapper userMapper;

    @Override
    public WxUser findUserByOpenId(String openid) {
        return userMapper.findUserByOpenId(openid);
    }

    @Override
    public boolean insert(WxUser wxUser) {
       return userMapper.insert(wxUser) > 0;
    }

    @Override
    public boolean update(WxUser wxUser) {
        return userMapper.update(wxUser) > 0;
    }

    @Override
    public WxUser findUserById(String id) {
        return userMapper.findUserById(id);
    }
}
