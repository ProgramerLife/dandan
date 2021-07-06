package com.dandan.designPattern.proxy;

/**
 * @author houhuafei
 * @description 另一个荡妇：贾氏
 * @date 2021年06月16日 14:09
 */
public class JiaShi implements KindWomen{
    @Override
    public void happyWithMan() {
        System.out.println("贾氏和西门庆happy...........");
    }

    @Override
    public void makeEyesWithMan() {
        System.out.println("贾氏和西门庆抛媚眼...........");
    }
}
