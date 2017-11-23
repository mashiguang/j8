package com.mashiguang.j8.chapter02;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Grouping {

    private List<Person> people;

    @Before
    public void before() {
        people = new ArrayList<>();
        people.add(new Person(18, "Max-18"));
        people.add(new Person(6, "Eason-6"));
        people.add(new Person(15, "Mary-15"));
        people.add(new Person(6, "May-6"));
        people.add(new Person(18, "Jason-18"));
        people.add(new Person(15, "Mike-15"));
    }

    @Test
    public void test() {
        //1, sorting
        //2, grouping
        Map<Integer, List<Person>> map = people.stream().sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.groupingBy(Person::getAge, LinkedHashMap::new, Collectors.toList()));

        map.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(System.out::println);
        });
    }

}

class Person {
    private Integer age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
