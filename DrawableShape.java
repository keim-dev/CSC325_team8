import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Abstract base class for all drawable shapes in the drawing application.
 * This class follows the Template Method pattern, providing common properties
 * and behavior while delegating specific implementation details to subclasses.
 * 
 * <p>All shapes have position (x, y coordinates), size, and color properties.
 * Subclasses must implement the draw method to render themselves on a GraphicsContext
 * and the getArea method to calculate their area.</p>
 * 
 * @author CSC325 Team 8
 * @version 1.0
 * @since 2025-09-21
 */
public abstract class DrawableShape {
    protected double x;
    protected double y;
    protected Color color;
    protected double size;
    
    /**
     * Constructor for DrawableShape.
     * Initializes a new drawable shape with the specified position, size, and color.
     * 
     * @param x The x-coordinate of the shape's center point
     * @param y The y-coordinate of the shape's center point
     * @param size The size of the shape (width/height for rectangles, diameter for circles)
     * @param color The fill color of the shape
     * @throws IllegalArgumentException if size is negative
     */
    public DrawableShape(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    
    /**
     * Abstract method to draw the shape on the graphics context.
     * Subclasses must provide their own implementation for rendering the shape.
     * 
     * @param gc The GraphicsContext to draw on, must not be null
     */
    public abstract void draw(GraphicsContext gc);
    
    /**
     * Abstract method to calculate the area of the shape.
     * Subclasses must implement this method based on their geometry.
     * 
     * @return The area of the shape in square pixels
     */
    public abstract double getArea();
    
    /**
     * Abstract method to get the shape type name.
     * Used for display purposes and debugging.
     * 
     * @return String representation of the shape type (e.g., "Rectangle", "Circle")
     */
    public abstract String getShapeType();
    
    // Getters
    
    /**
     * Gets the x-coordinate of the shape's center.
     * 
     * @return The x-coordinate in pixels
     */
    public double getX() {
        return x;
    }
    
    /**
     * Gets the y-coordinate of the shape's center.
     * 
     * @return The y-coordinate in pixels
     */
    public double getY() {
        return y;
    }
    
    /**
     * Gets the size of the shape.
     * For rectangles, this represents both width and height.
     * For circles, this represents the diameter.
     * 
     * @return The size in pixels
     */
    public double getSize() {
        return size;
    }
    
    /**
     * Gets the color of the shape.
     * 
     * @return The Color object representing the shape's fill color
     */
    public Color getColor() {
        return color;
    }
    
    // Setters
    
    /**
     * Sets the x-coordinate of the shape's center.
     * 
     * @param x The new x-coordinate in pixels
     */
    public void setX(double x) {
        this.x = x;
    }
    
    /**
     * Sets the y-coordinate of the shape's center.
     * 
     * @param y The new y-coordinate in pixels
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Sets the size of the shape.
     * 
     * @param size The new size in pixels, must be positive
     * @throws IllegalArgumentException if size is negative
     */
    public void setSize(double size) {
        this.size = size;
    }
    
    /**
     * Sets the color of the shape.
     * 
     * @param color The new Color object for the shape's fill, must not be null
     * @throws IllegalArgumentException if color is null
     */
    public void setColor(Color color) {
        this.color = color;
    }
}