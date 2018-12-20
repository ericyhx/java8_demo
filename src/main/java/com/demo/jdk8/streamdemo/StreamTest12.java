package com.demo.jdk8.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/20
 */
public class StreamTest12 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        list1.stream().flatMap(item->list2.stream().map(name->item+" "+name)).forEach(System.out::println);
    }
}
