package com.morcinek.training.data_structures.tree.simple;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class RecursiveLinkedTreeTest extends AbstractTreeTest {

    @Override
    protected Tree<Integer> createLinkedTree(Node<Integer> rootNode) {
        return new RecursiveLinkedTree<Integer>(rootNode);
    }
}
