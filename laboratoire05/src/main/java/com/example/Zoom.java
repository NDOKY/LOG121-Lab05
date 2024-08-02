package com.example;

import javafx.scene.image.ImageView;

public class Zoom extends CommandeImage{

    private ImageView img;
    private Double valeurHeight = 0.0;
    private Double valeurWidth = 0.0;
    
    public Zoom(ImageView img, Double valeurHeight, Double valeurWidth) {
        this.img = img; 
        this.valeurHeight = valeurHeight;
        this.valeurWidth = valeurWidth;
    }

    public double getX(){
        return img.getX();
    }

    public double getY(){
        return img.getY();
    }

    @Override
    public void executer(){
        img.setScaleX(valeurHeight);
        img.setScaleY(valeurWidth);
    }
}
