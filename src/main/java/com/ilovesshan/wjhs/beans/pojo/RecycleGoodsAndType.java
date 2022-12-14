package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RecycleGoodsAndType {
  private String id;
  private String name;
  private String describe;
  private String isDelete;
  private String status;
  private List<RecycleGoods> recycleGoods;
  private Date createTime;
  private Date updateTime;
}
