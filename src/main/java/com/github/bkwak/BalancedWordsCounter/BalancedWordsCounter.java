package com.github.bkwak.BalancedWordsCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 In the exercise description, only one public method was mentioned.
 However, I used public static void main(String[] args)
 and made the other methods static to be able to show how does these methods work.
 */

public class BalancedWordsCounter {
    public static void main(String[] args) {
        System.out.println(isBalanced("mama"));
        System.out.println(count("mama"));
        System.out.println(isBalanced("ear"));
        System.out.println(count("ear"));
        System.out.println(isBalanced("aabbcbcccbaa"));
        System.out.println(count("aabbcbcccbaa"));
        System.out.println(isBalanced("dad"));
        System.out.println(count("dad"));
        System.out.println(isBalanced("elephant"));
        System.out.println(count("elephant"));
        System.out.println(isBalanced("abcba"));
        System.out.println(count("abcba"));
    }

    public static Integer count(String input) throws RuntimeException {
        if (input == null) {
            throw new RuntimeException("Input cannot be null");
        }
        if (input.isEmpty()) {
            return 0;
        }
        if (!input.matches("[a-zA-Z]+")) {
            throw new RuntimeException("Input must contain only letters");
        }
        int[] count = {0};
        IntStream.range(0, input.length()).forEach(i ->
                IntStream.range(i+1, input.length()+1).forEach(j -> {
                    String word = input.substring(i, j);
                    if (isBalanced(word)) {
                        count[0]++;
                    }
                })
        );
        return count[0];
    }

    private static boolean isBalanced(String word) {
        if (word.isEmpty()) {
            return false;
        }
        // HashMap of amounts of each letter in a word
        Map<Character, Integer> amount = new HashMap<>();
        word.chars().forEach(c -> amount.put((char) c, amount.getOrDefault((char) c, 0) + 1));
        int amountFirstLetter = -1;
        for (int num : amount.values()) {
            if (amountFirstLetter == -1) {
                amountFirstLetter = num;
            } else if (num != amountFirstLetter) {
                return false;
            }
        }
        return true;
    }
}