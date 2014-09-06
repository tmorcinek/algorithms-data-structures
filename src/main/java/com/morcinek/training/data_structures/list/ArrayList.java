package com.morcinek.training.data_structures.list;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ArrayList<T> implements List<T> {

    public static final int ARRAY_INITIAL_SIZE = 20;

    private Object[] array = new Object[ARRAY_INITIAL_SIZE];

    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T object) {
        array[size] = object;
        size++;
        if (size == array.length) {
            extendArray();
        }
    }

    private void extendArray() {
        Object[] newArray = new Object[size * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int search(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T delete(int index) {
        T object = null;
        if (index < size) {
            object = (T) array[index];
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
        return object;
    }
}
