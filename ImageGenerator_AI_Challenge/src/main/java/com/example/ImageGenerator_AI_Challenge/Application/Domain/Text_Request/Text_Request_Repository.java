package com.example.ImageGenerator_AI_Challenge.Application.Domain.Text_Request;

import com.example.ImageGenerator_AI_Challenge.Application.Domain.API.OpenAIApi;
import com.example.ImageGenerator_AI_Challenge.Application.Domain.Image_Generator.Image_Generator;

import java.util.concurrent.CompletableFuture;

public class Text_Request_Repository {
    private OpenAIApi openAIApi;

    public Text_Request_Repository(OpenAIApi openAIApi) {
        this.openAIApi = openAIApi;
    }

    public CompletableFuture<Image_Generator> processTextRequestAsync(Text_Request textRequest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                Long responseId = System.currentTimeMillis();
                byte[] imageData = new byte[0];
                return new Image_Generator(responseId, imageData);
            } catch (InterruptedException e) {
                throw new RuntimeException("Error processing text request: " + e.getMessage(), e);
            }
        });
    }
}
