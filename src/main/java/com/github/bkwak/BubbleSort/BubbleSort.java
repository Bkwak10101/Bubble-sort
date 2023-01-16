package com.github.bkwak.BubbleSort;

import java.util.*;
import java.util.stream.IntStream;

/*
 In the exercise description, only one public method was mentioned.
 However, I used public static void main(String[] args)
 and made the other methods static to be able to show how does these methods work.
 */

public class BubbleSort {
    public static void main(String[] args) {
        List<Integer> input1 = new ArrayList<>(Arrays.asList(1, 4, 5, 6, 8, 3, 8));
        sort(input1, Comparator.naturalOrder());
        System.out.println(input1);

        List<Double> input2 = new ArrayList<>(Arrays.asList(-9.3, 0.2, 4.0, 0.1, 5.0, 9.0));
        sort(input2, Comparator.naturalOrder());
        System.out.println(input2);

        List<Double> input3 = new ArrayList<>(Arrays.asList());
        sort(input3, Comparator.naturalOrder());
        System.out.println(input3);

        List<Double> input4 = new ArrayList<>(Arrays.asList(null, 5.0001));
        sort(input4, Comparator.naturalOrder());
        System.out.println(input4);

        List<Double> input5 = null;
        sort(input5, Comparator.naturalOrder());
        System.out.println(input5);
    }

    public static <T extends Comparable<T>> void sort(List<T> input, Comparator<? super T> comparator) {
        if (input == null) {
            throw new RuntimeException("Input cannot be null");
        }
        if (input.contains(null)) {
            input.removeAll(Collections.singleton(null));
        }
        int n = input.size();
        IntStream.range(0, n - 1).forEach(i ->
                IntStream.range(0, n - i - 1).forEach(j -> {
                    if (comparator.compare(input.get(j), input.get(j + 1)) > 0) {
                        T temp = input.get(j);
                        input.set(j, input.get(j + 1));
                        input.set(j + 1, temp);
                    }
                })
        );
    }
}