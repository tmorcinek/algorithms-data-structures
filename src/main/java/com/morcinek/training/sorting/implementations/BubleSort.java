package com.morcinek.training.sorting.implementations;

import com.morcinek.training.sorting.SortMethod;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class BubleSort<T extends Comparable<T>> implements SortMethod<T> {

    @Override
    public void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j + 1].compareTo(array[j]) < 0) {
                    swapValues(array, j + 1, j);
                }
            }
        }
    }

    private void swapValues(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
