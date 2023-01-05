package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AppVersionUpgradeVo {

  private String id;
  private String updateStatus;
  private String versionCode;
  private String versionName;
  private long major;
  private long minor;
  private long patch;
  private String modifyContent;
  private String downloadUrl;
  private long apkSize;
  private String apkMd5;
  private String isDelete;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createTime;
}
