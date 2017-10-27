package com.mashiguang.j8.chapter01;

import org.junit.Test;

import java.io.IOException;

public class Lambda4 {

    @Test
    public void test() throws IOException {
        Thread thread = new Thread(this::hello);
        thread.start();

        Thread thread_2 = new Thread(this::hello);
        thread_2.start();

        //System.in.read();
    }

    public void hello() {
        System.out.println("["+Thread.currentThread().getName()+"]"+"hello.");
    }

    @Test
    public void testRepeat() {
        repeatMessage("hello.", 20);
    }

    private void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                // 这个sout可能会执行，也可能不被执行；取决于repeatMessage方法返回时Runnable执行了没有，
                // 如果repeatMessage返回的比较快，Runnable来不及执行也是可能的。
                System.out.println(text);
                Thread.yield();
            }
        };

        new Thread(r).start();


        /*
        String first = "";
        Comparator<String> comp = (first, second) -> Integer.compare(first.length(), second.length());
        //variable 'first' is already defined in the scope.
        */

    }

    @Test
    public void testThis() throws InterruptedException {

        Lambda4 currentObj = this;

        Runnable r = () -> {
            System.out.println(this.toString());
            // com.mashiguang.j8.chapter01.Lambda4@18d736f6

            System.out.println("this == currentObj: "+(this == currentObj));
            // true
            // lambda内部的this和 方法testThis里的this 是同一个
        };

        new Thread(r).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this.toString());
                // com.mashiguang.j8.chapter01.Lambda4$Thread1@6905ec13

                System.out.println("this.equals(currentObj): "+(this.equals(currentObj)));    //can not use == here.
                // false, `this` in anonymouse-inner-class is not equals `currentObj`.
            }
        }).start();

        Thread.sleep(1000);
    }


}
