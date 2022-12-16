package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.Address;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */
public interface AddressService {
    Address selectById(String id);

    List<Address> selectList();

    boolean deleteById(String id);

    boolean insert(Address address);

    boolean update(Address address);
}
