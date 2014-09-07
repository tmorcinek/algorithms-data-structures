package com.morcinek.training.data_structures.tree;

import org.junit.Before;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class TreeTest {

    private Node<Integer> rootNode;

    @Before
    public void setUp() throws Exception {
        rootNode = new Node<Integer>(18);
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
    }
}