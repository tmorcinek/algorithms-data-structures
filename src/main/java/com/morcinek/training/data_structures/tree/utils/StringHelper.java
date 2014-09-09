package com.morcinek.training.data_structures.tree.utils;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class StringHelper {

    public static String printChild(Printable printable, int level){
        return (printable != null ? printable.toString(level + 1) : "");
    }

    public static String printValue(Object value, int level) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            stringBuilder.append("   ");
        }
        stringBuilder.append(value);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public interface Printable {

        String toString(int level);
    }
}
