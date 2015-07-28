package com.github.maciejwalkowiak.as.task003;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ArraySorter {
    public int[] sort(int[] unsorted) {
        int[] copy = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(copy);
        return copy;
    }
}
