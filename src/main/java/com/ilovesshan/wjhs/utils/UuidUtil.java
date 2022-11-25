package com.ilovesshan.wjhs.utils;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/24
 * @description:
 */
public class UuidUtil {
    public static String generator() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}