package com.morcinek.training.sorting;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface SortMethod {

    public <T extends Comparable<T>> void sort(T[] array);
}
