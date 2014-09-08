package com.morcinek.training.data_structures.tree.simple;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedTreeTest extends AbstractTreeTest {

    @Override
    protected Tree<Integer> createLinkedTree(Node<Integer> rootNode) {
        return new LinkedTree<Integer>(rootNode);
    }
}
