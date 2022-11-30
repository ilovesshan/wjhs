package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.dto.UserAuthDto;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */
public interface AuthService {
    String auth(UserAuthDto userAuthDto);
}
