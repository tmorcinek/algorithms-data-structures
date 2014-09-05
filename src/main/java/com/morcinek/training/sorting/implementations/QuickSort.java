package com.morcinek.training.sorting.implementations;

import com.morcinek.training.sorting.SortMethod;
import com.morcinek.training.sorting.implementations.helpers.ComparableHelper;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class QuickSort<T extends Comparable<T>> implements SortMethod<T> {

    private ComparableHelper<T> comparableHelper = new ComparableHelper<T>();

    @Override
    public void sort(T[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(T[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quicksort(array, p, q);
            quicksort(array, q + 1, r);
        }
    }

    private int partition(T[] array, int p, int r) {
        T x = array[p];
        int i = p;
        int j = r;
        while (true ) {
            while (comparableHelper.isGreaterThan(array[j], x)) {
                j--;
            }
            while (comparableHelper.isGreaterThan(x, array[i])) {
                i++;
            }
            if (i < j) {
                comparableHelper.swapValues(array, j, i);
            } else {
                return j;
            }
        }
    }
}
