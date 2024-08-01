package com.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;

public class VuePerspective implements Observer{

    String nomPerspective;
    ImageView imageView02 = new ImageView();
    ImageView imageView03 = new ImageView();
    Zoom zz;
    
    
    
    public VuePerspective() {

        imageView02.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        imageView03.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));

    }

    @Override
    public void display(){

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


    /* public void setScroll(){

        //modelPerspective.setScaleXY(heigthDouble, widthDouble);
        //modelPerspective.setScaleY(heigthDouble);
        //image.

        imageView02.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            
            if (deltaY < 0){
                zoomFactor = 0.95;
            }
            imageView02.setScaleX(imageView02.getScaleX() * zoomFactor);
            imageView02.setScaleY(imageView02.getScaleY() * zoomFactor);
            event.consume();
            //System.out.println("test du scroll02");
        });
        //image.display(heigthDouble, widthDouble);

        imageView03.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            
            if (deltaY < 0){
                zoomFactor = 0.95;
            }
            imageView03.setScaleX(imageView03.getScaleX() * zoomFactor);
            imageView03.setScaleY(imageView03.getScaleY() * zoomFactor);
            event.consume();
            //System.out.println("test du scroll03");
        }); 


    }*/


}
