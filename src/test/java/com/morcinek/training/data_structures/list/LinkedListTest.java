package com.morcinek.training.data_structures.list;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LinkedListTest extends AbstractListTest {

    @Override
    protected List<Integer> createList() {
        return new LinkedList<Integer>();
    }
}
