package com.demo.jdk8;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/18
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer,String> f1= value -> value+"";
        System.out.println(f1.apply(10));
        System.out.println("===============");
        System.out.println(FunctionTest.computer1(20,(v1)->String.valueOf(v1*v1)));
        Person person=new Person();
        person.setAge(10);
        person.setName("zhangsan");
        final User user = FunctionTest.computer2(person, p -> {
            User u = new User();
            u.setName(p.getName());
            u.setAge(p.getAge());
            return u;
        });
        System.out.println(user);
        System.out.println("===============");
        System.out.println(FunctionTest.computer3(10,20,(v1,v2)->String.valueOf(v1*v2)));
        System.out.println(FunctionTest.computer3(10,20,(v1,v2)->v1+""+v2));

        System.out.println("===============");
        System.out.println(FunctionTest.computer4(10,20,(v1,v2)->v1+v2));
        System.out.println(FunctionTest.computer4(10,20,(v1,v2)->v1-v2));
        System.out.println(FunctionTest.computer4(10,20,(v1,v2)->v1/v2));
        System.out.println("===============");



    }
    private static String computer1(Integer value, Function<Integer,String> function){
       return function.apply(value);
    }
    private static User computer2(Person person,Function<Person,User> function){
        return function.apply(person);
    }
    private static String computer3(Integer a, Integer b, BiFunction<Integer,Integer,String> function){
        return function.apply(a,b);
    }
    private static Integer computer4(Integer a, Integer b, BinaryOperator<Integer> function){
        return function.apply(a,b);
    }
}
