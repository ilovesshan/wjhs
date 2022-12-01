package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.WxUser;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */
public interface WxUserService {
    WxUser findUserByOpenId(String openid);

    boolean insert(WxUser wxUser);

    boolean update(WxUser wxUser);

    WxUser findUserById(String id);
}
