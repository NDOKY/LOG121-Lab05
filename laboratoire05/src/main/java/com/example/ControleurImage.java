package com.example;

import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.event.EventHandler;

public class ControleurImage {
    
    private ModelPerspective perspective;
    private ModelImage image;

    // Constructor to initialize models
    public ControleurImage(ModelPerspective perspective, ModelImage image) {
        this.perspective = perspective;
        this.image = image;
    }
    
    // Event handler for mouse drag
    public EventHandler<MouseEvent> getMouseDragEventHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                perspective.setPerspective("Movement");
                image.setImage("Movement");
            }
        };
    }

    // Event handler for mouse wheel
    public EventHandler<ScrollEvent> getMouseWheelEventHandler() {
        return new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                if (event.getDeltaY() > 0) {
                    perspective.setPerspective("Zoom In");
                    image.setImage("Zoom In");
                } else {
                    perspective.setPerspective("Zoom Out");
                    image.setImage("Zoom Out");
                }
            }
        };
    }
}
