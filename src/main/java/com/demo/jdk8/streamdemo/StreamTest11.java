package com.demo.jdk8.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/20
 */
public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello",
                "hello world hello", "hello welcome");
        list.stream().map(s->s.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }
}
