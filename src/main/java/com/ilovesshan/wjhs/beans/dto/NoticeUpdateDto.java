package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NoticeUpdateDto {
    @NotEmpty(message = "公告ID不能为空")
    private String id;
    @NotEmpty(message = "创建类型不能为空")
    private String type;
    @NotEmpty(message = "创建标题不能为空")
    private String title;
    private String subTitle;
    private String detail;
    private String link;
}
