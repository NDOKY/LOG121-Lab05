package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        ModelImage model = new ModelImage("");
        ModelPerspective perspective = new ModelPerspective("");
        ControleurImage controller = new ControleurImage(model, perspective);
        Layout layout = new Layout(model, perspective, controller);
        layout.build(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
