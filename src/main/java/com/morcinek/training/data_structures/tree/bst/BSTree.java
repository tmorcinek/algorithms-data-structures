package com.morcinek.training.data_structures.tree.bst;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface BSTree<T extends Comparable<T>> {

    public void insert(T value);

    public Object[] getInOrderValues();

    public boolean search(T value);

    public T minimum();

    public T maximum();

    public T predecessor(T value);

    public T successor(T value);
}
