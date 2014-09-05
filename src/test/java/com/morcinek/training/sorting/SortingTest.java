package com.morcinek.training.sorting;

import com.morcinek.training.sorting.implementations.InsertionSort;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class SortingTest {

    private static Sorter sorter = new Sorter();

    private Integer[] randomNumbers;

    private final Integer[] sortedArray = {1, 2, 3, 4, 5, 6};


    @Before
    public void setUp() throws Exception {
        randomNumbers = new Integer[]{5, 2, 4, 6, 1, 3};
    }

    @Test
    public void insertionSortTest() throws Exception {
        sorter.sort(randomNumbers, new InsertionSort());
        Assertions.assertThat(randomNumbers).isEqualTo(sortedArray);
    }

}
