package com.vic.examples.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReduceExamples {
    public static void main(String[] args) {
        sumAll();
        min();
        max();
    }

    private static void sumAll() {
        System.out.println("Sum all");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        System.out.println(new ArrayList<Integer>().stream().reduce(0, (n1, n2) -> n1 + n2));
        System.out.println(numbers.stream().reduce(Integer::sum).orElse(-1));
        System.out.println(new ArrayList<Integer>().stream().reduce(Integer::sum).orElse(-1));
        System.out.println("Sum all");
    }

    private static void min() {
        System.out.println("min");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().reduce(Integer::min).get());
        System.out.println("min");
    }

    private static void max() {
        System.out.println("max");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);
        System.out.println("max");
    }
}
