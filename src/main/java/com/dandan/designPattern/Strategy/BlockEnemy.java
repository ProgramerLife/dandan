package com.dandan.designPattern.Strategy;

/**
 * @author houhuafei
 * @description 孙夫人断后，挡住追兵
 * @date 2021年06月16日 13:22
 */
public class BlockEnemy implements IStrategy{
    @Override
    public void operate() {
        System.out.println("让孙夫人断后，挡住追兵");
    }
}
