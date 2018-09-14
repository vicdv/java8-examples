package com.vic.examples;


import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SortExamples {
    public static class Student {
        private String name;

        Student(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<String> originNames = Arrays.asList("John", "Joe", "Victor", "Mark", "Keith");
        List<String> names = new ArrayList<>(originNames);

        sortCurrentStrings(names);
        //restore origin order names
        names = originNames;

        List<String> sortedList = sortStrings(names);


        Supplier<Stream<Student>> streamSupplier = () -> originNames.stream().map(Student::new);
        List<Student> students = streamSupplier.get().collect(Collectors.toList());

        sortCurrentStudentsByName(students);
        //restore origin order names
        students = streamSupplier.get().collect(Collectors.toList());
        List<Student> sortedStudents = sortStudentsByName(students);
    }

    private static void sortCurrentStrings(List<String> names) {
        System.out.println("Example 1");
        System.out.println(names);
        // it changes current list
        names.sort(String::compareTo);
        System.out.println(names);
    }

    private static List<String> sortStrings(List<String> names) {
        System.out.println("Example 2");
        System.out.println(names);
        List<String> sortedNames = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);
        return sortedNames;
    }

    private static void sortCurrentStudentsByName(List<Student> students) {
        System.out.println("Example 3");
        System.out.println(students);
        students.sort(comparing(Student::getName));
        System.out.println(students);
    }

    private static List<Student> sortStudentsByName(List<Student> students) {
        System.out.println("Example 4");
        System.out.println(students);
        List<Student> sortedStudents = students.stream().sorted(comparing(Student::getName)).collect(Collectors.toList());
        System.out.println(sortedStudents);
        return sortedStudents;
    }


}
