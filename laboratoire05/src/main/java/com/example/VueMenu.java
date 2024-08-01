package com.example;

import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Observer for menu actions
public class VueMenu implements Observer {

    private MenuItem loadImageItem;
    private Stage primaryStage;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;


    public VueMenu(MenuItem loadImageItem, Stage primaryStage, ImageView imageView1, ImageView imageView2, ImageView imageView3) {
        this.loadImageItem = loadImageItem;
        this.primaryStage = primaryStage;
        this.imageView1 = imageView1;
        this.imageView2 = imageView2;
        this.imageView3 = imageView3;
        initialize();
    }

    private void initialize() {
        loadImageItem.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
            java.io.File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView1.setImage(image);
                imageView2.setImage(image);
                imageView3.setImage(image);
                display();
            }
        });
    }

    @Override
    public void display() {
        System.out.println("Image loaded and displayed.");
    }
}