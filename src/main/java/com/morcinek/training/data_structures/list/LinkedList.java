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

    @Override
    public void insert(T object, int index) {
        try {
            Node parentNode = nodeWithIndex(index - 1);
            Node nextNode = parentNode.nextNode;
            parentNode.nextNode = new Node(object);
            parentNode.nextNode.nextNode = nextNode;
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getLastNode() {
        Node currentNode = rootNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    @Override
    public T get(int index) {
        try {
            return nodeWithIndex(index).value;
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node nodeWithIndex(int index) {
        Node currentNode = rootNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode;
    }

    @Override
    public int search(T object) {
        Node currentNode = rootNode;
        int i = 0;
        while (currentNode != null) {
            if (currentNode.value.equals(object)) {
                return i;
            }
            currentNode = currentNode.nextNode;
            i++;
        }
        return -1;
    }

    @Override
    public T delete(int index) {
        try {
            if (index == 0) {
                T value = rootNode.value;
                rootNode = rootNode.nextNode;
                return value;
            } else {
                Node node = nodeWithIndex(index - 1);
                T value = node.nextNode.value;
                node.nextNode = node.nextNode.nextNode;
                return value;
            }
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }
}
