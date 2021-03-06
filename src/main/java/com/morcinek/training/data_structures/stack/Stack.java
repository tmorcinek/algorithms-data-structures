package com.morcinek.training.data_structures.stack;

import java.util.EmptyStackException;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class Stack<T> {

    public static final int ARRAY_INITIAL_SIZE = 20;

    private Object[] array = new Object[ARRAY_INITIAL_SIZE];

    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T i) {
        addElement(i);
    }

    public T pop() {
        size--;
        try {
            return (T) array[size];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    private void addElement(T i) {
        array[size] = i;
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
}
