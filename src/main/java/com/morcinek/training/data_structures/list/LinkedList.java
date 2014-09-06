package com.morcinek.training.data_structures.list;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedList<T> implements List<T> {

    private class Node {

        private T value;

        private Node nextNode;

        private Node(T value, Node nextNode) {
            this.nextNode = nextNode;
            this.value = value;
        }
    }

    private Node rootNode;

    @Override
    public int size() {
        return rootNode != null?1:0;
    }

    @Override
    public void insert(T object) {
        if (rootNode == null) {
            rootNode = new Node(object, null);
        }
    }
}
