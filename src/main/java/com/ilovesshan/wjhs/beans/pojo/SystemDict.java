package com.ilovesshan.wjhs.beans.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class SystemDict {

  private String id;
  private long dictCode;
  private String dictName;
  private String dictDescribe;
  private long sort;
  private String createBy;
  private String createByUserId;
  private String updateBy;
  private String updateByUserId;
  private String isDelete;
  private Date createTime;
  private Date updateTime;

}
