package com.morcinek.training.data_structures.list;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ArrayList<T> implements List<T> {

    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T object) {
        size++;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int search(T object) {
        return 0;
    }

    @Override
    public T delete(int index) {
        return null;
    }
}
