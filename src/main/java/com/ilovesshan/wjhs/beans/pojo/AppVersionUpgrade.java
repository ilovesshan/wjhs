package com.ilovesshan.wjhs.beans.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class AppVersionUpgrade {

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
    private Date createTime;
    private Date updateTime;
}
