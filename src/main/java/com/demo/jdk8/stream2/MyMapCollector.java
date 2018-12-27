package com.demo.jdk8.stream2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.*;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/22
 */
public class MyMapCollector<T> implements Collector<T,Set<T>,Map<T,T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoker");
//        return HashSet::new;
        return ()->{
            System.out.println("----------");
            return new HashSet<>();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoker");
        return (set,v)->{
            System.out.println("accumulator set:,"+Thread.currentThread().getName());
            set.add(v);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoker");
        return (set1, set2) -> {
            System.err.println("set1 addAll set2"+":{"+set1+":"+set2+"}");
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoker");
        return set->{
            Map map=new HashMap();
            System.out.println("set to map:set="+set);
            set.stream().forEach((value)->map.put(value,value));
            return map;
        };
    }

    /**
     * CONCURRENT:只有一个中间结果容器，过程中不需要调用combiner（）；
     * 如果没有标识CONCURRENT，将存在多个中间结果容器，所以最终会调用combiner（）方法进行汇总
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(CONCURRENT,UNORDERED));
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
//        for (int i = 0; i < 100; i++) {

            List<String> list = Arrays.asList("hello", "world", "welcome", "hello", "a", "b", "c", "d", "e", "f", "g");
            Set<String> set=new HashSet<>();
            set.addAll(list);
            final Map<String, String> map = set.parallelStream().collect(new MyMapCollector<>());
            System.out.println(map);

//        }
    }
}
