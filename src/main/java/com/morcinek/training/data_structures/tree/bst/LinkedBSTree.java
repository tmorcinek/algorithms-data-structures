package com.morcinek.training.data_structures.tree.bst;

import com.morcinek.training.data_structures.list.ArrayList;
import com.morcinek.training.data_structures.list.List;
import com.morcinek.training.data_structures.tree.utils.StringHelper;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedBSTree<T extends Comparable<T>> implements BSTree<T> {

    private class BSTNode implements StringHelper.Printable {
        T value;
        BSTNode left;
        BSTNode right;
        BSTNode parent;

        private BSTNode(BSTNode parent, T value) {
            this.parent = parent;
            this.value = value;
        }

        @Override
        public String toString() {
            return toString(0);
        }

        @Override
        public String toString(int level) {
            return StringHelper.printChild(right, level)
                    + StringHelper.printValue(value, level)
                    + StringHelper.printChild(left, level);
        }
    }

    private BSTNode root;

    @Override
    public String toString() {
        if (root != null) {
            return root.toString();
        }
        return "";
    }

    @Override
    public void insert(T value) {
//        if (root == null) {
//            root = new BSTNode(null, value);
//        } else {
//            insertNode(root, value);
//        }
        iterativeInsertNode(root, value);
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

    public void iterativeInsertNode(BSTNode node, T value) {
        BSTNode parent = null;
        while (node != null) {
            parent = node;
            if (value.compareTo(node.value) <= 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        node = new BSTNode(parent, value);
        if (parent != null) {
            if (value.compareTo(parent.value) <= 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        } else {
            root = node;
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

    private T getNodeValue(BSTNode node) {
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public T predecessor(T value) {
        return getNodeValue(predecessorNode(value));
    }

    private BSTNode predecessorNode(T value) {
        BSTNode node = searchNode(value, root);
        if (node.left != null) {
            return maximumNodeAfter(node.left);
        } else {
            while (node.parent != null && node.parent.right != node) {
                node = node.parent;
            }
            return node.parent;
        }
    }

    @Override
    public T successor(T value) {
        return getNodeValue(successorNode(value));
    }

    private BSTNode successorNode(T value) {
        return successorNode(searchNode(value, root));
    }

    private BSTNode successorNode(BSTNode node) {
        if (node.right != null) {
            return minimumNodeAfter(node.right);
        } else {
            while (node.parent != null && node.parent.left != node) {
                node = node.parent;
            }
            return node.parent;
        }
    }

    @Override
    public T delete(T value) {
        BSTNode node = searchNode(value, root);
        if (node != null) {
            BSTNode substituteNode = getSubstituteNode(node);
            BSTNode childNode = getChildNode(substituteNode);
            if (substituteNode.parent == null) {
                root = childNode;
            } else if (substituteNode == substituteNode.parent.left) {
                substituteNode.parent.left = childNode;
            } else {
                substituteNode.parent.right = childNode;
            }
            if (substituteNode != node) {
                node.value = substituteNode.value;
            }
            return value;
        } else {
            return null;
        }
    }

    private BSTNode getChildNode(BSTNode substituteNode) {
        BSTNode childNode;
        if (substituteNode.left != null) {
            childNode = substituteNode.left;
        } else {
            childNode = substituteNode.right;
        }
        if (childNode != null) {
            childNode.parent = substituteNode.parent;
        }
        return childNode;
    }

    private BSTNode getSubstituteNode(BSTNode node) {
        BSTNode substitueNode;
        if (node.left == null || node.right == null) {
            substitueNode = node;
        } else {
            substitueNode = successorNode(node);
        }
        return substitueNode;
    }
}
