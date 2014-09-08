package com.morcinek.training.data_structures.tree.bst;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class BSTreeTest {

    private BSTree<Integer> tree;

    @Before
    public void setUpTree() throws Exception {
        tree = new LinkedBSTree<Integer>();
    }

    @Before
    public void setUpValues() throws Exception {
        tree.insert(10);
        tree.insert(17);
        tree.insert(16);
        tree.insert(21);
        tree.insert(4);
        tree.insert(1);
        tree.insert(5);
    }

    @Test
    public void getInOrderValuesTest() throws Exception {
        Assertions.assertThat(tree.getInOrderValues()).isEqualTo(new Object[]{1, 4, 5, 10, 16, 17, 21});
    }
}
