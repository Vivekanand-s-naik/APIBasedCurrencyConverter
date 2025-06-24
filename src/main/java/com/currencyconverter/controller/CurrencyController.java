package com.currencyconverter.controller;

import com.currencyconverter.model.ConversionRequest;
import com.currencyconverter.service.CurrencyService;
import java.util.Map;

public class CurrencyController {
    private final CurrencyService service = new CurrencyService();

    public double convertCurrency(String base, String target, double amount) throws Exception {
        ConversionRequest request = new ConversionRequest(base, target, amount);
        return service.convert(request);
    }

    public Map<String, Double> getAvailableRates(String base) throws Exception {
        return service.getRates(base);
    }
}
