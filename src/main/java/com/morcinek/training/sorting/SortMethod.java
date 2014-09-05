package com.morcinek.training.sorting;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface SortMethod <T extends Comparable<T>>{

    public  void sort(T[] array);
}
