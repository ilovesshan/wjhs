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

    // JWT令牌信息
    public static final String JWT_KEY = "RANDOM";

    // 请求头键
    public static final String HEADER_KEY = "Authorization";

    // 请求头值(前缀)
    public static final String HEADER_VALUE_PREFIX = "Bearer ";

    // redis中缓存用户信息(前缀)
    public static final String REDIS_USER_PREFIX = "user:";

}
