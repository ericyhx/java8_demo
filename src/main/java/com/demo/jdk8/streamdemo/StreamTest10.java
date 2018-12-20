package com.demo.jdk8.streamdemo;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/20
 */
public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(item->{
            int length=item.length();
            System.out.println("==========="+item+"==========");
            return length;
        }).filter(value->value>4).findFirst().ifPresent(System.out::println);
    }
}
