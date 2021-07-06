package com.dandan.designPattern.Strategy;

/**
 * 功能描述 : 策略接口：例如诸葛亮给赵云的锦囊接口 每个接口有一个执行方法
 * @author houhuafei
 * @date 2021/6/16
 * 策略模式： 提供
 *
 *
 */
public interface IStrategy {

    // 每个锦囊妙计有一个执行方法
    void operate();
}
