package com.ilovesshan.wjhs.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecycleStatisticalVo {
    private String id;
    private double currentMonthWeight;
    private double accumulativeWeight;
    private int totalCount;
}
