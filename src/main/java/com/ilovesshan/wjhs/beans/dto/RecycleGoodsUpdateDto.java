package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RecycleGoodsUpdateDto {
    @NotBlank(message = "回收商品ID不能为空")
    private String id;

    @NotBlank(message = "回收商品ID不能为空")
    private String typeId;

    @NotBlank (message = "回收商品名称不能为空")
    @Size(min = 2, max = 8, message = "回收商品名称长度在2到8个字符之间")
    private String name;

    private String status;
    private String describe;

    @NotBlank (message = "回收商品附件ID不能为空")
    private String attachmentId;

    @NotNull(message = "兑换积分不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "兑换积分必须大于0")
    @Digits(integer = 10, fraction = 2, message = "兑换积分 最大长度:10，允许精度:2")
    private double integral;

    @NotNull(message = "用户价格不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "用户价格必须大于0")
    @Digits(integer = 10, fraction = 2, message = "用户价格 最大长度:10，允许精度:2")
    private double userPrice;

    @NotNull(message = "骑手价格不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "骑手价格必须大于0")
    @Digits(integer = 10, fraction = 2, message = "骑手价格 最大长度:10，允许精度:2")
    private double driverPrice;

    @NotNull(message = "回收中心价格不能为空")
    @DecimalMin(value = "0", inclusive = false, message = "回收中心价格必须大于0")
    @Digits(integer = 10, fraction = 2, message = "回收中心价格 最大长度:10，允许精度:2")
    private double recycleCenterPrice;
}
