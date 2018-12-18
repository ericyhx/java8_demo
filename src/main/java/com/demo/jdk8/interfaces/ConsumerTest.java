package com.demo.jdk8.interfaces;

import java.awt.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/18
 */
public class ConsumerTest {
    public static void main(String[] args) {
        ConsumerTest.computer("hello",value-> System.out.println(value));
        System.out.println("===============");
        ConsumerTest.computer1(2,System.out::println,System.out::println);
        System.out.println("===============");

        ConsumerTest.computer1(2,value->{
            System.out.println(value*value);
        },v2-> System.out.println(v2+5));
        System.out.println("===============");
        ConsumerTest.computer2(10,"hello",(v1,v2)->System.out.println( v2.toUpperCase().concat(String.valueOf(v1))));
        System.out.println("===============");
        ConsumerTest.computer2(10,"hello",(v1,v2)->System.out.println( v2.toUpperCase().concat(String.valueOf(v1+v2))));
        System.out.println("===============");
        Point p=new Point();
        ConsumerTest.computer3(p,value->{
            value.setLocation(1,2);
        });
        System.out.println(p.getX());

    }
    private static void computer(String value,Consumer<String> consumer){
        consumer.accept(value.toUpperCase());
    }
    private static void computer1(int a,Consumer<Integer> c1,Consumer<Integer> c2){
        c1.andThen(c2).accept(a);
    }
    private static void computer2(int a, String b, BiConsumer<Integer,String> consumer){
        consumer.accept(a,b);
    }
    private static void computer3(Point p,Consumer<Point> c){
        c.accept(p);
    }
}
