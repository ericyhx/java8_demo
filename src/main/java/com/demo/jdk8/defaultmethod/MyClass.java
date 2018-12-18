package com.demo.jdk8.defaultmethod;

public class MyClass implements Myinterface ,MyInterface2{
    public static void main(String[] args) {
        MyClass myClass=new MyClass();
        myClass.myMethod();
    }

    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }
}
