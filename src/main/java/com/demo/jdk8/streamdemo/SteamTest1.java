package com.demo.jdk8.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建一个流的几种方式
 */
public class SteamTest1 {
    public static void main(String[] args) {
        Stream stream=Stream.of("hello","world","hello world");
        String[] myArray=new String[]{"hello","world","hello world"};
        Stream stream1=Stream.of(myArray);
        Stream stream2=Arrays.stream(myArray);
        List<String> list=Arrays.asList(myArray);
        Stream<String> stream3 = list.stream();
    }
}
