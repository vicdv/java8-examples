package com.vic.examples.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.toList;

public class MapExamples {
    static class User {
        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        mapExample();
        mapExample2();
        uniqueCharacters();
        allPairs();
        listOfListToList();
    }

    private static List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Joe"));
        users.add(new User(1L, "Zoe"));
        users.add(new User(1L, "Martin"));
        users.add(new User(1L, "Mike"));
        return users;
    }

    private static void mapExample() {
        System.out.println("mapExample");
        List<User> users = createUsers();
        users.stream().map(User::getName).forEach(u -> System.out.print(u + " "));
        System.out.println("\nmapExample");
    }

    private static void mapExample2() {
        System.out.println("mapExample2");
        List<String> list = Arrays.asList("Hello", "world", "man");
        list.stream().map(String::length).forEach(u -> System.out.print(u + " "));
        System.out.println("\nmapExample2");
    }

    private static void uniqueCharacters() {
        System.out.println("unique characters");
        List<String> list = Arrays.asList("Hello", "World!");
        List<String> collection = list.stream()
                .map(e -> e.split(""))
                .flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(collection);
        System.out.println("unique characters");
    }

    private static void allPairs() {
        System.out.println("all pairs");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> list = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .collect(toList());
        for (int[] e : list) {
            for (int ee : e) {
                System.out.print(ee);
            }
            System.out.println();
        }
        System.out.println("all pairs");
    }

    private static void listOfListToList() {
        System.out.println("listOfListToList");
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("lol", "hello", "xD"));
        list.add(Arrays.asList("lol2", "hello2", "xD2"));
        List<String> result = list.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(result);
        System.out.println("listOfListToList");
    }

}
