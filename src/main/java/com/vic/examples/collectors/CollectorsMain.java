package com.vic.examples.collectors;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsMain {
    public static void main(String[] args) {
        groupingTransactionsByCurrency();
        maxBy();
        summing();
        joining();
    }

    private static void groupingTransactionsByCurrency() {
        System.out.println("groupingTransactionsByCurrency");
        List<Transaction> transactions = createTransactions();
        Map<Currency, List<Transaction>> transactionsByCurrency = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println(transactionsByCurrency);
        System.out.println("groupingTransactionsByCurrency");
    }


    private static void maxBy() {
        System.out.println("maxBy");
        List<Transaction> transactions = createTransactions();
        Optional<Transaction> lastTransaction = transactions.stream()
                .collect(Collectors.maxBy(Comparator.comparingLong(Transaction::getId)));
        lastTransaction.ifPresent(System.out::println);
        Optional<Transaction> highestValue = transactions.stream().max(Comparator.comparing(Transaction::getValue));
        System.out.println(highestValue.get());
        System.out.println("maxBy");
    }

    private static void summing() {
        System.out.println("summing");
        List<Transaction> transactions = createTransactions();
        Long collect = transactions.stream().collect(Collectors.summingLong(Transaction::getId));
        System.out.println(collect);
        System.out.println("summing");
    }

    private static void joining() {
        System.out.println("joining");
        List<Transaction> transactions = createTransactions();
        String ids = transactions.stream().map(transaction -> String.valueOf(transaction.getId().longValue()))
                .collect(Collectors.joining(", "));
        System.out.println(ids);
        System.out.println("joining");
    }

    private static List<Transaction> createTransactions() {
        return Arrays.asList(
                new Transaction(1L, BigDecimal.ONE, Currency.getInstance(Locale.GERMANY)),
                new Transaction(2L, BigDecimal.TEN, Currency.getInstance(Locale.CANADA)),
                new Transaction(3L, BigDecimal.valueOf(20L), Currency.getInstance(Locale.GERMANY)));
    }
}
