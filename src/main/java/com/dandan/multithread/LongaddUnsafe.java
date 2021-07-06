package com.dandan.multithread;

import sun.misc.Unsafe;

/**
 * @author houhuafei
 * @description
 * @date 2021年06月21日 11:25
 */
public class LongaddUnsafe {
        /*private volatile long countOffset = 0L;
        public void add() {
            boolean success = false;
            long v = countOffset;
            while(!success) {
                success = Unsafe.compareAndSwapLong(
                        LongAdder.class, countOffset, v, v + 1);
            }
        }*/
}
