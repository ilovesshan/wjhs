package com.ilovesshan.wjhs.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
    // 业务模块
    String businessModule();

    // 业务类型
    String businessType();

    // 描述信息
    String businessDescribe() default "";
}
