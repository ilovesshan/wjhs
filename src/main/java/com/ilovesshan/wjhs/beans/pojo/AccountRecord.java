package com.ilovesshan.wjhs.beans.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRecord {
    private String id;
    private String userTypeFrom;
    private String userTypeTo;
    private String userIdFrom;
    private String userIdTo;
    private String payStatus;
    private String tradingId;
    private double tradingMoney;
    private String tradingType;
    private String tradingNote;
    private String isDelete;
    private Date createTime;
    private Date updateTime;

}
