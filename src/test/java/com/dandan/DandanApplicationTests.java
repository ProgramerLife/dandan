package com.dandan;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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


}
