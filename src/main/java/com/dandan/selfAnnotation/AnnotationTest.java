package com.dandan.selfAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class<DemoAnnotation> dt = DemoAnnotation.class;
        //获取类上的注解
        GoAway goAway = dt.getAnnotation(GoAway.class);
        System.out.println(goAway.value());

        //获取成员变量上的注解  字段需是public 的才能获取到
        Field name = dt.getField("value");
        GoAway field = name.getAnnotation(GoAway.class);
        System.out.println(field.value());

        //获取方法上的注解
        Method  method = dt.getMethod("returnString", (Class<?>[]) null);
        GoAway methodAnno = method.getAnnotation(GoAway.class);
        System.out.println(methodAnno.value());

        // 获取defaultMethod方法上的注解
        Method defaultMethod = dt.getMethod("defaultMethod", (Class<?>[]) null);
        GoAway annotationOnDefaultMethod = defaultMethod.getAnnotation(GoAway.class);
        System.out.println(annotationOnDefaultMethod.value());

    }

}
