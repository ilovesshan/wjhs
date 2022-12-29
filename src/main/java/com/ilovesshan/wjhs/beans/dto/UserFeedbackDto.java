package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserFeedbackDto {
    @NotNull(message = "反馈标题不能为空")
    @Size(max = 32, min = 6, message = "反馈标题长度在6到32个字符之间")
    private String feedbackTitle;
    private String feedbackDetail;
    private String attachmentId;
}
