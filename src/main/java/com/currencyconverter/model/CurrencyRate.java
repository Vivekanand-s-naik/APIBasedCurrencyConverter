package com.currencyconverter.model;

public class CurrencyRate {
    private final String currency;
    private final double rate;

    public CurrencyRate(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public double getRate() {
        return rate;
    }
}
