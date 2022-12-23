package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RecycleOrderVo {
    private String id;
    private String submitUserId;
    private String receiveUserId;
    private String orderType;
    private String status;
    private double tradingMoney;
    private double totalWeight;
    private double totalIntegral;
    private String addressId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date appointmentBeginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date appointmentEndTime;
    private String note;
    private String noteAttachmentIds;
    private List<RecycleOrderDetailVo> recycleOrderDetails;
    private List<AttachmentVo> attachments;
    private AddressVo address;
    private UserVo receiveUser;
    private String isDelete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
