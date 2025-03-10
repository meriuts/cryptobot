package com.myapp.cryptobot.clients.binance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class MarketDataClient {

    private HttpClient binanceHttpClient;

    public MarketDataClient(HttpClient binanceHttpClient) {
        this.binanceHttpClient = binanceHttpClient;
    }

    public Double getAvgPrice() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.binance.com/api/v3/avgPrice?symbol=BTCUSDT"))
                .build();

        HttpResponse response = binanceHttpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return null;

    }
}
