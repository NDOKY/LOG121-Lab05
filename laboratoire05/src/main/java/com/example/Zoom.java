package com.example;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public class Zoom extends CommandeImage implements Serializable{

    transient public ImageView img;
    public Double valeurHeight = 0.0;
    public Double valeurWidth = 0.0;
    
    public Zoom(ImageView img, Double valeurHeight, Double valeurWidth) {
        this.img = img; 
        this.valeurHeight = valeurHeight;
        this.valeurWidth = valeurWidth;
        CommandeHistory.getInstance(Zoom.this);
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
