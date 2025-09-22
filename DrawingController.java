import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.beans.property.*;
import javafx.beans.binding.Bindings;

/**
 * Controller class that manages the drawing operations and shape collection.
 * This class follows the MVC pattern as the Controller component, managing
 * the business logic for shape creation, canvas operations, and data binding.
 * 
 * <p>Uses the Observer pattern through JavaFX properties and bindings to
 * automatically update the UI when the underlying data changes. The controller
 * maintains an ObservableList of shapes and provides computed properties for
 * real-time statistics.</p>
 * 
 * <p>Key responsibilities include:
 * <ul>
 * <li>Managing the collection of drawable shapes</li>
 * <li>Handling canvas drawing and clearing operations</li>
 * <li>Providing observable properties for UI binding</li>
 * <li>Managing shape selection state</li>
 * </ul></p>
 * 
 * @author CSC325 Team 8
 * @version 1.0
 * @since 2025-09-21
 */
public class DrawingController {
    private ObservableList<DrawableShape> shapes;
    private Canvas canvas;
    private GraphicsContext gc;
    private ShapeType currentShapeType;
    private Color currentColor;
    private double currentSize;
    
    // Observable properties for real-time binding
    private IntegerProperty shapeCount;
    private DoubleProperty totalArea;
    private StringProperty selectedShapeInfo;
    private ObjectProperty<DrawableShape> selectedShape;
    
    /**
     * Enum to represent different shape types available for drawing.
     * Used to determine which concrete shape class to instantiate.
     */
    public enum ShapeType {
        /** Rectangle/Square shape type */
        RECTANGLE, 
        /** Circle/Oval shape type */
        CIRCLE
    }
    
    /**
     * Constructor for DrawingController.
     * Initializes the controller with a canvas and sets up all observable properties
     * and bindings for real-time UI updates.
     * 
     * @param canvas The canvas to draw on, must not be null
     * @throws NullPointerException if canvas is null
     */
    public DrawingController(Canvas canvas) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.shapes = FXCollections.observableArrayList();
        this.currentShapeType = ShapeType.RECTANGLE;
        this.currentColor = Color.BLUE;
        this.currentSize = 50.0;
        
        // Initialize observable properties
        this.shapeCount = new SimpleIntegerProperty(0);
        this.totalArea = new SimpleDoubleProperty(0.0);
        this.selectedShapeInfo = new SimpleStringProperty("No shape selected");
        this.selectedShape = new SimpleObjectProperty<>(null);
        
        // Bind shape count to the size of the shapes list
        shapeCount.bind(Bindings.size(shapes));
        
        // Bind total area to calculated area of all shapes
        totalArea.bind(Bindings.createDoubleBinding(() -> {
            return shapes.stream().mapToDouble(DrawableShape::getArea).sum();
        }, shapes));
        
        // Set initial canvas background
        clearCanvas();
    }
    
    /**
     * Adds a new shape at the specified coordinates.
     * Creates a shape based on the current shape type and adds it to the collection.
     * The canvas is automatically redrawn and the new shape becomes selected.
     * 
     * @param x The x-coordinate where the shape should be centered
     * @param y The y-coordinate where the shape should be centered
     */
    public void addShape(double x, double y) {
        DrawableShape shape = null;
        
        switch (currentShapeType) {
            case RECTANGLE:
                shape = new DrawableRectangle(x, y, currentSize, currentColor);
                break;
            case CIRCLE:
                shape = new DrawableCircle(x, y, currentSize, currentColor);
                break;
        }
        
        if (shape != null) {
            shapes.add(shape);
            redrawCanvas();
            // Update selected shape info
            updateSelectedShapeInfo(shape);
        }
    }
    
    /**
     * Selects a shape and updates the selected shape info
     * @param shape The shape to select
     */
    public void selectShape(DrawableShape shape) {
        selectedShape.set(shape);
        updateSelectedShapeInfo(shape);
    }
    
    /**
     * Updates the selected shape information
     * @param shape The currently selected shape
     */
    private void updateSelectedShapeInfo(DrawableShape shape) {
        if (shape != null) {
            selectedShapeInfo.set(String.format("Selected: %s", shape.toString()));
        } else {
            selectedShapeInfo.set("No shape selected");
        }
    }
    }
    
    /**
     * Clears all shapes from the canvas and the shapes list
     */
    public void clearCanvas() {
        shapes.clear();
        selectedShape.set(null);
        updateSelectedShapeInfo(null);
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Add a border around the canvas
        gc.setStroke(Color.LIGHTGRAY);
        gc.setLineWidth(2);
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
    /**
     * Redraws the entire canvas with all shapes
     */
    public void redrawCanvas() {
        // Clear the canvas first
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Add border
        gc.setStroke(Color.LIGHTGRAY);
        gc.setLineWidth(2);
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        // Draw all shapes
        for (DrawableShape shape : shapes) {
            shape.draw(gc);
        }
    }
    
    // Getters and Setters
    public ShapeType getCurrentShapeType() {
        return currentShapeType;
    }
    
    public void setCurrentShapeType(ShapeType shapeType) {
        this.currentShapeType = shapeType;
    }
    
    public Color getCurrentColor() {
        return currentColor;
    }
    
    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }
    
    public double getCurrentSize() {
        return currentSize;
    }
    
    public void setCurrentSize(double size) {
        this.currentSize = size;
    }
    
    public ObservableList<DrawableShape> getShapes() {
        return shapes;
    }
    
    public int getShapeCount() {
        return shapes.size();
    }
    
    // Observable property getters for binding
    public IntegerProperty shapeCountProperty() {
        return shapeCount;
    }
    
    public DoubleProperty totalAreaProperty() {
        return totalArea;
    }
    
    public StringProperty selectedShapeInfoProperty() {
        return selectedShapeInfo;
    }
    
    public ObjectProperty<DrawableShape> selectedShapeProperty() {
        return selectedShape;
    }
    
    public double getTotalArea() {
        return totalArea.get();
    }
    
    public String getSelectedShapeInfo() {
        return selectedShapeInfo.get();
    }
    
    public DrawableShape getSelectedShape() {
        return selectedShape.get();
    }
}