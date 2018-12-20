package com.demo.jdk8.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/20
 */
public class StreamTest13 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);
        List<Student> students= Arrays.asList(student1,student2,student3,student4);
//        final Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getName));
//        collect.forEach((v1,v2)->{
//            System.out.println(v1+":"+v2);
//        });
//        students.stream().collect(Collectors.groupingBy(Student::getAge,Collectors.counting())).forEach((v1,v2)-> System.out.println(v1+":"+v2));
//        students.stream().collect(Collectors.groupingBy(Student::getAge,Collectors.averagingInt(Student::getScore))).forEach((v1,v2)-> System.out.println(v1+":"+v2));
        students.stream().collect(Collectors.partitioningBy(student->student.getScore()>80)).forEach((v1,v2)-> System.out.println(v1+":"+v2));

    }

}
