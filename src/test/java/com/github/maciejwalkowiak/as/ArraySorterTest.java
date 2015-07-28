package com.github.maciejwalkowiak.as;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.StrictAssertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ArraySorter.class)
public class ArraySorterTest {
    @Autowired
    private ArraySorter arraySorter;

    /**
     * Tests typical use case when all array elements are ints
     */
    @Test
    public void shouldSortArray() {
        // given
        int[] input = new int[]{50, 100, 10, 12};
        int[] expected = new int[]{10, 12, 50, 100};

        // when
        int[] result = arraySorter.sort(input);

        // then
        assertThat(result).containsExactly(expected);
    }

    /**
     * Tests that method does not fail when empty array is passed
     */
    @Test
    public void shouldReturnEmptyArrayWhenSortingEmptyArray() {
        int[] sorted = arraySorter.sort(new int[]{});

        assertThat(sorted).isEmpty();
    }

    /**
     * Tests behavior when array to sort is equal null.
     * I believe that ArraySorter#sort method should then
     * throw IllegalArgumentException with appropriate message
     */
    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionWhenPassedNull() {
        arraySorter.sort(null);
    }

    /**
     * Tests array with zero (possible corner case)
     */
    @Test
    public void shouldPutZeroBeginningOfResult() {
        // given
        int[] input = new int[]{100, 0, 10};
        int[] expected = new int[]{0, 10, 100};

        // when
        int[] result = arraySorter.sort(input);

        // then
        assertThat(result).containsExactly(expected);
    }

    /**
     * Tests negative numbers
     */
    @Test
    public void shouldHandleNegativeNumbers() {
        // given
        int[] input = new int[]{-50, 100, -10};
        int[] expected = new int[]{-50, -10, 100};

        // when
        int[] result = arraySorter.sort(input);

        // then
        assertThat(result).containsExactly(expected);
    }

    /**
     * Tests corner cases
     */
    @Test
    public void shouldHandleIntegerCornerCases() {
        // given
        int[] input = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, -10};
        int[] expected = new int[]{Integer.MIN_VALUE, -10, Integer.MAX_VALUE};

        // when
        int[] result = arraySorter.sort(input);

        // then
        assertThat(result).containsExactly(expected);
    }

    @Test
    public void shouldKeepOriginalArrayUnchanged() {
        // given
        int[] input = new int[]{-50, 100, -10};

        // when
        arraySorter.sort(input);

        // then
        assertThat(input).containsExactly(-50, 100, -10);
    }
}
