package com.morcinek.training.sorting.implementations;

import com.morcinek.training.sorting.SortMethod;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class InsertionSort<T extends Comparable<T>> implements SortMethod<T> {

    @Override
    public void sort(T[] array) {
        for (int j = 1; j < array.length; j++) {
            T key = array[j];
            int i;
            for (i = j - 1; i >= 0 && isGreaterThan(array[i], key); i--) {
                array[i + 1] = array[i];
            }
            array[i + 1] = key;
        }
    }

    private boolean isGreaterThan(T greater, T lower) {
        return greater.compareTo(lower) > 0;
    }

}
