package com.mashiguang.j8.chapter01;

import org.junit.Test;

public class DefaultMethod {

    @Test
    public void testSamename() {
        Student student = new Student();
        System.out.println(student.getName());
    }

    class Student implements Person, Named {
        @Override
        public String getName() {
            return Person.super.getName();
        }
    }

    interface Person {
        default String getName() {
            return getClass().getName() + "_" + hashCode();
        }
    }

    interface Named {
        default String getName() {
            return getClass().getName() + "_" + hashCode();
        }
    }
}
