package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.RecycleStatistical;
import com.ilovesshan.wjhs.mapper.RecycleStatisticalMapper;
import com.ilovesshan.wjhs.service.RecycleStatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
