package com.example.ImageGenerator_AI_Challenge.Application.Domain.Text_Request;

import com.example.ImageGenerator_AI_Challenge.Application.Domain.API.OpenAIApi;
import com.example.ImageGenerator_AI_Challenge.Application.Domain.Image_Generator.Image_Generator;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Text_Request_Service {
    private final OpenAIApi openAIApi;

    public Text_Request_Service(OpenAIApi openAIApi) {
        this.openAIApi = openAIApi;
    }

    public CompletableFuture<Image_Generator> processTextRequest(Text_Request textRequest) {
        return openAIApi.processTextRequestAsync(textRequest);
    }
}