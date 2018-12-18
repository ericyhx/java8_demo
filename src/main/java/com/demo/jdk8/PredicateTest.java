package com.demo.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/18
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> p1= value -> value>5;
        Predicate<Integer> p2= value -> value%2==0;
        System.out.println(p1.test(1));
        System.out.println(p1.negate().test(1));
        System.out.println(p1.and(p2).test(10));
        System.out.println(p1.or(p2).test(2));
        System.out.println("======================");
        Person person=new Person();
        person.setAge(10);
        PredicateTest.computer1(person,v1->{
            v1.setName("zhangsan");
            v1.setAge(20);
        },v2->v2.getName()==null);
        System.out.println(person);
        System.out.println("======================");
        PredicateTest.computer1(person,v1->{
            v1.setName("zhangsan");
            v1.setAge(20);
        },v2->v2.getAge()<20);
        System.out.println(person);
        System.out.println("=========123=============");
        PredicateTest.computer2(person,person.getAge(),(v1,v2)->v1.getAddress()==null&&v2<30,v3->v3.setAddress("shanghai"));
        System.out.println(person);
        System.out.println("========bi==============");
        person.setSex("M");
        List<Person> ps=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p3=new Person();
            p3.setName("aa"+i);
            p3.setAge(21+i);
            ps.add(p3);
        }
        final List<Person> pss = PredicateTest.filterPerson(ps, value -> value.getAge() > 25);
        System.out.println(pss);
    }
    private static void computer1(Person person, Consumer<Person> c,Predicate<Person> p){
        if(p.test(person)){
            c.accept(person);
        }
    }
    private static void computer2(Person person,Integer agv, BiPredicate<Person,Integer> bp,Consumer<Person> c){
        if(bp.test(person,agv)){
            c.accept(person);
        }
    }
    public static List<Person> filterPerson (List<Person> persons, Predicate<Person> predicate) {
        return persons.stream().filter(predicate).collect(Collectors.toList());
    }
}
