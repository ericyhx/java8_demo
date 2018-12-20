package com.demo.jdk8.streamdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/20
 */
public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long s=System.currentTimeMillis();
//        list.stream().sorted();
        list.parallelStream().sorted();
        System.out.println(System.currentTimeMillis()-s);
    }
}
