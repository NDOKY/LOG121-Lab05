package com.example;

import javafx.scene.image.ImageView;

public class Translation extends CommandeImage{

    ImageView img;
    Double posX = 0.0;
    Double posY = 0.0;

    
    
    public Translation(ImageView img, Double posX, Double posY) {
        this.img = img;
        this.posX = posX;
        this.posY = posY;
    }

    public double getX(){
        return img.getX();
    }

    public double getY(){
        return img.getY();
    }


    public void executer(){
        System.out.println("Translation a été exécutée");
        img.setX(posX);
        img.setY(posY);
    }   
    
}
