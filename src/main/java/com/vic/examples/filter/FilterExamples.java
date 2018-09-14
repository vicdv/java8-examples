package com.vic.examples.filter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class FilterExamples {
    static class Person {
        private Long id;
        private String name;

        Person(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();
        System.out.println(filterPeopleByName(people, "Victor"));
        System.out.println(filterPeopleByName(people, "Alex"));
        System.out.println(filterPeople(people, (p) -> "Victor".equals(p.getName())));
        System.out.println(filterPeople(people, (p) -> "Alex".equals(p.getName())));
        System.out.println(filterPeopleByName2(people, "Victor"));
        System.out.println(filterPeopleByName2(people, "Alex"));
        System.out.println(getFirstPersonWithName(people, "Victor").get());
        testDistinct();
        testLimit();
        testSkip();
    }

    private static List<Person> createPeople() {
        Person person1 = new Person(1L, "Joe");
        Person person2 = new Person(2L, "Victor");
        Person person3 = new Person(3L, "Maria");
        Person person4 = new Person(4L, "Victor");
        return Arrays.asList(person1, person2, person3, person4);
    }

    private static List<Person> filterPeopleByName(List<Person> people, String name) {
        Objects.requireNonNull(name);
        return people.stream().filter((p) -> name.equals(p.getName())).collect(toList());
    }

    private static List<Person> filterPeople(List<Person> people, Predicate<Person> predicate) {
        return people.stream().filter(predicate).collect(toList());
    }

    private static List<Person> filterPeopleByName2(List<Person> people, String name) {
        Objects.requireNonNull(name);
        return filterPeople(people, (p) -> name.equals(p.getName()));
    }

    private static Optional<Person> getFirstPersonWithName(List<Person> people, String name) {
        return people.stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    private static void testDistinct() {
        System.out.println("testDistinct");
        List<Integer> numbers = Arrays.asList(1, 4, 5, 2, 4, 5, 8);
        numbers.forEach(System.out::print);
        System.out.println();
        numbers.stream().distinct().forEach(System.out::print);
        System.out.println("\ntestDistinct");
    }

    private static void testLimit() {
        System.out.println("testLimit");
        System.out.println(IntStream.range(0, 10).filter(i -> i % 2 == 1).limit(3).boxed().collect(toList()));
        System.out.println("testLimit");
    }

    private static void testSkip() {
        System.out.println("testSkip");
        IntStream.range(0, 10).filter(i -> i % 2 == 1).skip(3).forEach(i -> System.out.print(i + " "));
        System.out.println("\ntestSkip");
    }

}
