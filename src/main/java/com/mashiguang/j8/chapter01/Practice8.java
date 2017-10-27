package com.mashiguang.j8.chapter01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Practice8 {

    @Test
    public void test() throws InterruptedException {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();

        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }

        for (Runnable runner: runners) {
            new Thread(runner).start();
        }

        Thread.sleep(1000);
    }
}
