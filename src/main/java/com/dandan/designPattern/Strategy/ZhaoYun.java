package com.dandan.designPattern.Strategy;

/**
 * @author houhuafei
 * @description 策略模式
 * @date 2021年06月16日 10:59
 */
public class ZhaoYun {
    // 赵云出场了 他依据诸葛亮的交代一次拆开妙计
    public static void main(String[] args) {
        Context context;
        // 刚刚到吴国开第一个
        System.out.println("刚刚到吴国开第一个");
        context = new Context(new BackDoor());
        context.operate(); // 执行第一个锦囊
        // 刘备乐不思蜀 开第二个锦囊
        System.out.println("刘备乐不思蜀 开第二个锦囊");
        context = new Context(new GivenGreenLight());
        context.operate(); // 执行第二个锦囊
        // 孙权的小兵追了，咋办？拆第三个
        System.out.println("孙权的小兵追了，咋办？拆第三个");
        context = new Context(new BlockEnemy());
        context.operate(); // 执行第三个锦囊
        System.out.println("刘备顺利回到蜀国！");
    }
    /**
     * 策略模式：
     *    优点： 1、体现了高内聚低耦合的特性；
     *          2、策略模式符合开闭原则；
     *          3、避免使用多重条件转移语句，如if...else...语句、switch 语句；
     *          4、使用策略模式可以提高算法的保密性和安全性。
     *    缺点：1、客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，
     *            以便适时选择恰当的算法类。换言之，策略模式只适用于客户端知道所有的算法或行为的情况。
     *         2、 策略模式造成很多的策略类，每个具体策略类都会产生一个新类。
     *
     *
     *    类似于将公共部分提取出来，不同的处理方式给与不同的实现。然后使用者根据直接的需求选择不同的实现。前提是使用者知道有哪些实现
     */



}
