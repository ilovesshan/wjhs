package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.WxIntegral;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */
public interface WxIntegralService {
    boolean insert(WxIntegral integral);

    boolean updateMoneyWithIncrement(String submitUserId, double totalIntegral);

    boolean updateMoneyWithDecrement(String submitUserId, double totalIntegral);
}
