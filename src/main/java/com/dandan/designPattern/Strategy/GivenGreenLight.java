package com.dandan.designPattern.Strategy;

/**
 * @author houhuafei
 * @description 求吴国太开绿灯
 * @date 2021年06月16日 13:16
 */
public class GivenGreenLight implements IStrategy{
    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯，放行");
    }
}
