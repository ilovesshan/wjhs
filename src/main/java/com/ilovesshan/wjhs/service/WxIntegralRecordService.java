package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.WxIntegralRecord;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */
public interface WxIntegralRecordService {
    boolean insert(WxIntegralRecord integralRecord);

    List<WxIntegralRecord> selectListByUserId(String userId);
}
