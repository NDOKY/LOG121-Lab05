package com.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class Layout {
    private ControleurImage controller;
    private ModelImage model;
    private ModelPerspective perspective;

    public Layout(ModelImage model, ModelPerspective perspective, ControleurImage controller) {
        this.model = model;
        this.perspective = perspective;
        this.controller = controller;
    }

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
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        pressePapierMenu.getItems().addAll(copyItem, pasteItem);

        menuBar.getMenus().addAll(fichierMenu, editionMenu, pressePapierMenu);

        // Layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        GridPane gridPane = new GridPane();
        ImageView imageView01 = new ImageView();
        ImageView imageView02 = new ImageView();
        ImageView imageView03 = new ImageView();

        imageView01.setFitWidth(800 / 3);
        imageView01.setFitHeight(600);
        imageView02.setFitWidth(800 / 3);
        imageView02.setFitHeight(600);
        imageView03.setFitWidth(800 / 3);
        imageView03.setFitHeight(600);
        imageView01.setPreserveRatio(true);
        imageView02.setPreserveRatio(true);
        imageView03.setPreserveRatio(true);

        gridPane.add(imageView01, 0, 0);
        gridPane.add(imageView02, 1, 0);
        gridPane.add(imageView03, 2, 0);

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33.33);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33.33);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(33.33);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);

        // Initialize and add observers
        VueFixe vueFixe = new VueFixe(imageView01);
        VuePerspective vuePerspective01 = new VuePerspective(imageView02);
        VuePerspective vuePerspective02 = new VuePerspective(imageView03);

        model.addObserver(vueFixe);
        model.addObserver(vuePerspective01);
        model.addObserver(vuePerspective02);

        // Set action for Load Image menu item
        loadImageItem.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                String filePath = file.toURI().toString();
                Charger charger = new Charger(filePath);
                charger.executer(); // Load the image
                Image loadedImage = charger.getLoadedImage();
                if (loadedImage != null) {
                    imageView01.setImage(loadedImage);
                    imageView02.setImage(loadedImage);
                    imageView03.setImage(loadedImage);
                }
            }
        });

        // Set action for Load Perspective menu item
        loadPerspectiveItem.setOnAction(e -> {
            // Assuming perspective loading logic
            // Implement accordingly
        });

        borderPane.setCenter(gridPane);
        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
