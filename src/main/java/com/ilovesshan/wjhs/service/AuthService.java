package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.dto.UserAuthDto;
import com.ilovesshan.wjhs.beans.dto.UserUpdatePasswordDto;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */
public interface AuthService{
    String auth(UserAuthDto userAuthDto);

    void logout();

    boolean updatePassword(UserUpdatePasswordDto userUpdatePasswordDto);
}
