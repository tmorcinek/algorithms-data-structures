package com.morcinek.training.sorting;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class Sorter {

    public <T extends Comparable<T>> void sort(T[] array, SortMethod sortMethod){
        sortMethod.sort(array);
    }
}
