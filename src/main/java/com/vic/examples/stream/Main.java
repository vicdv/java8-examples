package com.vic.examples.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        boxingProblem();
        convertStreams();
        infiniteStreamsIterate();
        infiniteStreamsGenerate();
    }

    private static void boxingProblem() {
        System.out.println("boxingProblem");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        //boxing cost because Integer needs to be unboxed to a primitive type before performing the summation
        Integer sum = stream.reduce(0, Integer::sum);
        System.out.println(sum);
        //Solution is to use IntStream
        IntStream intStream = IntStream.range(1, 6);
        System.out.println(intStream.sum());
        System.out.println("boxingProblem");
    }

    private static void convertStreams() {
        System.out.println("convert stream");
        IntStream intStream = IntStream.rangeClosed(1, 5);
        //IntStream to Stream
        Stream<Integer> stream = intStream.boxed();
        stream.forEach(System.out::print);
        System.out.println("\n");
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        //Stream to IntStream
        IntStream intStream1 = stream1.mapToInt(Integer::intValue);
        intStream1.forEach(System.out::print);
        System.out.println("\nconvert stream");
    }

    private static void infiniteStreamsIterate() {
        System.out.println("infiniteStreamsIterate iterate");
        System.out.println(" Example iterate 1");
        Stream.iterate(0, n -> n + 3).limit(4).forEach(System.out::print);
        System.out.println("\n Example iterate 1");
        System.out.println(" Example iterate 2");
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(20)
                .forEach(t -> System.out.print("(" + t[0] + "," + t[1] + "), "));
        //show fibonacci series
        System.out.println();
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(10).map(n -> n[0])
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n Example iterate 2");
        System.out.println("infiniteStreamsIterate iterate");
    }

    private static void infiniteStreamsGenerate() {
        System.out.println("infiniteStreamsIterate generate");
        Stream.generate(Math::random).limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println("\ninfiniteStreamsIterate generate");
    }
}
