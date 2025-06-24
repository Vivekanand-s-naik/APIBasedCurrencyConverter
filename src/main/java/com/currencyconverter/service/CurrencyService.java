package com.currencyconverter.service;

import com.currencyconverter.model.ConversionRequest;
import java.util.Map;

public class CurrencyService {
    private final ExchangeRateFetcher fetcher = new ExchangeRateFetcher();

    public double convert(ConversionRequest request) throws Exception {
        Map<String, Double> rates = fetcher.fetchRates(request.getBaseCurrency());
        Double targetRate = rates.get(request.getTargetCurrency());
        if (targetRate == null) {
            throw new IllegalArgumentException("Target currency not found");
        }
        return request.getAmount() * targetRate;
    }

    public Map<String, Double> getRates(String baseCurrency) throws Exception {
        return fetcher.fetchRates(baseCurrency);
    }
}
