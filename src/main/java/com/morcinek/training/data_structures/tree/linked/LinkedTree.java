package com.morcinek.training.data_structures.tree.linked;

import com.morcinek.training.data_structures.list.ArrayList;
import com.morcinek.training.data_structures.list.List;
import com.morcinek.training.data_structures.stack.Stack;
import com.morcinek.training.data_structures.tree.Node;
import com.morcinek.training.data_structures.tree.Tree;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedTree<T> implements Tree<T> {

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
        while (!stack.isEmpty()){
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

    @Override
    public int getTreeHeight() {
        return 0;
    }
}