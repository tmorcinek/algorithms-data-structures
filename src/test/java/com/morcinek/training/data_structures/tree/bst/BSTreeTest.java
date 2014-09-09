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
        Assertions.assertThat(tree.search(149)).isFalse();
    }

    @Test
    public void minimumTest() throws Exception {
        Assertions.assertThat(tree.minimum()).isEqualTo(1);
    }

    @Test
    public void minimumWithInsertionTest() throws Exception {
        tree.insert(-1);
        tree.insert(-15);
        tree.insert(-159);
        Assertions.assertThat(tree.minimum()).isEqualTo(-159);
    }

    @Test
    public void maximumTest() throws Exception {
        Assertions.assertThat(tree.maximum()).isEqualTo(21);
    }

    @Test
    public void maximumWithInsertionTest() throws Exception {
        tree.insert(30);
        tree.insert(37);
        tree.insert(157);
        Assertions.assertThat(tree.maximum()).isEqualTo(157);
    }

    @Test
    public void predecessorTest() throws Exception {
        Assertions.assertThat(tree.predecessor(10)).isEqualTo(5);
        Assertions.assertThat(tree.predecessor(17)).isEqualTo(16);
        Assertions.assertThat(tree.predecessor(21)).isEqualTo(17);
        Assertions.assertThat(tree.predecessor(4)).isEqualTo(1);
    }

    @Test
    public void predecessorFromMinTest() throws Exception {
        Assertions.assertThat(tree.predecessor(1)).isNull();
    }

    @Test
    public void predecessorWithInsertionsTest() throws Exception {
        tree.insert(9);
        tree.insert(14);
        tree.insert(15);
        tree.insert(12);
        tree.insert(13);
        tree.insert(11);
        tree.insert(12);
        tree.insert(19);
        tree.insert(20);
        tree.insert(18);
        tree.insert(75);
        tree.insert(60);
        tree.insert(125);

        Assertions.assertThat(tree.predecessor(60)).isEqualTo(21);
        Assertions.assertThat(tree.predecessor(125)).isEqualTo(75);
        Assertions.assertThat(tree.predecessor(21)).isEqualTo(20);
        Assertions.assertThat(tree.predecessor(17)).isEqualTo(16);
        Assertions.assertThat(tree.predecessor(10)).isEqualTo(9);
        Assertions.assertThat(tree.predecessor(13)).isEqualTo(12);
        Assertions.assertThat(tree.predecessor(11)).isEqualTo(10);
        Assertions.assertThat(tree.predecessor(9)).isEqualTo(5);
    }

    @Test
    public void successorTest() throws Exception {
        Assertions.assertThat(tree.successor(10)).isEqualTo(16);
        Assertions.assertThat(tree.successor(16)).isEqualTo(17);
        Assertions.assertThat(tree.successor(17)).isEqualTo(21);
        Assertions.assertThat(tree.successor(1)).isEqualTo(4);
        Assertions.assertThat(tree.successor(4)).isEqualTo(5);
    }

    @Test
    public void successorFromMaxTest() throws Exception {
        Assertions.assertThat(tree.successor(21)).isNull();
    }

    @Test
    public void successorWithInsertionsTest() throws Exception {
        tree.insert(9);
        tree.insert(14);
        tree.insert(15);
        tree.insert(12);
        tree.insert(13);
        tree.insert(11);
        tree.insert(12);
        tree.insert(19);
        tree.insert(20);
        tree.insert(18);
        tree.insert(75);
        tree.insert(60);
        tree.insert(125);

        Assertions.assertThat(tree.successor(60)).isEqualTo(75);
        Assertions.assertThat(tree.successor(125)).isNull();
        Assertions.assertThat(tree.successor(21)).isEqualTo(60);
        Assertions.assertThat(tree.successor(17)).isEqualTo(18);
        Assertions.assertThat(tree.successor(10)).isEqualTo(11);
        Assertions.assertThat(tree.successor(12)).isEqualTo(13);
        Assertions.assertThat(tree.successor(11)).isEqualTo(12);
        Assertions.assertThat(tree.successor(9)).isEqualTo(10);
        Assertions.assertThat(tree.successor(13)).isEqualTo(14);
        Assertions.assertThat(tree.successor(15)).isEqualTo(16);
        Assertions.assertThat(tree.successor(20)).isEqualTo(21);
    }

    @Test
    public void printTreeTest() throws Exception {
        Assertions.assertThat(tree.toString()).isNotEmpty().isEqualTo(
                "      21\n" +
                        "   17\n" +
                        "      16\n" +
                        "10\n" +
                        "      5\n" +
                        "   4\n" +
                        "      1\n"
        );
    }

    @Test
    public void printTreeWithInsertionsTest() throws Exception {
        tree.insert(9);
        tree.insert(14);
        tree.insert(15);
        tree.insert(12);
        tree.insert(13);
        tree.insert(11);
        tree.insert(12);
        tree.insert(19);
        tree.insert(20);
        tree.insert(18);
        tree.insert(75);
        tree.insert(60);
        tree.insert(125);

        Assertions.assertThat(tree.toString()).isNotEmpty().isEqualTo(
                "            125\n" +
                        "         75\n" +
                        "            60\n" +
                        "      21\n" +
                        "            20\n" +
                        "         19\n" +
                        "            18\n" +
                        "   17\n" +
                        "      16\n" +
                        "            15\n" +
                        "         14\n" +
                        "               13\n" +
                        "            12\n" +
                        "                  12\n" +
                        "               11\n" +
                        "10\n" +
                        "         9\n" +
                        "      5\n" +
                        "   4\n" +
                        "      1\n"
        );
    }

    @Test
    public void deleteRootTest() throws Exception {
        tree = new LinkedBSTree<Integer>();
        tree.insert(30);

        Assertions.assertThat(tree.delete(30)).isEqualTo(30);
        Assertions.assertThat(tree.search(30)).isFalse();
        Assertions.assertThat(tree.toString()).isEmpty();
    }
}
