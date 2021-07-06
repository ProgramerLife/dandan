package com.dandan.multithread;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author houhuafei
 * @description 多线程＋1操作最快
 * @date 2021年06月21日 9:57
 */
public class AddOne {
    // 一个共享变量不断加一



}

// 直接写 会产生线程安全问题
class LongAdder{
    private Long count = 0L;
    public  void add(){
        count++;
    }
}

// 使用加锁实现 效率低 多台机器部署时没有效果
class LongAdders{
    private Long count = 0L;
    public  void add(){
        synchronized (this){
            count++;
        }
    }
}


// 可以用原子类这种乐观锁实现，比加 synchronized 锁效率高很多。
class LongAdderAto{
    private AtomicLong count = new AtomicLong(0L);
    public  void add(){
        synchronized (this){
            count.incrementAndGet();
        }
    }
}
