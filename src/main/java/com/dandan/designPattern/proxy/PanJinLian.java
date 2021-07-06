package com.dandan.designPattern.proxy;

/**
 * @author houhuafei
 * @description 潘金莲类
 * @date 2021年06月16日 13:55
 */
public class PanJinLian implements KindWomen{
    @Override
    public void happyWithMan() {
        System.out.println("潘金莲和西门庆开心。。。。。。。");
    }

    @Override
    public void makeEyesWithMan() {
        System.out.println("潘金莲和西门庆抛媚眼。。。。。。");
    }
}
