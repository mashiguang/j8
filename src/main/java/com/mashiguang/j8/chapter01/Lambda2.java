package com.mashiguang.j8.chapter01;

public class Lambda2 {

    @FunctionalInterface
    public interface Functional1 {

        void method1();
        //void method2();

        default void method3() {

        }
    }

    //@FunctionalInterface只能用于只含有一个抽象方法的接口
    //method3不算抽象接口
    //只要有且仅有一个抽象方法，任何一个接口都是函数式接口，即使未标注@FunctionalInterface
}
