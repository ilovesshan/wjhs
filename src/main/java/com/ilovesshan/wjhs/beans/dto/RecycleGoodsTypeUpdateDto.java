package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class RecycleGoodsTypeUpdateDto {
    @NotEmpty(message = "回收商品分类ID不能为空")
    private String id;
    @NotEmpty(message = "分类名称不能为空")
    @Size(min = 2, max = 8, message = "分类名称长度在2到8个字符之间")
    private String name;
    private String describe;
    private String status;
}
