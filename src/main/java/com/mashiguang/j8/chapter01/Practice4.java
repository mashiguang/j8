package com.mashiguang.j8.chapter01;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice4 {

    //第1章，练习4
    // 没明白题意

    @Test
    public void test2() {
        String basepath = "D:\\";

        File root = new File(basepath);
        File[] files = root.listFiles();
        List<File> filelist = Arrays.asList(files);


        filelist.sort((first, second) -> {
            return second.compareTo(first);
        });

        filelist.forEach(System.out::println);
    }

}
