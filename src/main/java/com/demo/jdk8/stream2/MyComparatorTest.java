package com.demo.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");
//        Collections.sort(list);
//        Collections.sort(list,(s1,s2)->s2.length()-s1.length());
//        Collections.sort(list, Comparator.comparingInt(String::length));
//        Collections.sort(list,Comparator.comparingInt(String::length).reversed());
        //lambad表达式的类型推断此处无法获取
        Collections.sort(list,Comparator.comparingInt((String item)->item.length()).reversed());
        list.stream().sorted(Comparator.comparingInt(item->item.length()));
        System.out.println(list);
    }
}
