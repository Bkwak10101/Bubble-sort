package com.github.bkwak.BalancedWordsCounter;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedWordsCounterTest {
    @Test
    @DisplayName("should count the letters in input case and the amount of letters should be equal to the expected value")
    public void countCase_1() {
        String input1 = "aabbabcccba";
        int expectedOutput1 = 28;
        assertEquals(expectedOutput1, BalancedWordsCounter.count(input1));
    }

    @Test
    @DisplayName("should count 0 when input is empty")
    public void countCase_2() {
        String input2 = "";
        int expectedOutput2 = 0;
        assertEquals(expectedOutput2, BalancedWordsCounter.count(input2));
    }

    @Test
    @DisplayName("should throw Exception when input contains other characters")
    public void countCase3_throwsRuntimeException() {
        try {
            String input3 = "abababa1";
            BalancedWordsCounter.count(input3);
        } catch (RuntimeException e) {
            assertEquals("Input must contain only letters", e.getMessage());
        }
    }

    @Test
    @DisplayName("should throw RuntimeException when input is null")
    public void countCase4_throwsRuntimeException() {
        try {
            String input4 = null;
            BalancedWordsCounter.count(input4);
        } catch (RuntimeException e) {
            assertEquals("Input cannot be null", e.getMessage());
        }
    }
}