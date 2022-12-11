package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class RecycleGoodsVo {
  private String id;
  private String typeId;
  private String name;
  private String describe;
  private String attachmentId;
  private double integral;
  private double userPrice;
  private double driverPrice;
  private double recycleCenterPrice;
  private AttachmentVo attachment;
  private String status;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
