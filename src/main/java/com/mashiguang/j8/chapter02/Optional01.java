package com.mashiguang.j8.chapter02;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class Optional01 {

    @Test
    public void test() {
        Optional<Integer> op = Optional.of(1);
        Assert.assertTrue(op.isPresent());

        Optional<Integer> op2 = Optional.ofNullable(null);
        Assert.assertFalse(op2.isPresent());
    }

}
