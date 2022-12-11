package com.ilovesshan.wjhs.beans.pojo;
import lombok.Data;

import java.util.Date;

@Data
public class RecycleGoodsType {
  private String id;
  private String name;
  private String describe;
  private String isDelete;
  private String status;
  private Date createTime;
  private Date updateTime;
}
