package com.example;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VuePerspective implements Observer {

    String nomPerspective;
    ImageView imageView02 = new ImageView();
    ImageView imageView03 = new ImageView();
    Zoom zz;

    StackPane pane2 = createBorderedPane(imageView02);
    StackPane pane3 = createBorderedPane(imageView03);

    public VuePerspective() {
        // Initialize the ImageViews if needed
    }

    @Override
    public void display() {
        pane2.setOnScroll((ScrollEvent event) -> {
            double zoomFactor = 1.05;
            double deltaY = event.getDeltaY();

            if (deltaY < 0) {
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

            if (deltaY < 0) {
                zoomFactor = 0.95;
            }

            event.consume();

            zz = new Zoom(imageView03, imageView03.getScaleX() * zoomFactor, imageView03.getScaleY() * zoomFactor);
            zz.executer();
            System.err.println("test du scroll03");
        });

        // Add mouse event handlers for dragging
        addDragHandlers(imageView02, pane2);
        addDragHandlers(imageView03, pane3);
    }

    private StackPane createBorderedPane(ImageView imageView) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(imageView);

        Rectangle border = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.BLUE);
        border.setStrokeWidth(2);
        stackPane.getChildren().add(border);

        return stackPane;
    }

    private void addDragHandlers(ImageView imageView, StackPane pane) {
        final Delta dragDelta = new Delta();

        imageView.setOnMousePressed(event -> {
            dragDelta.x = imageView.getTranslateX() - event.getSceneX();
            dragDelta.y = imageView.getTranslateY() - event.getSceneY();
        });

        imageView.setOnMouseDragged(event -> {
            double newTranslateX = event.getSceneX() + dragDelta.x;
            double newTranslateY = event.getSceneY() + dragDelta.y;

            // Limit the movement within the pane borders
            double minX = 0 - (imageView.getBoundsInParent().getWidth() / 2);
            double maxX = pane.getWidth() - (imageView.getBoundsInParent().getWidth() / 2);
            double minY = 0 - (imageView.getBoundsInParent().getHeight() / 2);
            double maxY = pane.getHeight() - (imageView.getBoundsInParent().getHeight() / 2);

            if (newTranslateX < minX) newTranslateX = minX;
            if (newTranslateX > maxX) newTranslateX = maxX;
            if (newTranslateY < minY) newTranslateY = minY;
            if (newTranslateY > maxY) newTranslateY = maxY;

            imageView.setTranslateX(newTranslateX);
            imageView.setTranslateY(newTranslateY);
        });
    }

    private static class Delta {
        double x, y;
    }
}