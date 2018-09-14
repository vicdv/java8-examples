package com.vic.examples.collectors;

import java.math.BigDecimal;
import java.util.Currency;

public class Transaction {
    private Long id;
    private BigDecimal value;
    private Currency currency;

    public Transaction(Long id, BigDecimal value, Currency currency) {
        this.id = id;
        this.value = value;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", value=" + value +
                ", currency=" + currency +
                '}';
    }
}
