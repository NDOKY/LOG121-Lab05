package com.example;
import javafx.scene.input.MouseEvent;

import javafx.event.EventHandler;

public class ControleurImage {
    
    private ModelPerspective perspective;
    private ModelImage image;
    
    //event handler pour mouse click
    public EventHandler<MouseEvent> getEventHandler(){
        return new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                perspective.setPerspective("Image");
                image.setImage("Image");
            }
        };
    }

    //event handler pour mouse scroll
    public EventHandler<MouseEvent> getEventHandler2(){
        return new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                perspective.setPerspective("Texte");
                image.setImage("Texte");
            }
        };
    }

}
