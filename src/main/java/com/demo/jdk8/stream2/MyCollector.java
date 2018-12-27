package com.demo.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/22
 */
public class MyCollector<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoker");
        return TreeSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoker");
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoker");
//        return (set1, set2) -> {
//            System.err.println("set1 addAll set2"+":{"+set1+":"+set2+"}");
//            set1.addAll(set2);
//            return set2;
//        };
        return null;
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoker");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoker");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,UNORDERED));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome", "hello","a","b","c");
        Set<String> set=list.stream().collect(new MyCollector<>());
        System.out.println(set);
    }
}
