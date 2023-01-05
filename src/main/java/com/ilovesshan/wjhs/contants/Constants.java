package com.ilovesshan.wjhs.contants;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/28
 * @description:
 */
public class Constants {
    // JWT有效期(1天)
    public static final Long JWT_EXPIRATION = 1000 * 60 * 60 * 24L;

    // JWT有效期(1天)
    public static final String APK_MD5_KEY = "FF:DF:F8:96:29:E0:E2:C5:8C:74:A5:2F:14:0E:BA:1E";

    // JWT令牌信息
    public static final String JWT_KEY = "RANDOM";

    // 请求头键
    public static final String HEADER_KEY = "Authorization";

    // 请求头值(前缀)
    public static final String HEADER_VALUE_PREFIX = "Bearer ";

    // 小程序请求头值(前缀)
    public static final String HEADER_WX_VALUE_PREFIX = "Openid ";

    // redis中缓存用户信息(前缀)
    public static final String REDIS_USER_PREFIX = "user:";

    // redis中缓存小程序用户信息(前缀)
    public static final String REDIS_WX__USER_PREFIX = "wx:";

    // 附件上传地址(windows)
    public static final String ATTACHMENT_UPLOAD_WINDOWS_DEST = "D:/www/wjhs/upload/";

    // 附件上传地址(linux)
    public static final String ATTACHMENT_UPLOAD_LINUX_DEST = "/home/www/wjhs/upload/";

    // 附件预览前缀
    public static final String ATTACHMENT_PREVIEW_PREFIX = "/preview/";

    // app上传地址(windows)
    public static final String APP_UPLOAD_WINDOWS_DEST = "D:/www/wjhs/upload/app/";

    // app上传地址(linux)
    public static final String APP_UPLOAD_LINUX_DEST = "/home/www/wjhs/upload/app/";

    // app下载前缀
    public static final String APP_DOWNLOAD_PREFIX = "/apk/";

}
