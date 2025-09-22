package com.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TopToolbar extends HBox {
    private Button clearButton;
    private DrawingCanvas canvas;

    public TopToolbar(DrawingCanvas canvas) {
        super(20);
        this.canvas = canvas;
        initialize();
    }

    private void initialize() {
        Label welcomeLabel = new Label("Welcome to Drawing App");
        clearButton = new Button("Clear Canvas");
        clearButton.setOnAction(event -> canvas.clear());

        setAlignment(Pos.TOP_LEFT);
        setPadding(new Insets(10));
        setStyle("-fx-border-color: black; -fx-background-color: lightgray;");
        getChildren().addAll(welcomeLabel, clearButton);
        setMaxHeight(100);
    }
}