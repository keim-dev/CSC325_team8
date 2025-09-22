package com.example;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ShapeSelector extends VBox {
    private RadioButton circleButton;
    private RadioButton rectangleButton;
    private Text shapeSelected;

    public ShapeSelector() {
        super(20);
        initialize();
    }

    private void initialize() {
        circleButton = new RadioButton("Circle");
        rectangleButton = new RadioButton("Rectangle");
        shapeSelected = new Text("Shape Selected: None");
        shapeSelected.setWrappingWidth(150);

        ToggleGroup shapeToggle = new ToggleGroup();
        shapeToggle.getToggles().addAll(circleButton, rectangleButton);
        shapeToggle.selectedToggleProperty().addListener((obsVal, oldVal, newVal) -> {
            if (newVal != null) {
                RadioButton selected = (RadioButton) newVal;
                shapeSelected.setText("Shape Selected: " + selected.getText());
            }
        });

        setMaxWidth(150);
        setPadding(new Insets(10));
        setStyle("-fx-border-color: black; -fx-background-color: lightgray;");
        getChildren().addAll(circleButton, rectangleButton, shapeSelected);
    }

    public boolean isCircleSelected() {
        return circleButton.isSelected();
    }

    public boolean isRectangleSelected() {
        return rectangleButton.isSelected();
    }
}