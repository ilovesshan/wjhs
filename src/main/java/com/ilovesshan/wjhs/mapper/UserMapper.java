package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Mapper
public interface UserMapper {
    User findUserByUsername(String username);
}
