package com.morcinek.training.data_structures.stack;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack<Integer>();
    }

    @Test
    public void stackEmptyTest() throws Exception {
        Assertions.assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void stackNotEmptyTest() throws Exception {
        stack.push(1);
        Assertions.assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    public void stackPopTest() throws Exception {
        stack.push(1);
        stack.pop();
        Assertions.assertThat(stack.isEmpty()).isTrue();
    }
}
