package com.example;

public class VueFixe implements Observer{
    
    public void update(){
        System.out.println("VueFixe a été notifié");
    }   

    public void display() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
