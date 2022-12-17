package com.ilovesshan.wjhs.beans.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Data
public class RecycleOrderCreateDto {
    @NotBlank(message = "用户ID不能为空")
    private String submitUserId;
    private String receiveUserId;
    @NotBlank(message = "订单类型不能为空")
    private String orderType;
    @NotBlank(message = "订单状态不能为空")
    private String status;
    @NotNull(message = "交易金额不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "交易金额必须大于0")
    @Digits(integer = 10, fraction = 2, message = "用户价格 最大长度:10，允许精度:2")
    private double tradingMoney;
    @NotNull(message = "订单总重量不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "订单总重量必须大于0")
    @Digits(integer = 10, fraction = 2, message = "订单总重量 最大长度:10，允许精度:2")
    private double totalWeight;
    @NotNull(message = "订单积分")
    @DecimalMin(value = "0", inclusive = false, message = "订单积分必须大于0")
    @Digits(integer = 10, fraction = 2, message = "订单积分 最大长度:10，允许精度:2")
    private double totalIntegral;
    @NotBlank(message = "上门地址ID不能为空")
    private String addressId;
    @Future(message = "预约时间段不正确")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date appointmentBeginTime;
    @Future(message = "预约时间段不正确")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date appointmentEndTime;
    private String note;
    private String noteAttachmentIds;
    private List<RecycleOrderDetailCreateDto> goodsList;
}
