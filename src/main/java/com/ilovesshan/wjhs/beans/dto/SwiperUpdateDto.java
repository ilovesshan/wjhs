package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SwiperUpdateDto {

  @NotEmpty(message = "轮播图ID不能为空")
  private String id;
  @NotEmpty(message = "轮播图类型不能为空")
  private String type;
  @NotEmpty(message = "附件ID不能为空")
  private String attachmentId;
  private String title;
  private String subTitle;
  private String detail;
  private String link;
  @NotEmpty(message = "删除状态不能为空")
  private String isDelete;
}
