package com.morcinek.training.data_structures.list;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 * Needs to have methods:
 * - size()
 * - get(int)
 * - search(T)
 * - insert(T)
 * - delete(T)
 * - delete(int)
 */
public interface List<T> {

    int size();

    void insert(T object);

    T get(int index);
}
