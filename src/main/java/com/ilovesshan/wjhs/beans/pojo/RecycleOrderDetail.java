package com.ilovesshan.wjhs.beans.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class RecycleOrderDetail {
  private String id;
  private String orderId;
  private String goodsId;
  private double weight;
  private RecycleGoods recycleGoods;
  private String isDelete;
  private Date createTime;
  private Date updateTime;
}
