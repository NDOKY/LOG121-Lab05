package com.example;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

public class ControleurImage {

    private ModelPerspective modelPerspective;
    private VuePerspective vp02;
    private VuePerspective vp03;
    Double heigthDouble = 0.0;
    Double widthDouble = 0.0;
    ImageView img;

    public ControleurImage(ModelPerspective modelPerspective, VuePerspective vp02, VuePerspective vp03) {
        this.modelPerspective = modelPerspective;
        this.vp02 = vp02;
        this.vp03 = vp03;
        this.modelPerspective.addObserver(vp02);
        this.modelPerspective.addObserver(vp03);
    }

    // Constructor to initialize models

    
    // Event handler for mouse drag
    public EventHandler<MouseEvent> getMouseDragEventHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                modelPerspective.setPerspective("Movement");
                // image.setImage("Movement");
            }
        };
    }

    public void updateView() {
        // this.setScroll();
        this.vp02.display();
        this.vp03.display();
    }
}