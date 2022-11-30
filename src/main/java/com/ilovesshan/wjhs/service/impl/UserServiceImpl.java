
package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.AuthUser;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.mapper.UserMapper;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User selectedUser = this.findUserByUsername(username);
        if (Objects.isNull(selectedUser)) {
            throw new UsernameNotFoundException(R.ERROR_USER_NOT_FOUND);
        }
        return new AuthUser(selectedUser);
    }
}
