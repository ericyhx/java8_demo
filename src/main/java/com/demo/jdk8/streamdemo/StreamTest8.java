package com.demo.jdk8.streamdemo;

import java.util.stream.IntStream;

/**
 * @Description:去重
 * @author: yuhongxi
 * @date:2018/12/20
 */
public class StreamTest8 {
    public static void main(String[] args) {
//        IntStream.iterate(0,i->(1+i)%2).distinct().forEach(System.out::println);
//        IntStream.iterate(0,i->(1+i)%2).distinct().limit(6).forEach(System.out::println);
        IntStream.iterate(0,i->(1+i)%2).limit(6).distinct().forEach(System.out::println);

    }
}
