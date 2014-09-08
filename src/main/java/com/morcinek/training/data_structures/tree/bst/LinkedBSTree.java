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
            BSTNode node = root;
            while (node != null) {
                if (value.compareTo(node.value) <= 0) {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node.left = new BSTNode(node, value);
                        node = null;
                    }
                } else {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node.right = new BSTNode(node, value);
                        node = null;
                    }
                }
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
        return searchValue(value, root);
    }

    private boolean searchValue(T value, BSTNode node) {
        if (node != null) {
            if (value.compareTo(node.value) == 0) {
                return true;
            } else if (value.compareTo(node.value) > 0) {
                return searchValue(value, node.right);
            } else {
                return searchValue(value, node.left);
            }
        }
        return false;
    }
}
