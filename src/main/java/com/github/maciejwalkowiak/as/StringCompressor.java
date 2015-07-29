package com.github.maciejwalkowiak.as;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StringCompressor {
    public String compress(String uncompressed) {
        List<CharCounter> result = new ArrayList<>();

        // finds last item in list
        Function<List<CharCounter>, CharCounter> findLastItem = list -> list.get(list.size() - 1);

        for (Character c : uncompressed.toCharArray()) {
            if (result.isEmpty() || !findLastItem.apply(result).isSameAs(c)) {
                result.add(new CharCounter(c));
            } else {
                findLastItem.apply(result).increment();
            }
        }

        String compressed = result.stream()
            .map(CharCounter::asString)
            .collect(Collectors.joining(""));

        return compressed.length() >= uncompressed.length() ? uncompressed : compressed;
    }

    private static class CharCounter {
        private final char character;
        private int count = 1;

        public CharCounter(char character) {
            this.character = character;
        }

        public void increment() {
            this.count++;
        }

        public boolean isSameAs(char c) {
            return character == c;
        }

        public String asString() {
            return character + "" + (count > 1 ? count : "");
        }
    }
}
