package com.vic.examples.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        main.example1(transactions);
        main.example2(transactions);
        main.example3(transactions);
        main.example4(transactions);
        main.example5(transactions);
        main.example6(transactions);
        main.example7(transactions);
        main.example8(transactions);
    }

    // Find all transactions in the year 2011 and sort them by value (small to high).
    private void example1(List<Transaction> transactions) {
        System.out.println("example1");
        System.out.println(transactions);
        List<Transaction> result = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println("example1");
    }

    // What are all the unique cities where the traders work?
    private void example2(List<Transaction> transactions) {
        System.out.println("example2");
        System.out.println(transactions);
        List<String> cities = transactions.stream()
                .map(Transaction::getTrader).map(Trader::getCity)
                .distinct().collect(Collectors.toList());
        System.out.println(cities);
        System.out.println("example2");
    }

    // Find all traders from Cambridge and sort them by name
    private void example3(List<Transaction> transactions) {
        System.out.println("example3");
        System.out.println(transactions);
        List<Trader> result = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(result);
        System.out.println("example3");
    }

    // Return a string of all traders’ names sorted alphabetically.
    private void example4(List<Transaction> transactions) {
        System.out.println("example4");
        System.out.println(transactions);
        String result = transactions.stream()
                .map(t -> t.getTrader().getName()).distinct()
                .sorted().collect(Collectors.joining());
        System.out.println(result);
        System.out.println("example4");
    }

    // Are any traders based in Milan?
    private void example5(List<Transaction> transactions) {
        System.out.println("example5");
        System.out.println(transactions);
        boolean anyTraders = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> "Milan".equals(trader.getCity()));
        System.out.println(anyTraders);
        System.out.println("example5");
    }

    // Print all transactions’ values from the traders living in Cambridge
    private void example6(List<Transaction> transactions) {
        System.out.println("example6");
        System.out.println(transactions);
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(t -> System.out.print(t + " "));
        System.out.println("\nexample6");
    }

    // What’s the highest value of all the transactions?
    private void example7(List<Transaction> transactions) {
        System.out.println("example7");
        System.out.println(transactions);
        int highest = transactions.stream().map(Transaction::getValue).reduce(Integer::max).get();
        int highest2 = transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue).get();
        System.out.println(highest);
        System.out.println("example7");
    }

    // Find the transaction with the smallest value
    private void example8(List<Transaction> transactions) {
        System.out.println("example8");
        System.out.println(transactions);
        Transaction smallest = transactions.stream().min(Comparator.comparingInt(Transaction::getValue)).get();
        System.out.println(smallest);
        System.out.println("example8");
    }
}
