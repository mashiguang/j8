package com.mashiguang.j8.chapter01;

import org.junit.Test;

public class Practice7 {

    @Test
    public void test() throws InterruptedException {
        new Thread(
                andThen(()-> System.out.println("running in r1"),
                        ()-> System.out.println("running in r2"))
        ).start();

        Thread.sleep(1000);
    }

    public static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            new Thread(r1).start();
            new Thread(r2).start();
        };
    }
}
