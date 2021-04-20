package com.dandan.selfAnnotation.junit;

import java.lang.annotation.*;

/**
 * 第一步骤：定义注解
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBefore {
}
