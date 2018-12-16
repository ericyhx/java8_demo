package com.demo.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        MyInterface mi=()->{};
        System.out.println(mi.getClass().getInterfaces()[0]);
        MyInterface2 mi2=()->{};
        System.out.println(mi2.getClass().getInterfaces()[0]);
        new Thread(()->{
            System.out.println("thread start");
        }).start();

        List<String> list= Arrays.asList("hello","world");
        list.forEach(item->{
            System.out.println(item.toUpperCase());
        });
        List<String> list2=new ArrayList<>();
        list.forEach(item->{
            list2.add(item.toUpperCase());
        });
        list.stream().map(item->item.toUpperCase()).forEach(item-> System.out.println(item));
        //采用方法的引用
        list.stream().map(String::toUpperCase).forEach(System.out::println);

    }
}
@FunctionalInterface
interface MyInterface{
    void myMethod();
}
@FunctionalInterface
interface MyInterface2{
    void myMethod2();
}
