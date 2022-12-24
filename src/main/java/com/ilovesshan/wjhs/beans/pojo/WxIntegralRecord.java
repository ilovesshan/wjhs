package com.ilovesshan.wjhs.beans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxIntegralRecord {

    private String id;
    private String userId;
    private String orderId;
    private String payStatus;
    private double tradingIntegral;
    private String isDelete;
    private Date createTime;
    private Date updateTime;

}
