package com.morcinek.training.data_structures.stack;

import org.fest.assertions.Assertions;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class StackTest {

    private Stack stack = new Stack();

    @Test
    public void stackEmptyTest() throws Exception {
        Assertions.assertThat(stack.isEmpty()).isTrue();
    }
}
