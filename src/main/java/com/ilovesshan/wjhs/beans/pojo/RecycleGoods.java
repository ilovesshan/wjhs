package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class RecycleGoods {

  private String id;
  private String typeId;
  private String name;
  private String describe;
  private String attachmentId;
  private double integral;
  private double userPrice;
  private double driverPrice;
  private double recycleCenterPrice;
  private Attachment attachment;
  private String isDelete;
  private String status;
  private Date createTime;
  private Date updateTime;
}
