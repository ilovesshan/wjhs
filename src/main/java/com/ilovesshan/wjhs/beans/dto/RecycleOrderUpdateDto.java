package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RecycleOrderUpdateDto {
    @NotBlank(message = "订单ID不能为空")
    private String id;

    @NotBlank(message = "订单状态不能为空")
    private String status;

    private String receiveUserId;
}
