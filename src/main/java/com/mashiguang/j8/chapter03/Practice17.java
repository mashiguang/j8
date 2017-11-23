package com.mashiguang.j8.chapter03;

import java.util.function.Consumer;

public class Practice17 {

    public <T> void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        new Thread(() -> {
            try {
                first.run();
            } catch (Exception e) {
                handler.accept(e);
            }
        }).start();

        new Thread(() -> {
            try {
                second.run();
            } catch (Exception e) {
                handler.accept(e);
            }
        }).start();
    }
}
