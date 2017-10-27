package com.mashiguang.j8.chapter01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda3 {

    @Test
    public void test() {

        String[] arr = new String[]{"Tom","Jerry","Max","Michael"};

        Arrays.stream(arr).forEach(System.out::println);

        Arrays.stream(arr).forEach(s -> System.out.println(s));



        //::表示方法引用
        //方法引用等同于 函数式接口的实例

        //用法:
        //1, 对象::实例方法
        //2, 类::静态方法
        //3, 类::实例方法

        //第3种情况示例
        //todo



        int[] arr2 = new int[]{1,2,3};
        Arrays.stream(arr2).forEach(Foo::new);
        // Foo:new 引用构造器



    }

    class Foo {
        int bar;

        public Foo(int bar) {
            this.bar = bar;
            System.out.println("in Foo constructor");
        }

        public Foo(String bar) {}
    }
}
