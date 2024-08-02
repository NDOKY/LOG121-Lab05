<<<<<<< HEAD
=======
package com.example;

import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VuePerspective implements Observer{

    String nomPerspective;
    ImageView imageView02 = new ImageView();
    ImageView imageView03 = new ImageView();
    Zoom zz;
    
    StackPane pane2 = createBorderedPane(imageView02);
    StackPane pane3 = createBorderedPane(imageView03);
    
    
    
    public VuePerspective() {


        //imageView02.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        //imageView03.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));

    }

    @Override
    public void display(){

        pane2.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            
            if (deltaY < 0){
                zoomFactor = 0.95;
            }
            
            event.consume();

            zz = new Zoom(imageView02, imageView02.getScaleX() * zoomFactor, imageView02.getScaleY() * zoomFactor);
            zz.executer();
            System.out.println("test du scroll02");
        });

        pane3.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();
            
            if (deltaY < 0){
                zoomFactor = 0.95;
            }
           
            event.consume();

            zz = new Zoom(imageView03, imageView03.getScaleX() * zoomFactor, imageView03.getScaleY() * zoomFactor);
            zz.executer();
            System.err.println("test du scroll03");
        });

    }


    private StackPane createBorderedPane(ImageView imageView) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(imageView);

        // Create a border using Rectangle
         Rectangle border = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        border.setFill(Color.TRANSPARENT); // Transparent fill for the rectangle
        border.setStroke(Color.BLUE); // Blue stroke color for the border
        border.setStrokeWidth(2); // Set the stroke width for better visibility
        stackPane.getChildren().add(border);

        return stackPane;

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
>>>>>>> ead09cff6b30f7edc4159912c698dafb0125c3b8
