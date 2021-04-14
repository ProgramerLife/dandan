package com.dandan.reflectDemo;

import com.dandan.reflectDemo.entity.Students;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 反射的基本使用练习
 */
public class ReflectDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, IOException {
        /**
         * 1、获取Class 的三种方法
         * （1）Object-->getClass
         *
         * （2）任何数据类型（包括基本的数据类型）都有一个“静态”的class属性
         *
         * （3）通过class类的静态方法：forName(String className)（最常用）
         */
         //第一种
        Students students = new Students();//new 产生一个students 实例 一个class 对象
        Class stuClass1 = students.getClass();//获取class对象
        System.out.println("反射获取对象名称："+stuClass1.getName());//com.dandan.reflectDemo.entity.Students
        //第二种
        Class stuClass2 = Students.class;
        //判断第一种方式生成的对象和第二种方式生成的对象是不是一个
        System.out.println("第二种方式："+(stuClass2 == stuClass1));//true  是同一个
        //第三种方式
        try {
            //注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            Class stuClass3 = Class.forName("com.dandan.reflectDemo.entity.Students");
            System.out.println("第三种方式："+(stuClass3 == stuClass2));//判断三种方式是否获取的是同一个Class对象
            //true  是同一个
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        /**
         * 注：在运行期间一个类仅产生一个class对象 所以结果为true
         * 三种方式中，常用第三种，
         * 第一种对象都有了还要反射干什么，
         * 第二种需要导入类包，依赖太强，不导包就抛编译错误。一
         * 般都使用第三种，一个字符串可以传入也可以写在配置文件中等多种方法。
         *
         */

        //-----------------------------------------------------

        //2、判断是否为某个类的示例：
        try {
            //根据路径创建对象 获取方法 对象 也可以直接点
            Students students1 = (Students)Class.forName("com.dandan.reflectDemo.entity.Students").newInstance();
            /**
             * instanceof 关键字判断是否为某个对象的实例
             * 也可以借助发射 使用Class对象的isInstance 方法判断是否为某个对象的实例
             */
            System.out.println("Class类的isInstance 用法:"+stuClass2.isInstance(students1));
            System.out.println("instanceof 用法:"+(students1 instanceof Students));
        } catch (Exception e) {
            e.printStackTrace();
        }


        //-----------------------------------

        /**
         * 3、创建实例：通过反射创建实例的两种方法
         */
        //1、使用newInstance()方法
        Class stuClass4 = Students.class;
        try {
            Object object = stuClass4.newInstance();
            Students students1 = (Students)object;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //2先通过Class对象获取指定的Constructor对象，
        // 再调用Constructor对象的newInstance()方法来创建对象，
        // 这种方法可以用指定的构造器构造类的实例
        Class stuClass5 = Students.class;
        try {
            Constructor constructor=stuClass5.getConstructor();
            //空构造
            Object object = constructor.newInstance();
            Students students1 = (Students)object;
            //有参构造
            /*Object object1 = constructor.newInstance("满满",0,0,"广泛");
            Students students2 = (Students)object1;*/
            Students students3 = new Students("满满",0,0,"广泛");
            System.out.println("有参无参方法："+students1.getStudentName()+"--"+students1.getHobby());
            System.out.println("students3："+students3.getStudentName()+","+students3.getHobby());
            //newInstance():弱类型,效率低,只能调用无参构造
            //new():强类型,高效率,能调用任何public构造器
        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------------------------------------------------

        //4、通过反射获取构造方法并使用

        //获取公有的构造方法
        Constructor[] constructors = Students.class.getConstructors();
        System.out.println("Students的公有构造方法："+ Arrays.toString(constructors));
        //获取所有的构造方法(包括私有、受保护、默认、公有)
        Constructor[] constructors1 = Students.class.getDeclaredConstructors();
        System.out.println("Students的所有构造方法："+ Arrays.toString(constructors1));
        //获取构造方法并使用
        try {
            Constructor  constructor = Students.class.getDeclaredConstructor(String.class);
            try {
                Object obj = constructor.newInstance("123");
                Students students1 = (Students)obj;
                System.out.println("获取构造方法并赋值"+students1.getStudentName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------------------------------------------------

        /**
         * 5、获取成员变量并调用
         * 1.批量的
         *  * 		1).Field[] getFields():获取所有的"公有字段"
         *  * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
         *  * 2.获取单个的：
         *  * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
         *  * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
         *  *
         *  * 	 设置字段的值：
         *  * 		Field --> public void set(Object obj,Object value):
         *  * 					参数说明：
         *  * 					1.obj:要设置的字段所在的对象；
         *  * 					2.value:要为字段设置的值；
         *
         */
        Field[] fields = Students.class.getFields();
        System.out.println("反射获取公有字段:"+Arrays.toString(fields));
        Field[] fields2 = Students.class.getDeclaredFields();
        System.out.println("反射获取公有字段:"+Arrays.toString(fields2));
        try {
            Field field = Students.class.getField("addr") ;
            System.out.println(field+","+field.getName());
            //获取一个对象
            try {
                Object obj = Students.class.getConstructor().newInstance();//使用构造方法创建一个对象 无参构造
                //为字段设值
                field.set(obj,"中国-山东-菏泽");
                Students students1 = (Students)obj;
                System.out.println("获取字段并赋值："+students1.getAddr());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        //获取是由字段并赋值
        try {
            Field f = Students.class.getDeclaredField("studentName");
            System.out.println(f);
            Object obj = Students.class.getConstructor().newInstance();//使用构造方法创建一个对象 无参构造
            f.setAccessible(true);//暴力反射，解除私有限定
            f.set(obj, "满满");
            Students stu = (Students)obj;
            System.out.println("学生姓名为：" + stu.getStudentName());
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------------------------------------------------

        /*
         * 7、获取成员方法并调用：
         * 1.批量的：
         * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
         * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
         * 2.获取单个的：
         * 		public Method getMethod(String name,Class<?>... parameterTypes):
         * 					参数：
         * 						name : 方法名；
         * 						Class ... : 形参的Class类型对象
         * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
         *
         * 	 调用方法：
         * 		Method --> public Object invoke(Object obj,Object... args):
         * 					参数说明：
         * 					obj : 要调用方法的对象；
         * 					args:调用方式时所传递的实参；
        *):
        */
        Method[] methods1 = Students.class.getMethods();
        Method[] methods2 = Students.class.getDeclaredMethods();
        System.out.println("公有方法"+Arrays.toString(methods1)+",所有方法："+Arrays.toString(methods2));
        Method method1 = Students.class.getMethod("show1",String.class);
        System.out.println("获取方法："+method1);
        //调用方法并执行
        Object obj = Students.class.getConstructor().newInstance();
        method1.invoke(obj, "刘德华");

        System.out.println("***************获取私有的sayHi()方法******************");
        Method m = Students.class.getDeclaredMethod("sayHi", String.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, "20");//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);

        //--------------------------------------------------------------------------------------------------------------
        //7、反射main方法：
        Method method3 = Students.class.getMethod("main", String[].class);//第一个参数：方法名称，第二个参数：方法形参的类型，
        //3、调用main方法
        // methodMain.invoke(null, new String[]{"a","b","c"});
        //第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
        //这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。
        method3.invoke(null, (Object)new String[]{"a","b","c"});//方式一
        // methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});//方式二

        //--------------------------------------------------------------------------------------------------------------

        //8、利用反射创建数值：
        Class<?> classStr = Class.forName("java.lang.String");
        Object array = Array.newInstance(classStr,25);
        //添加内容
        Array.set(array,0,"golang");
        Array.set(array,1,"Java");
        Array.set(array,2,"pytho");
        Array.set(array,3,"Scala");
        Array.set(array,4,"Clojure");
        System.out.println(Arrays.toString((String[])array));
        System.out.println(Array.get(array,3));

        //--------------------------------------------------------------------------------------------------------------

        /**
         * 9、反射方法的其他使用--通过反射运行配置文件内容： 配置文件的使用就是这样搞得
         */
        //获取对象
         Class txtclass = Class.forName(getValue("className"));
         //的获取方法
        Method method = txtclass.getDeclaredMethod(getValue("method"),String.class);
        method.setAccessible(true);//解除私有限定.
        //创建一个对象 执行方法；
        method.invoke(txtclass.getConstructor().newInstance(),"123");

        //--------------------------------------------------------------------------------------------------------------

        /**10、通过反射越过泛型检查
         * 泛型用在编译期，编译过后泛型擦除（消失掉），所以是可以通过反射越过泛型检查的
         */
        List<BigDecimal> strList = new ArrayList<BigDecimal>(){{
            add(new BigDecimal("1"));
            add(new BigDecimal("2"));
            add(new BigDecimal("3"));
        }};
        //获取方法添加值
        Method method2 = strList.getClass().getMethod("add",Object.class);
        method2.invoke(strList,"abc");
        System.out.println(Arrays.toString(strList.toArray()));
    }
    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("src/main/resources/reflect.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
