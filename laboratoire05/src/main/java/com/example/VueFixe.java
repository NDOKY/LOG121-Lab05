package com.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VueFixe implements Observer {
    private ImageView imageView;
    private String imagePath;

    public VueFixe(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        if (imagePath != null) {
            imageView.setImage(new Image(imagePath));
        }
    }
}
