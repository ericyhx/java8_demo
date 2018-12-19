package com.demo.jdk8.streamdemo;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/19
 */
public class StreamTest6 {
    public static void main(String[] args) {
        Stream<String> stream=Stream.generate(UUID.randomUUID()::toString);
        Stream<String> stream1=Stream.empty();
//        System.out.println(stream.findFirst());
//        stream1.findFirst().ifPresent(System.out::println);
        Stream<Integer> stream2=Stream.iterate(1,item->item+2).limit(6);
//        System.out.println(stream2.filter(value->value>3).mapToInt(item->item*2).skip(1).limit(2).sum());
//        stream2.filter(value->value>30).mapToInt(item->item*20).skip(1).max().ifPresent(System.out::println);
//        stream2.filter(value->value>3).mapToInt(item->item*2).skip(1).min().ifPresent(System.out::println);
//        stream2.filter(value->value>3).mapToInt(item->item*2).skip(1).average().ifPresent(System.out::println);



//        final IntSummaryStatistics sum = stream2.filter(value -> value > 3).mapToInt(item -> item * 2).skip(1).summaryStatistics();
//        System.out.println(sum.getAverage());
//        System.out.println(sum.getCount());
//        System.out.println(sum.getMax());
//        System.out.println(sum.getMin());
//        System.out.println(sum.toString());

//        System.out.println(stream2);
//        System.out.println(stream2.filter(value->value<3));
//        System.out.println(stream2.distinct());

        System.out.println(stream2);
        Stream<Integer> stream3 = stream2.filter(item -> item > 2);
        System.out.println(stream3);
        Stream<Integer> stream4 = stream3.distinct();
        System.out.println(stream4);

    }
}
