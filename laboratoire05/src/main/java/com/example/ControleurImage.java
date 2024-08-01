package com.example;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class ControleurImage {
    
    private ModelPerspective perspective;
    private VuePerspective image;
    Double heigthDouble = 0.0;
    Double widthDouble = 0.0;
    ImageView img;

    // Constructor to initialize models
    public ControleurImage(ImageView img) {
        //this.perspective = perspective;
        //this.image = image;
        this.img = img;
    }
    
    // Event handler for mouse drag
    public EventHandler<MouseEvent> getMouseDragEventHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                perspective.setPerspective("Movement");
                //image.setImage("Movement");
            }
        };
    }

    public void updateView(){
        //image.

        img.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            
            if (deltaY < 0){
                zoomFactor = 0.95;
            }
            img.setScaleX(img.getScaleX() * zoomFactor);
            img.setScaleY(img.getScaleY() * zoomFactor);
            event.consume();
            System.out.println("test du scroll");
        });
        //image.display(heigthDouble, widthDouble);

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
