package com.vic.examples.optional;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        System.out.println(Optional.empty());
        System.out.println(Optional.of(5));
        System.out.println(Optional.ofNullable(null));
        System.out.println(Optional.ofNullable(5));
    }
}
