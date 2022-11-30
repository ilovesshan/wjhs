
package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.mapper.UserMapper;
import com.ilovesshan.wjhs.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}
