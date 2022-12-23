package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.UserAddressRel;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */
public interface UserAddressRelService {
    boolean deleteByAddressId(String addressId);

    boolean insert(UserAddressRel addressRel);
}
