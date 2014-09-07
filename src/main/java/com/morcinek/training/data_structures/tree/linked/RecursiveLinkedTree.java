package com.morcinek.training.data_structures.tree.linked;

import com.morcinek.training.data_structures.list.ArrayList;
import com.morcinek.training.data_structures.list.List;
import com.morcinek.training.data_structures.tree.Node;
import com.morcinek.training.data_structures.tree.Tree;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class RecursiveLinkedTree<T> implements Tree<T> {

    private Node<T> rootNode;

    public RecursiveLinkedTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public Object[] getAllValues() {
        List<T> list = new ArrayList<T>();
        addNodeValues(list, rootNode);
        return list.toArray();
    }

    private void addNodeValues(List<T> list, Node<T> rootNode) {
        list.insert(rootNode.getValue());
        if (rootNode.getLeftNode() != null) {
            addNodeValues(list, rootNode.getLeftNode());
        }
        if (rootNode.getRightNode() != null) {
            addNodeValues(list, rootNode.getRightNode());
        }
    }

    @Override
    public int getTreeHeight() {
        return getNodeHeight(rootNode, 1);
    }

    private int getNodeHeight(Node<T> rootNode, int i) {
        return Math.max(Math.max(i, getNodeHeightIfNotNull(i, rootNode.getLeftNode())), getNodeHeightIfNotNull(i, rootNode.getRightNode()));
    }

    private int getNodeHeightIfNotNull(int i, Node<T> leftNode) {
        return leftNode != null ? getNodeHeight(leftNode, i + 1) : 0;
    }
}