package com.morcinek.training.data_structures.tree.bst;

import com.morcinek.training.data_structures.list.ArrayList;
import com.morcinek.training.data_structures.list.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedBSTree<T extends Comparable<T>> implements BSTree<T> {

    private class BSTNode {
        T value;
        BSTNode left;
        BSTNode right;
        BSTNode parent;

        private BSTNode(BSTNode parent, T value) {
            this.parent = parent;
            this.value = value;
        }
    }

    private BSTNode root;

    @Override
    public void insert(T value) {
        if (root == null) {
            root = new BSTNode(null, value);
        } else {
            insertNode(root, value);
        }
    }

    public void insertNode(BSTNode node, T value) {
        if (value.compareTo(node.value) <= 0) {
            if (node.left != null) {
                insertNode(node.left, value);
            } else {
                node.left = new BSTNode(node, value);
            }
        } else {
            if (node.right != null) {
                insertNode(node.right, value);
            } else {
                node.right = new BSTNode(node, value);
            }
        }
    }

    @Override
    public Object[] getInOrderValues() {
        List<T> values = new ArrayList<T>();
        getInOrderValuesToList(values, root);
        return values.toArray();
    }

    private void getInOrderValuesToList(List<T> list, BSTNode node) {
        if (node != null) {
            getInOrderValuesToList(list, node.left);
            list.insert(node.value);
            getInOrderValuesToList(list, node.right);
        }
    }

    @Override
    public boolean search(T value) {
        return searchNode(value, root) != null;
    }

    private BSTNode searchNode(T value, BSTNode node) {
        if (node == null || value.compareTo(node.value) == 0) {
            return node;
        } else if (value.compareTo(node.value) > 0) {
            return searchNode(value, node.right);
        } else {
            return searchNode(value, node.left);
        }
    }

    private BSTNode iterativeSearchNode(T value, BSTNode node) {
        while (node != null && value.compareTo(node.value) != 0) {
            if (value.compareTo(node.value) > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    @Override
    public T minimum() {
        return minimumNodeAfter(root).value;
    }

    private BSTNode minimumNodeAfter(BSTNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public T maximum() {
        return maximumNodeAfter(root).value;
    }

    private BSTNode maximumNodeAfter(BSTNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    @Override
    public T predecessor(T value) {
        BSTNode node = searchNode(value, root);
        if (node.left != null) {
            return maximumNodeAfter(node.left).value;
        } else {
            while (node.parent != null && node.parent.right != node) {
                node = node.parent;
            }
            return parentNodeValue(node);
        }
    }

    @Override
    public T successor(T value) {
        BSTNode node = searchNode(value, root);
        if (node.right != null) {
            return minimumNodeAfter(node.right).value;
        } else {
            while (node.parent != null && node.parent.left != node) {
                node = node.parent;
            }
            return parentNodeValue(node);
        }
    }

    private T parentNodeValue(BSTNode node) {
        if (node.parent != null) {
            return node.parent.value;
        } else {
            return null;
        }
    }
}
