package com.morcinek.training.data_structures.tree;

import java.util.Comparator;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface Tree<T extends Comparable<T>> {

    public Object[] getAllValues();

    public int getTreeHeight();

    public T getMaxValue();
}