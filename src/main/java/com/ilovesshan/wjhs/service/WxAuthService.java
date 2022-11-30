package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.WxUser;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */
public interface WxAuthService {
    WxUser auth(String code);
}
