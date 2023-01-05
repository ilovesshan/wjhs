package com.ilovesshan.wjhs.beans.dto;

import lombok.Data;

@Data
public class AppVersionUpgradeDto {
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
}
