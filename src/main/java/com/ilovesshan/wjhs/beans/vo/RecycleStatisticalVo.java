package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RecycleStatisticalVo {

    private String id;
    private String orderId;
    private String submitUserId;
    private String receiveUserId;
    private double weight;
    private String orderType;
    private String isDelete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
