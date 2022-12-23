package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */

@Mapper
public interface AddressMapper {
    List<Address> selectList(String userId);

    Address selectById(String id);

    int deleteById(String id);

    int insert(Address address);

    int update(Address address);

    int selectRows();

    void updateDefaultAddress();

}
