package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class RecycleOrderDetailVo {
  private String id;
  private String orderId;
  private String goodsId;
  private RecycleGoodsVo recycleGoods;
  private double weight;
  private String isDelete;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
