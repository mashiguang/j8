package com.mashiguang.j8.chapter02;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Stream1 {

    @Test
    public void test() throws IOException {
        System.out.println(Paths.get("."));
        System.out.println(Paths.get(".").toAbsolutePath());

        List<String> words = Files.readAllLines(Paths.get("./src/main/resources/words.txt"));

        long count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        //words.stream().filter(w -> w.length() > 12).forEach(System.out::println);

        words.parallelStream().filter(w -> {
            System.out.println(Thread.currentThread().getName());
            return w.length() > 12;}).forEach(w -> System.out.println(Thread.currentThread().getName()+" "+w));
    }
}
