package com.morcinek.training.data_structures.tree;

public class Node<T> {

    private T value;

    private Node<T> leftNode;

    private Node<T> rightNode;

    public Node(T value) {
        this.value = value;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int level) {
        return nodeToStringWithLevel(rightNode, level)
                + spaceGapForLevel(level)
                + value
                + nodeToStringWithLevel(leftNode, level);
    }

    private String nodeToStringWithLevel(Node node, int level) {
        return (node != null ? node.toString(level + 1) : "");
    }

    private String spaceGapForLevel(int level) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 0; i < level; i++) {
            stringBuilder.append("   ");
        }
        return stringBuilder.toString();
    }
}