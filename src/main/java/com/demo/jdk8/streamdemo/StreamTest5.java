package com.demo.jdk8.streamdemo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/19
 */
public class StreamTest5 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("hello","world","hello world","test");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        Stream<List<Integer>> stream=Stream.of(Arrays.asList(1),Arrays.asList(2,3),Arrays.asList(4,5));
        stream.map(item->item.stream().map(value->value*value).collect(Collectors.toList())).forEach(System.out::println);
        stream.flatMap(List::stream).map(item->item*item).forEach(System.out::println);
        System.out.println("============");
        try(Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Ericy\\OneDrive\\桌面\\2.0test.txt"))){
            lines.skip(1).limit(9).forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
