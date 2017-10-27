package com.mashiguang.j8.chapter01;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class Practice3 {

    @Test
    public void test2() {
        //第1章，练习3

        String basepath = "D:\\temp";
        String extension = ".txt";

        File root = new File(basepath);
        //lambda
        File[] files = root.listFiles((dir, name) -> name.endsWith(extension));

        for (File file : files) {
            System.out.println(file.getName());
        }
    }

}
