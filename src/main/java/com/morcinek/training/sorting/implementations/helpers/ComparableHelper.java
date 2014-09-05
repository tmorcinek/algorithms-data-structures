package com.morcinek.training.sorting.implementations.helpers;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ComparableHelper<T extends Comparable<T>> {

    public boolean isGreaterThan(T greater, T lower) {
        return greater.compareTo(lower) > 0;
    }

    public void swapValues(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
