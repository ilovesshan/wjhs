package com.ilovesshan.wjhs.mapper;

import com.ilovesshan.wjhs.beans.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    User findUserById(String id);

    int update(User user);

    int insert(User user);

    int deleteById(String id);

    List<User> selectListByType(String type);

    int updatePassword(@Param("id") String id, @Param("password") String newPassword);
}
