package com.example.ImageGenerator_AI_Challenge.Application.Domain.Image_Generator;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_image_generator")
public class Image_Generator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte[] imageData;

    private int size;

    public Image_Generator(Long id, byte[] imageData) {
        this.id = id;
        this.imageData = imageData;
    }

    public Image_Generator(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
