package com.ilovesshan.wjhs.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */
public class SystemUtil {
    /**
     * 当前系统环境是否是 windows
     *
     * @return boolean
     */
    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("win");
    }
}
