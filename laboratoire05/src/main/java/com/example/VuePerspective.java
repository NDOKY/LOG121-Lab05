package com.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

public class VuePerspective implements Observer{

    String nomPerspective;
    ImageView imageView02 = new ImageView();
    ImageView imageView03 = new ImageView();
    Zoom zz;
    
    
    
    public VuePerspective(/* String nomPerspective */) {
        //this.nomPerspective = nomPerspective;
        
        imageView02.setFitWidth(800/3);
        imageView02.setFitHeight(600);
        imageView03.setFitWidth(800/3);
        imageView03.setFitHeight(600);

        imageView02.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        imageView03.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));

        imageView02.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            
            if (deltaY < 0){
                zoomFactor = 0.95;
            }
            
            event.consume();

            zz = new Zoom(imageView02, imageView02.getScaleX() * zoomFactor, imageView02.getScaleY() * zoomFactor);
            zz.executer();
        });

        imageView03.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            
            if (deltaY < 0){
                zoomFactor = 0.95;
            }
           
            event.consume();

            zz = new Zoom(imageView03, imageView03.getScaleX() * zoomFactor, imageView03.getScaleY() * zoomFactor);
            zz.executer();
        });

    }

    public void display(Double heightDouble, Double widthDouble){
        imageView02.setFitWidth(widthDouble/3);
        imageView02.setFitHeight(heightDouble);
        imageView03.setFitWidth(widthDouble/3);
        imageView03.setFitHeight(heightDouble);

    }


}
