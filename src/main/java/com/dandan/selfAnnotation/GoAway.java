package com.dandan.selfAnnotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface GoAway {
    String value() default "1234456789";//在注解里这个叫属性



}
