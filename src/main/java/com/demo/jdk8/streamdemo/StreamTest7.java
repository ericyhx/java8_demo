package com.demo.jdk8.streamdemo;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:首字母大写
 * @author: yuhongxi
 * @date:2018/12/20
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(item->item.substring(0,1).toUpperCase()+item.substring(1)).forEach(System.out::println);
    }
}
