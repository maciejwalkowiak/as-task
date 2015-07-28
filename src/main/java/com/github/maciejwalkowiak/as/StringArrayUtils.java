package com.github.maciejwalkowiak.as;

class StringArrayUtils {
    /**
     * Converts int array to string representation by casting each int to char
     *
     * @param input
     * @return converted string or empty string if input is null or empty
     */
    static String intArrayToString(int[] input) {
        String result = "";

        if (input != null && input.length > 0) {
            StringBuilder builder = new StringBuilder();

            for (int i : input) {
                builder.append((char) i);
            }

            result = builder.toString();
        }

        return result;
    }

    /**
     * Converts string to int array representation
     */
    static int[] stringToIntArray(String input) {
        int[] chars = new int[input.length()];
        char[] inputArray = input.toCharArray();

        for (int i = 0; i < input.length(); i++) {
            chars[i] = inputArray[i];
        }

        return chars;
    }
}
