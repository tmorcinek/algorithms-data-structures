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

    @Test
    public void searchPositiveTest() throws Exception {
        Assertions.assertThat(tree.search(1)).isTrue();
        Assertions.assertThat(tree.search(4)).isTrue();
        Assertions.assertThat(tree.search(5)).isTrue();
        Assertions.assertThat(tree.search(10)).isTrue();
        Assertions.assertThat(tree.search(16)).isTrue();
        Assertions.assertThat(tree.search(17)).isTrue();
        Assertions.assertThat(tree.search(21)).isTrue();
    }

    @Test
    public void searchNegativeTest() throws Exception {
        Assertions.assertThat(tree.search(22)).isFalse();
        Assertions.assertThat(tree.search(0)).isFalse();
        Assertions.assertThat(tree.search(14)).isFalse();
        Assertions.assertThat(tree.search(18)).isFalse();
        Assertions.assertThat(tree.search(-14)).isFalse();
        Assertions.assertThat(tree.search(288)).isFalse();
    }

    @Test
    public void singleSearchTest() throws Exception {
        Assertions.assertThat(tree.search(22)).isFalse();
    }
}
