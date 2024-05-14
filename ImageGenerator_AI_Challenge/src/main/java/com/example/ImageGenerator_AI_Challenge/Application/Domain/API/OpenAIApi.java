package com.example.ImageGenerator_AI_Challenge.Application.Domain.API;

import com.example.ImageGenerator_AI_Challenge.Application.Domain.Image_Generator.Image_Generator;
import com.example.ImageGenerator_AI_Challenge.Application.Domain.Text_Request.Text_Request;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class OpenAIApi {
    private final String apiKey;
    private final HttpClient httpClient;

    public OpenAIApi(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
    }

    public CompletableFuture<Image_Generator> processTextRequestAsync(Text_Request textRequest) {
        String url = "https://api.openai.com/v1/images?text=" + textRequest.getText();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .build();

        return httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofByteArray())
                .thenApply(response -> {
                    if (response.statusCode() == 200) {
                        Long responseId = System.currentTimeMillis();
                        byte[] imageData = response.body();
                        return new Image_Generator(responseId, imageData);
                    } else {
                        throw new RuntimeException("Failed to process text request. Status code: " + response.statusCode());
                    }
                });
    }
}