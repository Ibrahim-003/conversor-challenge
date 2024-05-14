package com.alura.conversorChallenge.service;

import com.alura.conversorChallenge.modelo.ConversionDivisaExAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnection {
    private String url;

    public APIConnection(String url) {
        this.url = url;
    }

    public ConversionDivisaExAPI getData() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

            ConversionDivisaExAPI conversionDivisaExAPI = gson.fromJson( response.body(), ConversionDivisaExAPI.class);

            return conversionDivisaExAPI;
        }catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
