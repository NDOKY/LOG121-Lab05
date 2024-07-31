package com.example;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Layout layout = new Layout();
        layout.build(stage); // Pass the primary stage to the build method
    }

    public static void main(String[] args) {
        launch(args);
    }
}


