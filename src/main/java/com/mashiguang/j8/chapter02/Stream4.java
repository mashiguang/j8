package com.mashiguang.j8.chapter02;

import org.junit.Test;

import java.util.Arrays;

public class Stream4 {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //ordered
        Arrays.stream(arr).forEach(System.out::print);

        System.out.println();

        //no ordered
        Arrays.stream(arr).parallel().forEach(System.out::print);

        System.out.println();

        //ordered
        Arrays.stream(arr).parallel().forEachOrdered(System.out::print);
    }
}
