package com.morcinek.training.data_structures.list;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public abstract class AbstractListTest {

    private List<Integer> list;

    protected abstract List<Integer> createList();

    @Before
    public void setUpLinkedList() throws Exception {
        list = createList();
    }

    @Test
    public void stackEmptyTest() throws Exception {
        Assertions.assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void stackNotEmptyTest() throws Exception {
        list.insert(0);
        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void stackWithTenValuesTest() throws Exception {
        for (int i = 0; i < 21; i++) {
            list.insert(i);
        }
        Assertions.assertThat(list.size()).isEqualTo(21);
    }

    @Test
    public void getValuesTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            list.insert(i);
        }
        Assertions.assertThat(list.get(9)).isEqualTo(9);
        Assertions.assertThat(list.get(3)).isEqualTo(3);
    }

    @Test
    public void getValuesSimpleTest() throws Exception {
        list.insert(14);
        list.insert(26);
        list.insert(198);
        Assertions.assertThat(list.get(0)).isEqualTo(14);
        Assertions.assertThat(list.get(1)).isEqualTo(26);
        Assertions.assertThat(list.get(2)).isEqualTo(198);
        Assertions.assertThat(list.get(3)).isNull();
    }

    @Test
    public void getValuesFromEmptyListTest() throws Exception {
        Assertions.assertThat(list.get(0)).isNull();
    }

    @Test
    public void searchValueTest() throws Exception {
        list.insert(14);
        list.insert(26);
        list.insert(198);
        Assertions.assertThat(list.search(14)).isEqualTo(0);
        Assertions.assertThat(list.search(26)).isEqualTo(1);
        Assertions.assertThat(list.search(198)).isEqualTo(2);
        Assertions.assertThat(list.search(198)).isEqualTo(2);
    }

    @Test
    public void searchNonExistingValueTest() throws Exception {
        list.insert(14);
        list.insert(26);
        list.insert(198);
        Assertions.assertThat(list.search(21)).isEqualTo(-1);
    }

    @Test
    public void deleteFirstElementInEmptyListTest() throws Exception {
        Integer delete = list.delete(0);
        Assertions.assertThat(delete).isNull();
    }

    @Test
    public void deleteFirstElementTest() throws Exception {
        list.insert(14);
        list.insert(26);
        list.insert(198);
        Integer delete = list.delete(0);
        Assertions.assertThat(delete).isEqualTo(14);
        Assertions.assertThat(list.get(0)).isEqualTo(26);
        Assertions.assertThat(list.get(1)).isEqualTo(198);
        Assertions.assertThat(list.size()).isEqualTo(2);

    }

    @Test
    public void deleteMiddleElementTest() throws Exception {
        list.insert(14);
        list.insert(26);
        list.insert(198);
        list.insert(56);
        Integer delete = list.delete(2);
        Assertions.assertThat(delete).isEqualTo(198);
        Assertions.assertThat(list.get(0)).isEqualTo(14);
        Assertions.assertThat(list.get(1)).isEqualTo(26);
        Assertions.assertThat(list.get(2)).isEqualTo(56);
        Assertions.assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void deleteLastElementTest() throws Exception {
        list.insert(14);
        list.insert(26);
        list.insert(198);
        list.insert(56);
        Integer delete = list.delete(3);
        Assertions.assertThat(delete).isEqualTo(56);
        Assertions.assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void deleteOverLastElementTest() throws Exception {
        list.insert(14);
        list.insert(26);
        Integer delete = list.delete(3);
        Assertions.assertThat(delete).isNull();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }
}
