package com.demo.jdk8.interfaces;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional opt=Optional.of("hello");
        System.out.println(opt.get());
        Optional opt1=Optional.empty();
//        System.out.println(opt1.get());
        opt1.ifPresent(System.out::println);
        System.out.println(opt1.orElse("world"));
        String temp="test";
        String s = Optional.ofNullable(temp).orElse("hello world");
        System.out.println(s);

    }
}
