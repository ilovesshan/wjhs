package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserFeedbackVo {

    private String id;
    private String userId;
    private String userType;
    private String feedbackTitle;
    private String feedbackDetail;
    private String attachmentId;
    private String isSolve;
    private AttachmentVo attachment;
    private String isDelete;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
