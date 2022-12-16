package com.ilovesshan.wjhs.core.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/15
 * @description:
 */
public class TransactionalException extends RuntimeException {
    public TransactionalException(String message) {
        super(message);
    }
}
