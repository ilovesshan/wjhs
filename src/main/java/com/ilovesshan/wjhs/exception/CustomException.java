package com.ilovesshan.wjhs.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/14
 * @description:
 */

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
