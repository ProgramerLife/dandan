##注解的学习
1、Annotation通用定义
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
}

@Deprecated  -- @Deprecated 所标注内容，不再被建议使用。
@Override    -- @Override 只能标注方法，表示该方法覆盖父类中的方法。
@Documented  -- @Documented 所标注内容，可以出现在javadoc中。
@Inherited   -- @Inherited只能被用来标注“Annotation类型”，它所标注的Annotation具有继承性。
@Retention   -- @Retention只能被用来标注“Annotation类型”，而且它被用来指定Annotation的RetentionPolicy属性。

![注解的保留策略有三种：SOURCE/ClASS/RUNTIME](./img/retention.jpg "retention策略")

@Target      -- @Target只能被用来标注“Annotation类型”，而且它被用来指定Annotation的ElementType属性。
@SuppressWarnings -- @SuppressWarnings 所标注内容产生的警告，编译器会对这些警告保持静默。

注解的格式：

public @interface 注解名称{
    属性列表;
}
类型：
自定义注解：
JDK内置注解：
第三方架构提供的的注解：


发射注解信息:
注解就像一个标签，是贴在程序代码上供另一个程序读取的。
三角关系：
    定义注解
    使用注解
    读取注解
