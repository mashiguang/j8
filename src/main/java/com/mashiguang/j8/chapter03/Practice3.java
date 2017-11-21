package com.mashiguang.j8.chapter03;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

public class Practice3 {

    @Test
    public void test() {
        int[] arr = {0};

        assert_it(false, () -> arr[0]++);
        System.out.println(Arrays.toString(arr));   //[0]

        assert_it(true, () -> arr[0]++);
        System.out.println(Arrays.toString(arr));   //[1]
    }

    @Test
    public void testAssert() {
        int n = 0;
        boolean bool = false;

        try {
            assert bool : ""+n++;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(n);      //n==1, if bool == false
    }

    private void assert_it(boolean b, Runnable r){
        if (b) r.run();
    }

    @Test(expected = AssertionError.class)
    public void testAssertThat() {
        assertThat(() -> false, "oh,no.");
    }

    private void assertThat(BooleanSupplier assertion, String msg) {
        if (!assertion.getAsBoolean())
            throw new AssertionError(msg);
    }
}
