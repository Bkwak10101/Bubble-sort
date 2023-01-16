package com.github.bkwak.BubbleSort;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BubbleSortTest {
    @Test
    @DisplayName("should sort ascending list of Integers")
    public void sortInput_IntegerList_Case_1() {
        List<Integer> input1 = Arrays.asList(1, 4, 5, 6, 8, 3, 8);
        List<Integer> expectedOutput1 = Arrays.asList(1, 3, 4, 5, 6, 8, 8);
        BubbleSort.sort(input1, Comparator.naturalOrder());
        assertEquals(expectedOutput1, input1);
    }

    @Test
    @DisplayName("should sort ascending list of Doubles")
    public void sortInput_DoubleList_Case_2() {
        List<Double> input2 = new ArrayList<>(Arrays.asList(-9.3, 0.2, 4.0, 0.1, 5.0, 9.0));
        List<Double> expectedOutput2 = Arrays.asList(-9.3, 0.1, 0.2, 4.0, 5.0, 9.0);
        BubbleSort.sort(input2, Comparator.naturalOrder());
        assertEquals(expectedOutput2, input2);
    }
    @Test
    @DisplayName("should output no elements in List when input is empty")
    public void sortInput_DoubleList_Case_3() {
        List<Double> input3 = new ArrayList<>();
        List<Double> expectedOutput3 = List.of();
        BubbleSort.sort(input3, Comparator.naturalOrder());
        assertEquals(expectedOutput3, input3);
    }
    @Test
    @DisplayName("should sort ascending list of Doubles and omit null element")
    public void sortInput_DoubleList_Case_4_nullValue_notConsideredInOutput() {
        List<Double> input4 = new ArrayList<>(Arrays.asList(null, 5.0001));
        List<Double> expectedOutput4 = List.of(5.0001);
        BubbleSort.sort(input4, Comparator.naturalOrder());
        assertEquals(expectedOutput4, input4);
    }
    @Test
    @DisplayName("should throw RuntimeException when input is null")
    public void sortInput_DoubleList_Case_5_throwsRuntimeException() {
        try {
            List<Double> input5 = null;
            BubbleSort.sort(input5, Comparator.naturalOrder());
        } catch (RuntimeException e) {
            assertEquals("Input cannot be null", e.getMessage());
        }
    }
}
