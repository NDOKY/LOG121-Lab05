package com.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Layout {

    private double zoomFactor = 1.0;

    public void build(Stage primaryStage) {
        primaryStage.setTitle("Image Editor");

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Fichier Menu
        Menu fichierMenu = new Menu("Fichier");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem loadImageItem = new MenuItem("Load Image");
        MenuItem loadPerspectiveItem = new MenuItem("Load Perspective");
        MenuItem quitItem = new MenuItem("Quit");
        fichierMenu.getItems().addAll(saveItem, loadImageItem, loadPerspectiveItem, quitItem);

        // Edition Menu
        Menu editionMenu = new Menu("Edition");
        MenuItem undoItem = new MenuItem("Undo");
        MenuItem redoItem = new MenuItem("Redo");
        editionMenu.getItems().addAll(undoItem, redoItem);

        // Presse Papier Menu
        Menu pressePapierMenu = new Menu("Presse Papier");

        menuBar.getMenus().addAll(fichierMenu, editionMenu, pressePapierMenu);

        // Layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        GridPane gridPane = new GridPane();
        ImageView fixedImageView = new ImageView();
        ImageView imageView1 = new ImageView();
        ImageView imageView2 = new ImageView();

        gridPane.add(fixedImageView, 0, 0);
        gridPane.add(imageView1, 1, 0);
        gridPane.add(imageView2, 2, 0);

        borderPane.setCenter(gridPane);

        // Zoom and Move Handlers
        gridPane.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.getDeltaY() > 0) {
                zoomFactor *= 1.1;
            } else {
                zoomFactor /= 1.1;
            }
            fixedImageView.setScaleX(zoomFactor);
            fixedImageView.setScaleY(zoomFactor);
            imageView1.setScaleX(zoomFactor);
            imageView1.setScaleY(zoomFactor);
            imageView2.setScaleX(zoomFactor);
            imageView2.setScaleY(zoomFactor);
        });

        gridPane.addEventFilter(MouseEvent.MOUSE_DRAGGED, event -> {
            fixedImageView.setTranslateX(event.getX());
            fixedImageView.setTranslateY(event.getY());
            imageView1.setTranslateX(event.getX());
            imageView1.setTranslateY(event.getY());
            imageView2.setTranslateX(event.getX());
            imageView2.setTranslateY(event.getY());
        });

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
