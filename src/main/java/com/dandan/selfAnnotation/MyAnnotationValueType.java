package com.dandan.selfAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationValueType {
    //八种基本数据类型
    byte byteValue();
    short shortValue();
    int intVlaue();
    long longValue();
    float floatValue();
    double doubleValue();
    boolean booleanValue();
    char charValue();
    //String
    String stringValue();
    //enum 枚举类型
    CityName enumValue();
    //class类型
    Class<?> calssz();
    //注解类型
    GoAway goAway();

    //以上类型的一维数组类型
    int[] intArrayValue();
    //......

}
