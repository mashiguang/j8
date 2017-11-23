package com.mashiguang.j8.chapter03;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Practice16 {

    public <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    T first_result = first.get();
                    second.accept(first_result, null);
                } catch (Exception e) {
                    second.accept(null, e);
                }
            }
        };
        t.start();
    }

}
