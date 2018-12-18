package com.demo.jdk8.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public String getString(Supplier<String> supplier){
        return supplier.get()+"test";
    }
    public String getString(String s, Function<String,String> function){
        return function.apply(s);
    }
    public static void main(String[] args) {
        Student s1=new Student("zhangsan",20);
        Student s2=new Student("lisi",60);
        Student s3=new Student("wangwu",30);
        Student s4=new Student("zhaoliu",40);
        Student s5=new Student("qianqi",40);
        Student s6=new Student("tom",10);
        Student s7=new Student("eric",90);
        List<Student> ss= Arrays.asList(s1,s2,s3,s4,s5,s6,s7);
//        System.out.println("=========遍历==============");
//        ss.forEach(System.out::println);
//        ss.stream().map(student -> student.getScore()).forEach(System.out::println);
//        System.out.println("==========第一种方法引用==(类名::静态方法名)===========");
//        ss.stream().sorted(Student::comperatorByScore).map(student -> student.getScore()).forEach(System.out::println);
//        System.out.println("==========(类名::静态方法名)============");
//        ss.stream().sorted(Student::comperatorByName).map(student -> student.getName()).forEach(System.out::println);
//        System.out.println("======第二种方法引用====(对象名::实例方法名)=============");
//        ss.stream().sorted(s1::comperatorByScore2).map(student -> student.getScore()).forEach(System.out::println);
//        System.out.println("=========(对象名::实例方法名)==============");
//        ss.stream().sorted(s1::comperatorByName2).map(student -> student.getName()).forEach(System.out::println);
//        System.out.println("=======第三种方法引用==(类名::实例方法名)==============");
//        ss.stream().sorted(Student::comperatorByScore3).map(student -> student.getScore()).forEach(System.out::println);
//        System.out.println("=========(类名::实例方法名)==============");
//        ss.stream().sorted(Student::comperatorByName3).map(student -> student.getName()).forEach(System.out::println);

//        List<String> cities=Arrays.asList("shanghai","tianjin","nanjing","lanzhou","xian");
//        cities.sort((c1,c2)->c1.compareToIgnoreCase(c2));
//        cities.forEach(System.out::println);
//        cities.stream().sorted((c1,c2)->c1.compareToIgnoreCase(c2)).forEach(System.out::println);
//        cities.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);
        System.out.println("=====第四种方法引用====(类名::new)==============");
        MethodReference mr=new MethodReference();
        System.out.println(mr.getString(String::new));
        System.out.println(mr.getString(()->"hello "));
        System.out.println(mr.getString("hello",String::new));
    }
}
