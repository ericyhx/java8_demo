package com.demo.jdk8.stream2;

import com.demo.jdk8.streamdemo.Student;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80,20);
        Student student2 = new Student("lisi", 90,20);
        Student student3 = new Student("wangwu", 100,30);
        Student student4 = new Student("zhaoliu", 70,30);
        Student student5 = new Student("zhaoliu", 90,25);
        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
//        System.out.println( students.stream().count());
//        students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
//        students.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getAge))).ifPresent(System.out::println);
//        Double collect = students.stream().collect(Collectors.averagingInt(Student::getScore));
//        System.out.println(collect);
//        IntSummaryStatistics collect1 = students.stream().collect(Collectors.summarizingInt(Student::getAge));
//        System.out.println(collect1.toString());
//        System.out.println("========================");
//        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining()));
//        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(", ")));
//        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(", ","<name> "," </name>")));
        System.out.println("========================");
        Map<String, Map<Integer, List<Student>>> c2 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getAge)));
        System.out.println(c2);
//        System.out.println("====================");
//        c2.forEach((v1,v2)->{
//            System.out.println("-------------");
//            v2.forEach((v3,v4)-> System.out.println(v1+":"+v3+":"+v4));});
//        System.out.println("=========================");
//        Map<Boolean, Map<Boolean, List<Student>>> map = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 80, Collectors.partitioningBy(student -> student.getScore() > 90)));
//        System.out.println(map);
//        System.out.println("=========================");
//        Map<Boolean, Long> collect2 = students.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() > 80, Collectors.counting()));
//        System.out.println(collect2);
//        System.out.println("=========================");
//        Map<String, Student> collect3 = students.stream().collect(
//                Collectors.groupingBy(Student::getName,
//                        Collectors.collectingAndThen(
//                                Collectors.minBy(Comparator.comparingInt(Student::getScore)),
//                                Optional::get)));
//        System.out.println(collect3);
    }
}
