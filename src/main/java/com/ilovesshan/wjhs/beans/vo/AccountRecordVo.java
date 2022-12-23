package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AccountRecordVo {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
