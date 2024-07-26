package com.example;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//commentaires pour la classe Layout
//cette classe est responsable de la création de l'interface graphique de l'application
//elle contient une méthode build qui prend en paramètre un stage et qui construit l'interface graphique
//elle crée un menuBar, un menu fichier, un menu edition, un menu presse papier
//elle crée des items pour chaque menu

public class Layout {

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

        // Set column constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33.33);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33.33);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(33.33);

        gridPane.getColumnConstraints().addAll(column1, column2, column3);


        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
