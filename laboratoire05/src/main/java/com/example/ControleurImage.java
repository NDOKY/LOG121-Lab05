package com.example;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class ControleurImage {
    
    private ModelPerspective modelPerspective;
    private VuePerspective vuePerspective;
    Double heigthDouble = 0.0;
    Double widthDouble = 0.0;
    ImageView img;

    public ControleurImage(ModelPerspective modelPerspective, VuePerspective vuePerspective){
        this.modelPerspective = modelPerspective;
        this.vuePerspective = vuePerspective;
        this.modelPerspective.addObserver(vuePerspective);
    }

    
    // Event handler for mouse drag
    public EventHandler<MouseEvent> getMouseDragEventHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                modelPerspective.setPerspective("Movement");
                //image.setImage("Movement");
            }
        };
    }

    public void updateView(){

        //this.setScroll();
        this.vuePerspective.display();

    }



    // Event handler for mouse wheel
    /* public EventHandler<ScrollEvent> getMouseWheelEventHandler() {
        return new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                if (event.getDeltaY() > 0) {
                    //perspective.setPerspective("Zoom In");
                    //image.setImage("Zoom In");
                    heigthDouble += event.getDeltaX();
                    widthDouble += event.getDeltaY();
                    perspective.notifyObserver(heigthDouble, widthDouble);
                    System.out.println("Scroll up");

                } else {
                    //perspective.setPerspective("Zoom Out");
                    //image.setImage("Zoom Out");
                    heigthDouble -= event.getDeltaX();
                    widthDouble -= event.getDeltaY();

                    System.out.println("scroll down");

                }
            }
        };
    } */
}
