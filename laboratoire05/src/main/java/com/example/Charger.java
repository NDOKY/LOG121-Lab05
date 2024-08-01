package com.example;

import java.io.File;
import java.io.Serializable;
import javafx.scene.image.Image;

public class Charger implements CommandeImage, Serializable {
    private String filePath;
    private Image loadedImage;

    public Charger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void executer() {
        File file = new File(filePath);
        if (file.exists()) {
            loadedImage = new Image(file.toURI().toString());
        }
    }

    public Image getLoadedImage() {
        return loadedImage;
    }
}
