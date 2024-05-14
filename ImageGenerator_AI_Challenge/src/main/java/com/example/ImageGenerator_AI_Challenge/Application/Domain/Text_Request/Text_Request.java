package com.example.ImageGenerator_AI_Challenge.Application.Domain.Text_Request;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_text_request")
public class Text_Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    private int textSize;

    public Text_Request(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Text_Request(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }
}
