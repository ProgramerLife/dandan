package com.dandan.designPattern.Strategy;

/**
 * @author houhuafei
 * @description 策略模式：实现接口之找乔国老帮吗
 * @date 2021年06月16日 13:14
 */
public class BackDoor implements IStrategy{
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
