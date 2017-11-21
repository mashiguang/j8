package com.mashiguang.j8.chapter03;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;

import static com.mashiguang.j8.chapter03.Practice7.CompareOptions.*;

// copy from https://github.com/galperin/Solutions-for-exercises-from-Java-SE-8-for-the-Really-Impatient-by-Horstmann
public class Practice7 {

    @Test
    public void test() {

        String[] arr = {"BBB", " ccc", "AAA"};

        Arrays.sort(arr, comparator(EnumSet.noneOf(CompareOptions.class)));   //no params
        Assert.assertArrayEquals(new String[]{" ccc","AAA","BBB"}, arr);

        Arrays.sort(arr, comparator(EnumSet.of(
                CASE_INSENSITIVE,
                SPACE_INSENSITIVE
        )));
        Assert.assertArrayEquals(new String[]{"AAA","BBB"," ccc"}, arr);
    }


    private Comparator<String> comparator(EnumSet<CompareOptions> options) {
        return (a, b) -> {
            if (options.contains(CASE_INSENSITIVE)) {
                a = a.toLowerCase();
                b = b.toLowerCase();
            }
            if (options.contains(SPACE_INSENSITIVE)) {
                a = a.replaceAll("\\s+", "");
                b = b.replaceAll("\\s+", "");
            }
            return a.compareTo(b);
        };
    }

    enum CompareOptions {
        CASE_INSENSITIVE,
        SPACE_INSENSITIVE
    }
}
