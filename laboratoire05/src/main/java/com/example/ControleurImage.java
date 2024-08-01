package com.example;

import javafx.scene.image.Image;

public class ControleurImage {
    private ModelImage model;
    private ModelPerspective perspective;
    private Charger charger;

    public ControleurImage(ModelImage model, ModelPerspective perspective) {
        this.model = model;
        this.perspective = perspective;
    }

    public void loadImage(String imagePath) {
        model.setImage(imagePath);
    }

    public void loadFromFile(String filePath) {
        charger = new Charger(filePath);  // Initialize Charger with the file path
        charger.executer();
        Image loadedImage = charger.getLoadedImage();
        if (loadedImage != null) {
            model.setImage(loadedImage.getUrl());  // Update model with image URL
        }
    }
}
