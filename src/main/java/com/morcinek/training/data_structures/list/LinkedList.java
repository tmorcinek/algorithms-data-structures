package com.morcinek.training.data_structures.list;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedList<T> implements List<T> {

    private class Node {

        private T value;

        private Node nextNode;

        private Node(T value) {
            this.value = value;
        }
    }

    private Node rootNode;

    @Override
    public int size() {
        int i = 0;
        Node currentNode = rootNode;
        while (currentNode != null) {
            i++;
            currentNode = currentNode.nextNode;
        }
        return i;
    }

    @Override
    public void insert(T object) {
        if (rootNode == null) {
            rootNode = new Node(object);
        } else {
            getLastNode().nextNode = new Node(object);
        }
    }

    private Node getLastNode() {
        Node currentNode = rootNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }
}
