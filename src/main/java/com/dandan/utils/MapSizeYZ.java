package com.dandan.utils;

import java.util.HashMap;
import java.util.Map;

public class MapSizeYZ {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        map.put("4","1");
        map.put("5","1");
        map.put("6","1");
        map.put("7","1");
        map.put("8","1");
        map.put("9","1");
        map.put("10","1");
        map.put("11","1");
        map.put("Aa","1");
        System.out.println("map长度:"+map.size()+"");
        map.put("BB","1");
        System.out.println("map长度:"+map.size()+"");
        map.put("Bw","1");
        map =null;
    }
}
