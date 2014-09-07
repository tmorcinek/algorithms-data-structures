package com.morcinek.training.data_structures.tree;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public abstract class TreeTest {

    private Tree<Integer> tree;

    private Node<Integer> createRootNode() {
        Node<Integer> rootNode = new Node<Integer>(18);
        Node<Integer> leftNode = new Node<Integer>(12);
        leftNode.setLeftNode(new Node<Integer>(7));
        Node<Integer> lastNode = new Node<Integer>(4);
        lastNode.setLeftNode(new Node<Integer>(5));
        leftNode.setRightNode(lastNode);
        rootNode.setLeftNode(leftNode);
        Node<Integer> rightNode = new Node<Integer>(10);
        rightNode.setLeftNode(new Node<Integer>(2));
        rightNode.setRightNode(new Node<Integer>(21));
        rootNode.setRightNode(rightNode);
        return rootNode;
    }

    protected abstract Tree<Integer> createLinkedTree(Node<Integer> rootNode);

    @Before
    public void setUp() throws Exception {
        tree = createLinkedTree(createRootNode());
    }

    @Test
    public void getValuesTest() throws Exception {
        Object[] allValues = tree.getAllValues();
        Arrays.sort(allValues);
        Assertions.assertThat(allValues).isEqualTo(new Object[]{2, 4, 5, 7, 10, 12, 18, 21});
    }

    @Test
    public void getHeightTest() throws Exception {
        Assertions.assertThat(tree.getTreeHeight()).isEqualTo(4);
    }
}