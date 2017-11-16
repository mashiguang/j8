package com.mashiguang.j8.chapter02;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream3 {

    @Test
    public void test() throws IOException {

        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locals.collect(Collectors.toMap(l -> l.getDisplayLanguage(),
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue));

        languageNames.forEach((key, value) -> System.out.println(key + ", " +value));
    }

    @Test
    public void test2() throws IOException {

        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> languageNames = locals.collect(
                Collectors.toMap(
                        l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }));

        languageNames.forEach((key, value) -> System.out.println(key + ", " +value));
    }
}
