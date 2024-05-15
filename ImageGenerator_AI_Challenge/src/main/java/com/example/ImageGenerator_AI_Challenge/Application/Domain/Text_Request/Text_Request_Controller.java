package com.example.ImageGenerator_AI_Challenge.Application.Domain.Text_Request;

import com.example.ImageGenerator_AI_Challenge.Application.Domain.Image_Generator.Image_Generator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class Text_Request_Controller {
    private final Text_Request_Service textRequestService;
    public Text_Request_Controller(Text_Request_Service textRequestService) {
        this.textRequestService = textRequestService;
    }

    @PostMapping("/process-text")
    public CompletableFuture<Image_Generator> processText(@RequestBody Text_Request textRequest) {
        return textRequestService.processTextRequest(textRequest);
    }
}
