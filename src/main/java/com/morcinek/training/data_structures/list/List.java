package com.morcinek.training.data_structures.list;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 * Needs to have methods:
 * - size()
 * - insert(T)
 * - insert(T,int)
 * - get(int)
 * - search(T)
 * - delete(int)
 */
public interface List<T> {

    int size();

    void insert(T object);

    void insert(T object, int index);

    T get(int index);

    int search(T object);

    T delete(int index);
}
