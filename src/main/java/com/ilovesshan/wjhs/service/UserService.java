package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */
public interface UserService {
    User findUserByUsername(String username);
}
