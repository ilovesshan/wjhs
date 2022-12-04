package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
  private String id;
  private String type;
  private String title;
  private String subTitle;
  private String detail;
  private String link;
  private String isDelete;
  private Date createTime;
  private Date updateTime;
  private Attachment attachment;

}
