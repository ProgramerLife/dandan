package com.dandan.selfAnnotation.junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 第三步骤：读取注解
 */
public class MyJunitFrameWork {
    public static void main(String[] args) throws Exception {
        // 1.先找到测试类的字节码：EmployeeDAOTest
        Class<EmployeeDAOTest> clazz = EmployeeDAOTest.class;
        Object obj = clazz.newInstance();

        //2、获取所有公用方法
        Method[] methods = clazz.getMethods();

        // 3.迭代出每一个Method对象，判断哪些方法上使用了@MyBefore/@MyAfter/@MyTest注解
        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();
        for(Method method : methods){
            //isAnnotationPresent 某个注解是否在该（方法类字段）上
            if(method.isAnnotationPresent(MyBefore.class)){
                myBeforeList.add(method);
            }else if(method.isAnnotationPresent(MyAfter.class)){
                myAfterList.add(method);
            }else if(method.isAnnotationPresent(MyTest.class)){
                myTestList.add(method);
            }
        }
        //4、执行方法测试
        for(Method testMethod: myTestList){
            // 先执行@MyBefore的方法
            for(Method beforeMethod: myBeforeList){
                beforeMethod.invoke(obj);
            }
            // 测试方法
            testMethod.invoke(obj);
            // 最后执行@MyAfter的方法
            for (Method afterMethod : myAfterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}
