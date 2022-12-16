package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.UserAddressRel;
import com.ilovesshan.wjhs.mapper.UserAddressRelMapper;
import com.ilovesshan.wjhs.service.UserAddressRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */

@Service
public class UserAddressRelServiceImpl implements UserAddressRelService {

    @Autowired
    private UserAddressRelMapper userAddressRelMapper;

    @Override
    public boolean deleteByAddressId(String addressId) {
        return userAddressRelMapper.deleteByAddressId(addressId) > 0;
    }

    @Override
    public boolean insert(UserAddressRel addressRel) {
        return userAddressRelMapper.insert(addressRel) > 0;
    }
}
