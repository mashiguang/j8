package com.mashiguang.j8.chapter01;

import java.util.Comparator;

public class Lambda1 {

    Comparator<String> comparator = (a, b) -> a.compareTo(b);

    //lambda表达式是一个函数式接口的对象。
    //函数式接口定义：只包含一个抽象方法的接口。

    Comparator c2 = Comparator.naturalOrder();
}
