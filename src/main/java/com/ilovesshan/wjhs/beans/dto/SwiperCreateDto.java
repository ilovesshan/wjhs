package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SwiperCreateDto {
    @NotBlank(message = "创建类型不能为空")
    private String type;

    @NotBlank(message = "附件ID不能为空")
    private String attachmentId;
    private String title;
    private String subTitle;
    private String detail;
    private String link;
}
