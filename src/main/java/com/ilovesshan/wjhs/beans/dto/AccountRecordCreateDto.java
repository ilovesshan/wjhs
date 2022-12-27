package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Data
public class AccountRecordCreateDto {
    @NotNull(message = "收入账户ID不能为空")
    private String userIdFrom;
    @NotNull(message = "支出账户ID不能为空")
    private String userIdTo;

    @NotNull(message = "收入账户类型不能为空")
    private String userTypeFrom;
    @NotNull(message = "支出账户类型不能为空")
    private String userTypeTo;


    @NotNull(message = "交易金额不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "交易金额必须大于0")
    @Digits(integer = 10, fraction = 2, message = "用户价格 最大长度:10，允许精度:2")
    private double tradingMoney;

    private String tradingNote;
}
