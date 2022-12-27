package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.RecycleStatistical;
import com.ilovesshan.wjhs.beans.vo.RecycleStatisticalVo;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.mapper.RecycleStatisticalMapper;
import com.ilovesshan.wjhs.service.RecycleStatisticalService;
import com.ilovesshan.wjhs.utils.DateUtil;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/24
 * @description:
 */

@Service
public class RecycleStatisticalServiceImpl implements RecycleStatisticalService {

    @Autowired
    private RecycleStatisticalMapper recycleStatisticalMapper;

    @Override
    public boolean insert(RecycleStatistical recycleStatistical) {
        return recycleStatisticalMapper.insert(recycleStatistical) > 0;
    }

    @Override
    public RecycleStatisticalVo selectByType(String orderType, String userType) {
        List<RecycleStatistical> recycleStatisticals = recycleStatisticalMapper.selectListByType(orderType, userType, UserCache.get("userId"));
        int totalCount = 0;
        double currentMonthWeight = 0, accumulativeWeight = 0;
        if (!Objects.isNull(recycleStatisticals)) {
            totalCount = recycleStatisticals.size();

            for (RecycleStatistical recycleStatistical : recycleStatisticals) {
                // 累计统计
                accumulativeWeight += recycleStatistical.getWeight();
                // 本月统计
                if (DateUtil.isThisMonth(System.currentTimeMillis())) {
                    currentMonthWeight += recycleStatistical.getWeight();
                }
            }
        }
        return new RecycleStatisticalVo(UuidUtil.generator(), currentMonthWeight, accumulativeWeight, totalCount);
    }
}
