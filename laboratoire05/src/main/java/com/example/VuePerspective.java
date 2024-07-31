package com.example;
import javafx.scene.image.Image;

public class VuePerspective implements Observer{

    String nomPerspective;
    
    
    public VuePerspective(String nomPerspective) {
        this.nomPerspective = nomPerspective;
    }

    public void display(){
        System.out.println("VuePerspective01 a été notifié");
        
    }


}
