package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class NoticeVo {
  private String id;
  private String type;
  private String title;
  private String subTitle;
  private String detail;
  private String link;
  private AttachmentVo attachment;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
