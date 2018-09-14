package com.vic.examples.search;

import java.util.Arrays;
import java.util.List;

public class FindMatchExamples {
    public static void main(String[] args) {
        allMatch();
        noMatch();
        anyMatch();
        findAny();
    }

    private static void allMatch() {
        System.out.println("All match");
        List<String> list = Arrays.asList("V", "D", "H", "D");
        List<String> list2 = Arrays.asList("V", "V", "V", "V");
        System.out.println(list.stream().allMatch("D"::equals));
        System.out.println(list2.stream().allMatch("V"::equals));
        System.out.println("All match");
    }

    private static void noMatch() {
        System.out.println("No match");
        List<String> list = Arrays.asList("V", "D", "H", "D");
        System.out.println(list.stream().noneMatch("S"::equals));
        System.out.println(list.stream().noneMatch("V"::equals));
        System.out.println("No match");
    }

    private static void anyMatch() {
        System.out.println("any match");
        List<String> list = Arrays.asList("V", "D", "H", "D");
        System.out.println(list.stream().anyMatch("H"::equals));
        System.out.println(list.stream().anyMatch("F"::equals));
        System.out.println("any match");
    }

    private static void findAny() {
        System.out.println("find any");
        List<String> list = Arrays.asList("V", "D", "H", "D");
        list.stream().findFirst().ifPresent(System.out::println);
        System.out.println("find any");
    }

}
