package com.demo.jdk8.interfaces;

import java.util.function.Supplier;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/18
 */
public class SupplierTeset {
    public static void main(String[] args) {
        Supplier<String> s1=()->"hello";
        System.out.println(s1.get());
        System.out.println("====================");
        Supplier<Person> s2=Person::new;
        System.out.println(s2.get());
    }
}
