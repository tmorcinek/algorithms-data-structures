package com.morcinek.training.data_structures.list;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ListTest {

    private List list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList<Integer>();
    }

    @Test
    public void stackEmptyTest() throws Exception {
        Assertions.assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void stackNotEmptyTest() throws Exception {
        list.insert(0);
        Assertions.assertThat(list.size()).isEqualTo(1);
    }
}
