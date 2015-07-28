package com.github.maciejwalkowiak.as;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharGrouperTest {
    private CharGrouper charGrouper = new CharGrouper(new ArraySorter(), new StringCompressor());

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullInput() {
        charGrouper.group(null);
    }

    @Test
    public void shouldSortAndCompressString() {
        assertThat(charGrouper.group("abzuaaissna")).isEqualTo("a4bins2uz");
    }
}
