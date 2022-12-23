package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.UserAddressRel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */

@Mapper
public interface UserAddressRelMapper {
    int deleteByAddressId(String addressId);

    int insert(UserAddressRel addressRel);
}
