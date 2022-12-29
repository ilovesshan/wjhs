package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class UserFeedback {

    private String id;
    private String userId;
    private String userType;
    private String feedbackTitle;
    private String feedbackDetail;
    private String attachmentId;
    private Attachment attachment;
    private String isSolve;
    private String isDelete;
    private Date createTime;
    private Date updateTime;
}
