package com.dandan.datastructure;

/**
 * 简单算法
 */
public class SumUp {
    //递归实现 求和1 到某个数个和
    public int sum(int num){
        if(num > 1){
            return num+sum(num-1);
        }else{
            return 1;
        }
    }

    //斐波那契额数列
    public int fbnqsl(int num){
        if(num == 1 || num == 2){
            return 1;
        }else{
            return fbnqsl(num -1)+fbnqsl(num -2);
        }
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        SumUp sumUp = new SumUp();
        //System.out.println(""+sumUp.sum(100));
        //System.out.println(""+sumUp.fbnqsl(7));
        int a = hash("aa");
        System.out.println(a);
       int b = 2 << 2;
        System.out.println(b);
    }
}
