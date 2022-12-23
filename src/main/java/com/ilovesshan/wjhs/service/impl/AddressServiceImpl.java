package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.Address;
import com.ilovesshan.wjhs.beans.pojo.UserAddressRel;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.core.exception.TransactionalException;
import com.ilovesshan.wjhs.mapper.AddressMapper;
import com.ilovesshan.wjhs.service.AddressService;
import com.ilovesshan.wjhs.service.UserAddressRelService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UserAddressRelService userAddressRelService;


    @Override
    public Address selectById(String id) {
        Address findAddress = addressMapper.selectById(id);
        if (Objects.isNull(findAddress)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return findAddress;
    }

    @Override
    public List<Address> selectList() {
        return addressMapper.selectList(UserCache.get("userId"));
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean deleteById(String id) {
        Address fineAddress = selectById(id);
        if (Objects.equals(fineAddress.getIsDefault(), "18")) {
            throw new CustomException("不能删除默认地址");
        }

        // 删除关联表数据
        userAddressRelService.deleteByAddressId(id);

        // 删除address表数据
        return addressMapper.deleteById(id) > 0;
    }


    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean insert(Address address) {
        String addressId = UuidUtil.generator();
        address.setId(addressId);
        if (addressMapper.selectRows() == 0) {
            // 第一次新增 设置成默认地址
            address.setIsDefault("18");
        } else {
            address.setIsDefault("19");
        }

        // address表新增数据
        addressMapper.insert(address);

        // 关联表新增数据
        UserAddressRel addressRel = new UserAddressRel();
        addressRel.setId(UuidUtil.generator());
        addressRel.setAddressId(addressId);
        addressRel.setUserId(UserCache.get("userId"));
        return userAddressRelService.insert(addressRel);
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean update(Address address) {
        // 非默认 -> 默认
        if (Objects.equals(address.getIsDefault(), "18")) {
            // 将现在的默认地址更新非默认地址
            addressMapper.updateDefaultAddress();
        }
        // 再将新的地址改成默认地址
        selectById(address.getId());
        return addressMapper.update(address) > 0;
    }
}
