package com.demo.jdk8;

import com.demo.jdk8.interfaces.Person;
import com.demo.jdk8.interfaces.User;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/18
 */
public class Application {
    public static void main(String[] args) {
        Consumer<Person> consumer= person -> person=new Person();
        Function<Person, User> function= person -> new User();
        Predicate<Person> p= person -> false;
        Supplier<Person> s= Person::new;
    }
}
