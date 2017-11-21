package com.mashiguang.j8.chapter03;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class Practice2 {

    @Test
    public void test() {
        ReentrantLock myLock = new ReentrantLock();
        System.out.println("hello. ["+Thread.currentThread().getName()+"]");
        withLock(myLock, () -> System.out.println("hello. lambda. ["+Thread.currentThread().getName()+"]"));
    }

    private void withLock(ReentrantLock myLock, Runnable r) {
        myLock.lock();

        try {
            r.run();
        } finally {
            myLock.unlock();
        }
    }
}
