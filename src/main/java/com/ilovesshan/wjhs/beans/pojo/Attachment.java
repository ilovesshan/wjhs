package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Attachment {
  private String id;
  private String url;
  private String createByUserId;
  private String createByUserName;
  private String createByUserType;
  private String isDelete;
  private Date createTime;
  private Date updateTime;
}
