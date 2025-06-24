package com.currencyconverter.service;

import com.currencyconverter.config.ApiConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ExchangeRateFetcher {
    public Map<String, Double> fetchRates(String baseCurrency) throws Exception {
        String urlStr = ApiConfig.API_URL + baseCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Failed to fetch rates: HTTP " + responseCode);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        JSONObject json = new JSONObject(content.toString());
        JSONObject rates = json.getJSONObject("rates");
        Map<String, Double> rateMap = new HashMap<>();
        for (String key : rates.keySet()) {
            rateMap.put(key, rates.getDouble(key));
        }
        return rateMap;
    }
}
