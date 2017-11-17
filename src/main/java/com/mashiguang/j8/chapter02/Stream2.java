package com.mashiguang.j8.chapter02;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Stream2 {

    @Test
    public void test() throws IOException {
        System.out.println(Paths.get("."));
        System.out.println(Paths.get(".").toAbsolutePath());

        List<String> words = Files.readAllLines(Paths.get("./src/main/resources/words.txt"));

        String result = words.stream().collect(Collectors.joining(", "));
        System.out.println(result);

        IntSummaryStatistics summary = words.stream().collect(Collectors.summarizingInt(String::length));
        System.out.println("avg: "+summary.getAverage());
        System.out.println("max: "+summary.getMax());
        System.out.println("min: "+summary.getMin());
        System.out.println("count: "+summary.getCount());

    }

    @Test
    public void test2() throws IOException {
        List<String> words = Files.readAllLines(Paths.get("./src/main/resources/words.txt"));

        List<String> words_uppercase = words.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(words_uppercase);

    }
}
