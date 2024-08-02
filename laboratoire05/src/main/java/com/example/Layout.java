package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



//commentaires pour la classe Layout
//cette classe est responsable de la création de l'interface graphique de l'application
//elle contient une méthode build qui prend en paramètre un stage et qui construit l'interface graphique
//elle crée un menuBar, un menu fichier, un menu edition, un menu presse papier
//elle crée des items pour chaque menu

public class Layout {

    public void build(Stage primaryStage) {
        primaryStage.setTitle("Image Editor");

        VuePerspective vp02 = new VuePerspective();
        VuePerspective vp03 = new VuePerspective();
        VueFixe vf = new VueFixe();
        ModelPerspective modelPerspective = new ModelPerspective();
        ControleurImage controleurImage; /* new ControleurImage(modelPerspective, imgPerspective); */


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
        ImageView imageView01 = vf.img01;
        ImageView imageView02 = vp02.imageView02;
        ImageView imageView03 = vp03.imageView03;
        // give them a set size witdh and height that will be displayed in the gridpane
        // the size and witdh has to take the third of the gridpane size
        
        imageView02.setFitWidth(800/3);
        imageView02.setFitHeight(600);
        imageView03.setFitWidth(800/3);
        imageView03.setFitHeight(600); 

        // Create borders using StackPane and Rectangle
        StackPane pane1 = createBorderedPane(vf.img01);

        //add the image views to the gridpane
        gridPane.add(pane1, 0, 0);
        gridPane.add(vp02.pane2, 1, 0);
        gridPane.add(vp03.pane3, 2, 0);

        //add a constraint to the gridpane to make the image views take the whole space of the gridpane
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(33.33);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(33.33);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(33.33);
        gridPane.getColumnConstraints().addAll(column1, column2, column3);


        borderPane.setCenter(gridPane);

        Scene scene = new Scene(borderPane, 800, 600);
        controleurImage = new ControleurImage(modelPerspective, vp02, vp03);
        controleurImage.updateView();
        primaryStage.setScene(scene);
        primaryStage.show();


        // Create MenuView observer for the loadImageItem
        VueMenu menuView = new VueMenu(loadImageItem, primaryStage, imageView01,vp02.imageView02,vp03.imageView03);

        undoItem.setOnAction((actionEvent) -> {
            Undo undo = new Undo();

            undo.executer();
        });

        saveItem.setOnAction((actionEvent) -> {
            Sauvegarder save = new Sauvegarder(vf, vp02, vp03);
            save.executer();
        });
        
        loadPerspectiveItem.setOnAction((actionEvent) -> {

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choisir perpesctive");
            File selectedFile = fileChooser.showOpenDialog(new Stage());
            ArrayList<Observer> mArrayList = new ArrayList<>();

            if(selectedFile != null){
                try(FileInputStream fileIn = new FileInputStream(selectedFile);
                ObjectInputStream in = new ObjectInputStream(fileIn)){
                
                    mArrayList = (ArrayList<Observer>)in.readObject();
                    in.close();
                    fileIn.close();

                    VuePerspective vp02Load = (VuePerspective)mArrayList.get(0);
                    VuePerspective vp03Load = (VuePerspective)mArrayList.get(1);
                    
                    if(vp02Load.zoom != null){
                        vp02.zoom.valeurHeight = vp02Load.zoom.valeurHeight;
                        vp02.zoom.valeurWidth = vp02Load.zoom.valeurWidth;
                        vp02.zoom.executer();

                        vp03.zoom.valeurHeight = vp03Load.zoom.valeurHeight;
                        vp03.zoom.valeurWidth = vp03Load.zoom.valeurWidth;
                        vp03.zoom.executer();
                    }

                    if(vp02Load.translation != null){
                        vp02.translation.posX = vp02Load.translation.posX;
                        vp02.translation.posY = vp02Load.translation.posY;
                        vp02.translation.executer();


                        vp03.translation.posX = vp03Load.translation.posX;
                        vp03.translation.posY = vp03Load.translation.posY;
                        vp03.translation.executer();

                    }
                    

                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
        });
    }

    // Method to create a bordered pane
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
}

