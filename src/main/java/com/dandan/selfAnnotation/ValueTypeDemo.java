package com.dandan.selfAnnotation;

@MyAnnotationValueType(
        byteValue = 1,
        shortValue = 1,
        intVlaue =1,
        longValue = 1L,
        floatValue = 2.0f,
        doubleValue = 3.3,
        booleanValue = true,
        charValue = 'a',
        //String
        stringValue = "string",
        //enum 枚举类型
        enumValue = CityName.BeiJIng,
        //class类型
       calssz  = DemoAnnotation.class,
        //注解类型
        goAway = @GoAway,

        //以上类型的一维数组类型
        intArrayValue = {1,2,3,4,5}
)
public class ValueTypeDemo {
}
