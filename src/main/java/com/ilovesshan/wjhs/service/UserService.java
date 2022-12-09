package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.dto.UserUpdatePasswordDto;
import com.ilovesshan.wjhs.beans.pojo.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */
public interface UserService {
    User findUserByUsername(String username);

    User findUserById(String id);

    boolean update(User user);

    String create(User dto2po);

    boolean deleteById(String id);

    List<User> selectListByType(String type);

    int updatePassword(UserUpdatePasswordDto userUpdatePasswordDto);
}
