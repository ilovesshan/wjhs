package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */
public interface UserService extends UserDetailsService {
    User findUserByUsername(String username);
}
