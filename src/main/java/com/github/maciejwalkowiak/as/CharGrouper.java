package com.github.maciejwalkowiak.as;

import org.springframework.util.Assert;

public class CharGrouper {
    private final ArraySorter arraySorter;
    private final StringCompressor stringCompressor;

    CharGrouper(ArraySorter arraySorter, StringCompressor stringCompressor) {
        Assert.notNull(arraySorter);
        Assert.notNull(stringCompressor);
        this.arraySorter = arraySorter;
        this.stringCompressor = stringCompressor;
    }

    public String group(String input) {
        Assert.notNull(input, "Input cannot be null");

        return stringCompressor.compress(
            StringArrayUtils.intArrayToString(
                arraySorter.sort(StringArrayUtils.stringToIntArray(input))
            )
        );
    }
}
