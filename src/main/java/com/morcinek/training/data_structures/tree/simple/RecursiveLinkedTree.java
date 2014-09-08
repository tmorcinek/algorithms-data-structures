package com.morcinek.training.data_structures.tree.simple;

import com.morcinek.training.data_structures.list.ArrayList;
import com.morcinek.training.data_structures.list.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class RecursiveLinkedTree<T extends Comparable<T>> implements Tree<T> {

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

    @Override
    public T getMaxValue() {
        return getNodeMaxValue(rootNode);
    }

    private T getNodeMaxValue(Node<T> node) {
        if (node == null) {
            return null;
        } else {
            return getGreaterValue(getGreaterValue(node.getValue(), getNodeMaxValue(node.getLeftNode())), getNodeMaxValue(node.getRightNode()));
        }
    }

    private T getGreaterValue(T value, T compareValue) {
        if (compareValue == null || value.compareTo(compareValue) > 0) {
            return value;
        } else {
            return compareValue;
        }
    }
}