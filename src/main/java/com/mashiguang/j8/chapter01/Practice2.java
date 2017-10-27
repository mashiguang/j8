package com.mashiguang.j8.chapter01;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class Practice2 {

    //第1章，练习2

    @Test
    public void test() {
        String basepath = "D:\\";

        File root = new File(basepath);
        // anonymous inner class
        File[] dirs = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });

        for (File dir : dirs) {
            System.out.println(dir.getName());
        }
    }

    @Test
    public void test2() {
        String basepath = "D:\\";

        File root = new File(basepath);
        //lambda
        File[] dirs = root.listFiles(dir -> dir.isDirectory());

        for (File dir : dirs) {
            System.out.println(dir.getName());
        }
    }

    @Test
    public void test3() {
        String basepath = "D:\\";

        File root = new File(basepath);
        //ref method
        File[] dirs = root.listFiles(File::isDirectory);

        for (File dir : dirs) {
            System.out.println(dir.getName());
        }
    }
}
