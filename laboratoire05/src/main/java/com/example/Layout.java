package com.example;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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

        
        //create 3 image view for the 3 perspectives
        ImageView imageView01 = new ImageView();
        ImageView imageView02 = new ImageView();
        ImageView imageView03 = new ImageView();
        // give them a set size witdh and height that will be displayed in the gridpane
        // the size and witdh has to take the third of the gridpane size
        imageView01.setFitWidth(800/3);
        imageView01.setFitHeight(600);
        imageView02.setFitWidth(800/3);
        imageView02.setFitHeight(600);
        imageView03.setFitWidth(800/3);
        imageView03.setFitHeight(600);


        //add the image views to the gridpane
        gridPane.add(imageView01, 0, 0);
        gridPane.add(imageView02, 1, 0);
        gridPane.add(imageView03, 2, 0);

        //add a constraint to the gridpane to make the image views take the whole space of the gridpane
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33.33);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33.33);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(33.33);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);

    
        //add in an image in a view for testing purposes
        imageView01.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        imageView02.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));
        imageView03.setImage(new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png"));

        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
