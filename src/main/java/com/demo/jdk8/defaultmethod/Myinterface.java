package com.demo.jdk8.defaultmethod;

/**
 * 为什么要引入默认方法
 * 1：要保证向后兼容
 */
public interface Myinterface {
    default void myMethod(){
        System.out.println("my interface test");
    }
}
