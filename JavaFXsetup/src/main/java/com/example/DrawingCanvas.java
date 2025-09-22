package com.example;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawingCanvas extends Canvas {
    private GraphicsContext gc;
    private double startX, startY;
    private ShapeSelector shapeSelector;

    public DrawingCanvas(double width, double height, ShapeSelector shapeSelector) {
        super(width, height);
        this.shapeSelector = shapeSelector;
        initialize();
    }

    private void initialize() {
        setStyle("-fx-border-color: black;");
        gc = getGraphicsContext2D();
        
        setOnMousePressed(event -> {
            startX = event.getX();
            startY = event.getY();
        });

        setOnMouseReleased(event -> {
            double endX = event.getX();
            double endY = event.getY();
            double minX = Math.min(startX, endX);
            double minY = Math.min(startY, endY);
            double width = Math.abs(endX - startX);
            double height = Math.abs(endY - startY);
            gc.setFill(Color.GREEN);

            if (shapeSelector.isCircleSelected()) {
                gc.fillOval(minX, minY, width, height);
            } else if (shapeSelector.isRectangleSelected()) {
                gc.fillRect(minX, minY, width, height);
            }
        });
    }

    public void clear() {
        gc.clearRect(0, 0, getWidth(), getHeight());
    }
}