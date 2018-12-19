package com.demo.jdk8.streamdemo;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/19
 */
public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream= Stream.of("hello","world","hello world","test");
        String[] ss= stream.toArray(length->new String[length]);
        Arrays.asList(ss).forEach(System.out::println);
        String[] ss2= stream.toArray(String[]::new);
        Arrays.stream(ss2).forEach(System.out::println);
        List<String> list = stream.collect(Collectors.toList());
        list.forEach(System.out::println);
        Set<String> sets = stream.collect(Collectors.toSet());
        final List list1 = stream.collect(LinkedList::new, List::add, List::addAll);
        System.out.println(list1.getClass());
        list.forEach(System.out::println);
        stream.collect(Collectors.toCollection(()->new TreeSet<>()));
        final Set<String> collect = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect.getClass());
        collect.forEach(System.out::println);
        final String collect2 = stream.collect(Collectors.joining());
        System.out.println(collect2);

    }
}
