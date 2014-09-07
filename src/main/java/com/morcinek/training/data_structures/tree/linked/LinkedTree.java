package com.morcinek.training.data_structures.tree.linked;

import com.morcinek.training.data_structures.list.ArrayList;
import com.morcinek.training.data_structures.list.List;
import com.morcinek.training.data_structures.stack.Stack;
import com.morcinek.training.data_structures.tree.Node;
import com.morcinek.training.data_structures.tree.Tree;

import java.util.Comparator;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> rootNode;

    public LinkedTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public Object[] getAllValues() {
        List<T> list = new ArrayList<T>();
        addNodeValues(list, rootNode);
        return list.toArray();
    }

    private void addNodeValues(List<T> list, Node<T> rootNode) {
        Stack<Node<T>> stack = new Stack<Node<T>>();
        stack.push(rootNode);
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            list.insert(node.getValue());
            if (node.getLeftNode() != null) {
                stack.push(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                stack.push(node.getRightNode());
            }
        }
    }


    private class NodeHeight {

        private Node<T> node;
        private int height;

        private NodeHeight(Node<T> node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    @Override
    public int getTreeHeight() {
        int maxHeight = 1;
        Stack<NodeHeight> stack = new Stack<NodeHeight>();
        stack.push(new NodeHeight(rootNode, maxHeight));
        while (!stack.isEmpty()) {
            NodeHeight nodeHeight = stack.pop();
            if (nodeHeight.node.getLeftNode() != null) {
                stack.push(new NodeHeight(nodeHeight.node.getLeftNode(), nodeHeight.height + 1));
            }
            if (nodeHeight.node.getRightNode() != null) {
                stack.push(new NodeHeight(nodeHeight.node.getRightNode(), nodeHeight.height + 1));
            }
            maxHeight = Math.max(maxHeight, nodeHeight.height);
        }
        return maxHeight;
    }

    @Override
    public T getMaxValue() {
        return null;
    }
}