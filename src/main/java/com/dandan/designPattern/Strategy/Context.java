package com.dandan.designPattern.Strategy;

/**
 * @author houhuafei
 * @description: 计谋有了，那还要有锦囊 这个类即为锦囊类
 *              赵云带着这个锦囊就出发了
 * @date 2021年06月16日 13:24
 */
public class Context {
    // 构造函数 你要使用哪个锦囊
    private IStrategy strategy;

    public Context(IStrategy strategy){
        this.strategy = strategy;
    }

    // 使用计谋了 看我出招
    public void operate(){
        this.strategy.operate();
    }
}
