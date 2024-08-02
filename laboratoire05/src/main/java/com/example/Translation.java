package com.example;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public class Translation extends CommandeImage implements Serializable{

    transient ImageView img;
    Double posX = 0.0;
    Double posY = 0.0;

    
    
    public Translation(ImageView img, Double posX, Double posY) {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
        CommandeHistory.getInstance(Translation.this);
    }

    public double getX(){
        return img.getX();
    }

    public double getY(){
        return img.getY();
    }


    @Override
    public void executer(){

        img.setTranslateX(posX);
        img.setTranslateY(posY);
        
    }   
    
}
