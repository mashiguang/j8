package com.mashiguang.j8.chapter02;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Stream3 {

    @Test
    public void test() throws IOException {

        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locals.collect(toMap(l -> l.getDisplayLanguage(),
                l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue));

        languageNames.forEach((key, value) -> System.out.println(key + ", " +value));
    }

    @Test
    public void test2() throws IOException {

        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> languageNames = locals.collect(
                toMap(
                        l -> l.getDisplayCountry(),
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> r = new HashSet<>(a);
                            r.addAll(b);
                            return r;
                        }));

        languageNames.forEach((key, value) -> System.out.println(key + ", " +value));
    }

    @Test
    public void test3() throws IOException {

        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());
        String[] languages = locals.map(l -> l.getDisplayCountry()+l.getCountry()).toArray(String[]::new);

        for (String language : languages) {
            System.out.println(language);
        }
    }

    @Test
    public void test4() throws IOException {

        Locale[] locales = Locale.getAvailableLocales();

        //to List
        Map<String, List<Locale>> country2List = Stream.of(locales).collect(groupingBy(Locale::getDisplayCountry));
        country2List.forEach((key, list) -> System.out.println(key));

        //to Set
        Map<String, Set<Locale>> country2set = Stream.of(locales).collect(groupingBy(Locale::getDisplayCountry, toSet()));
        country2set.forEach((key, list) -> System.out.println(key));

    }

    @Test
    public void test5() throws IOException {

        Stream<Locale> locals = Stream.of(Locale.getAvailableLocales());

        Map<Boolean, List<Locale>> enAndOthers = locals.collect(partitioningBy(l -> "en".equals(l.getLanguage())));

        //所有说英语的国家
        enAndOthers.get(true).forEach(l -> System.out.println(l.getDisplayCountry()));

        System.out.println("no english:");
        //不说英语的国家
        enAndOthers.get(false).forEach(l -> System.out.println(l.getDisplayCountry()));
    }

    @Test
    public void test6() throws IOException {

        Locale[] locales = Locale.getAvailableLocales();

        //to Set
        Map<String, Set<String>> country2set = Stream.of(locales).collect(groupingBy(l -> l.getDisplayCountry(),
                mapping(l -> l.getDisplayLanguage(), toSet())));
        country2set.forEach((key, list) -> {
            System.out.print(key);
            System.out.println(list);
        });

    }
}
