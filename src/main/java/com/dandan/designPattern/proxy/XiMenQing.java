package com.dandan.designPattern.proxy;

/**
 * @author houhuafei
 * @description 定义一个执行类：例如西门庆 水浒传中的色中恶鬼
 * @date 2021年06月16日 14:03
 */
public class XiMenQing {
    /**
     *水浒里是这样写的：西门庆被潘金莲用竹竿敲了一下。难道，痴迷了，
     * 被王婆看到了, 就开始撮合两人好事，王婆作为潘金莲的代理人
     * 收了不少好处费，那我们假设一下：
     * 如果没有王婆在中间牵线，这两个不要脸的能成吗？难说的很！
     */

    public static void main(String[] args) {
        // 代理人王婆出场
        System.out.println("西门庆勾引潘金莲。。。。。。。。。。。。。。。。");
        WangPo wangPo = new WangPo();
        // 然后西门庆就说，我要和潘金莲happy，然后王婆就安排了西门庆丢筷子的那出戏:
        wangPo.happyWithMan();
        wangPo.makeEyesWithMan();
        // 表面上看是王婆在做实际上爽的是潘金莲
        System.out.println("西门庆勾引贾氏，卢俊义的老婆。。。。。。。。。。。。。。。。");
        WangPo wangPo1 = new WangPo(new JiaShi());
        wangPo1.happyWithMan();
        wangPo1.makeEyesWithMan();
        System.out.println("西门庆勾引潘巧云，杨雄的老婆。。。。。。。。。。。。。。。。");
        WangPo wangPo2 = new WangPo(new PanQiaoYun());
        wangPo2.happyWithMan();
        wangPo2.makeEyesWithMan();
        /**
         * 代理模式主要使用了Java多态： 干活的是被代理类，代理类只负责接活。
         * 代理类和被代理类 实现相同的接口 所以代理类知道事情能不能干成。
         * 优点：
         *      1、代理模式能将代理对象与真实被调用的目标对象分离。
         *      2、一定程度上降低了系统的耦合度，扩展性好。
         *      3、可以起到保护目标对象的作用。
         *      4、可以对目标对象的功能增强。
         * 缺点：
         *      1、代理模式会造成系统设计中类的数量增加。
         *      2、在客户端和目标对象增加一个代理对象，会造成请求处理速度变慢。
         *      3、增加了系统的复杂度。
         *
         *
         *
         *
         */

    }

}
