package com.demo.jdk8.defaultmethod;

public interface MyInterface2 {
    default void myMethod(){
        System.out.println("my interface2 test");
    }
}
