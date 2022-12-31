package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RecycleOrder {
    private String id;
    private String submitUserId;
    private String receiveUserId;
    private String orderType;
    private String status;
    private String sendToRecycleCenter;
    private double tradingMoney;
    private double totalWeight;
    private double totalIntegral;
    private String addressId;
    private Date appointmentBeginTime;
    private Date appointmentEndTime;
    private String note;
    private String noteAttachmentIds;
    private List<RecycleOrderDetail> recycleOrderDetails;
    private List<Attachment> attachments ;
    private User receiveUser;
    private Address address;
    private String isDelete;
    private Date createTime;
    private Date updateTime;
}
