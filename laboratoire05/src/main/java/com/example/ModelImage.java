package com.example;

public class ModelImage extends Subject {
    
    private String image;
    
    public ModelImage(String image){
        this.image = image;
    }
    
    public String getImage(){
        return this.image;
    }
    
    public void setImage(String image){
        this.image = image;
        //this.notifyObserver();
    }
    
}
