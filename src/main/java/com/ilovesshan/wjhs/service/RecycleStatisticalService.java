package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.RecycleStatistical;
import com.ilovesshan.wjhs.beans.vo.RecycleStatisticalVo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */
public interface RecycleStatisticalService {
    boolean insert(RecycleStatistical recycleStatistical);

    RecycleStatisticalVo selectByType(String orderType, String userType);
}
