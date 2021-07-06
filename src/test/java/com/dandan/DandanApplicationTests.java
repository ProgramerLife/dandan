package com.dandan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest
class DandanApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testSys() {
        System.out.println("111111");
    }

    @Test
    void testArrayToString() {
        String[] strs = {"北京","上海","广州"};
        //System.out.println("字符串转数组："+Arrays.toString(strs));
        String str = Arrays.toString(strs);
        System.out.println("数组转字符串1："+str);
    }

    @Test
    public void testAdd(){
        Long a= 32L;
        Long b = 25L;
        Long total = 93L;
        BigDecimal bigDecimal = ((new BigDecimal(a).add(new BigDecimal(b))).divide(new BigDecimal(total),6,BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100));
        double sss = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(sss);
    }


}
