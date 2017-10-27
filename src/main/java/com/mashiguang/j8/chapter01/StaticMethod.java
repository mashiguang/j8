package com.mashiguang.j8.chapter01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaticMethod {

    @Test
    public void test() {

        List<String> arr = Arrays.asList("asdf,qwer,asdf,xc,we,dfg,asd,we,gds,sd,cw,cw,xsdt".split(","));
        List<String> arr2 = Arrays.asList("asdf,qwer,asdf,xc,we,dfg,asd,we,gds,sd,cw,cw,xsdt".split(","));
        List<String> arr3 = Arrays.asList("asdf,qwer,asdf,xc,we,dfg,asd,we,gds,sd,cw,cw,xsdt".split(","));
        List<String> arr4 = Arrays.asList("asdf,qwer,asdf,xc,we,dfg,asd,we,gds,sd,cw,cw,xsdt".split(","));

        arr.sort((first, second) -> Integer.compare(first.length(), second.length()));
        System.out.println(arr);

        //arr2.sort(Comparator.comparing(String::toString));
        //arr2.sort(Comparator.naturalOrder());
        arr2.sort(Comparator.reverseOrder());
        System.out.println(arr2);

        Collections.sort(arr3);
        System.out.println(arr3);

        arr4.sort(null);
        System.out.println(arr4);
    }
}
