package com.morcinek.training.data_structures.tree;

import com.morcinek.training.data_structures.tree.linked.RecursiveLinkedTree;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class RecursiveLinkedTreeTest extends TreeTest {

    @Override
    protected RecursiveLinkedTree<Integer> createLinkedTree(Node<Integer> rootNode) {
        return new RecursiveLinkedTree<Integer>(rootNode);
    }
}
