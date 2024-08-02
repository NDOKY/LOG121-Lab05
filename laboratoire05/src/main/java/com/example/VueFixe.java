package com.example;

import java.io.Serializable;

import javafx.scene.image.ImageView;

public class VueFixe implements Observer, Serializable{

    transient ImageView img01 = new ImageView();

    
    
    public VueFixe() {
        img01.setFitWidth(800/3);
        img01.setFitHeight(600);
    }



    @Override
    public void display(){
        System.out.println("VueFixe a été notifié");
    }   

}
