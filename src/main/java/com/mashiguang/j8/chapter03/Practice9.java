package com.mashiguang.j8.chapter03;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

// copy from https://github.com/galperin/Solutions-for-exercises-from-Java-SE-8-for-the-Really-Impatient-by-Horstmann
public class Practice9 {

    @Test
    public void test() {

        Person[] persons = {
                new Person("aaa","ccc"),
                new Person("aaa", "bbb"),
                new Person("bbb", "aaa")
        };

        Arrays.sort(persons, comparator("firstname", "lastname"));
        Assert.assertEquals("bbb", persons[0].lastname);

        Arrays.sort(persons, comparator("lastname", "firstname"));
        Assert.assertEquals("aaa", persons[0].lastname);
    }

    private <T> Comparator<T> comparator(String... fieldNames) {
        return (a, b) -> {
            for (String fieldName: fieldNames) {
                try {
                    Field field = a.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);

                    Object valueA = field.get(a);
                    Object valueB = field.get(b);

                    if (valueA == valueB) continue;
                    if (valueA == null) return -1;
                    if (valueB == null) return 1;

                    int compareResult = valueA.toString().compareTo(valueB.toString());
                    if (compareResult != 0)
                        return compareResult;

                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        };
    }

    class Person {
        private String firstname;
        private String lastname;

        public Person(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }
    }
}
