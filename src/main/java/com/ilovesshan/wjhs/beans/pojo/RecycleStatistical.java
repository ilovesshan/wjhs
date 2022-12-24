package com.ilovesshan.wjhs.beans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecycleStatistical {

    private String id;
    private String orderId;
    private String submitUserId;
    private String receiveUserId;
    private double weight;
    private String orderType;
    private String isDelete;
    private Date createTime;
    private Date updateTime;

}
