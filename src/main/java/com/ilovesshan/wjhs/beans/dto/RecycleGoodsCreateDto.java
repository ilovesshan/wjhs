package com.ilovesshan.wjhs.beans.dto;

import com.ilovesshan.wjhs.utils.RegexpUtil;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RecycleGoodsCreateDto {
    @NotEmpty(message = "回收商品ID不能为空")
    private String typeId;

    @NotEmpty(message = "回收商品名称不能为空")
    @Size(min = 2, max = 8, message = "回收商品名称长度在2到8个字符之间")
    private String name;

    private String describe;

    @NotEmpty(message = "回收商品附件ID不能为空")
    private String attachmentId;

    @Min(value = 1, message = "兑换积分最小不能低于1")
    @Max(value = 10, message = "兑换积分最大不能大于10")
    private double integral;

    @NotEmpty(message = "用户价格不能为空")
    @Pattern(regexp = RegexpUtil.MONEY_REGEXP, message = "用户价格不正确")
    private double userPrice;

    @NotEmpty(message = "骑手价格不能为空")
    @Pattern(regexp = RegexpUtil.MONEY_REGEXP, message = "骑手价格不正确")
    private double driverPrice;

    @NotEmpty(message = "回收中心价格不能为空")
    @Pattern(regexp = RegexpUtil.MONEY_REGEXP, message = "回收中心价格不正确")
    private double recycleCenterPrice;
}
