package com.ilovesshan.wjhs.beans.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/1/4
 * @description:
 */

@Data
public class AppVersionUpdateVo {
    ///是否有新版本
    private boolean hasUpdate;

    ///是否强制安装：不安装无法使用app
    @JsonProperty("isForce")
    private boolean isForce;

    ///是否可忽略该版本
    @JsonProperty("isIgnorable")
    private boolean isIgnorable;

    ///版本号
    private int versionCode;

    ///版本名称
    private String versionName;

    ///更新内容
    private String updateContent;

    ///下载地址
    private String downloadUrl;

    ///apk的大小
    private int apkSize;

    ///apk文件的加密值（这里默认是md5值）
    private String apkMd5;
}
