package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        ShapeSelector shapeSelector = new ShapeSelector();
        DrawingCanvas canvas = new DrawingCanvas(450, 300, shapeSelector);
        TopToolbar toolbar = new TopToolbar(canvas);

        BorderPane root = new BorderPane();
        root.setTop(toolbar);
        root.setLeft(shapeSelector);
        root.setRight(canvas);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Drawing App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}