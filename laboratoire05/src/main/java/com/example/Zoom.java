package com.example;

import javafx.scene.image.ImageView;

public class Zoom implements CommandeImage{

    private ImageView img;
    private Double valeurHeight = 0.0;
    private Double valeurWidth = 0.0;
    
    public Zoom(ImageView img, Double valeurHeight, Double valeurWidth) {
        this.img = img;
        this.valeurHeight = valeurHeight;
        this.valeurWidth = valeurWidth;
    }

    @Override
    public void executer(){
        img.setFitHeight(valeurHeight);
        img.setFitWidth(valeurWidth);
    }
    
}
