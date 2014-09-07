package com.morcinek.training.data_structures.list;

import java.util.Arrays;

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
        increaseCapacityIfNeeded();
    }

    @Override
    public void insert(T object, int index) {
        checkIndex(index - 1);
        size++;
        increaseCapacityIfNeeded();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseCapacityIfNeeded() {
        if (size == array.length) {
            increaseCapacity();
        }
    }

    private void increaseCapacity() {
        Object[] newArray = new Object[size * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
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
        checkIndex(index);
        T object = null;
        if (index < size) {
            object = (T) array[index];
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
        return object;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
