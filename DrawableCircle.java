import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Circle shape class that extends DrawableShape.
 * Draws a filled circle with a black border on the canvas.
 * 
 * <p>This class implements the Strategy pattern by providing its own
 * implementation of the draw() and getArea() methods. The circle is
 * drawn using the size parameter as the diameter.</p>
 * 
 * <p>The circle is centered on the provided coordinates, with the
 * top-left corner of the bounding rectangle positioned at (x - size/2, y - size/2).</p>
 * 
 * @author CSC325 Team 8
 * @version 1.0
 * @since 2025-09-21
 * @see DrawableShape
 */
public class DrawableCircle extends DrawableShape {
    
    /**
     * Constructor for DrawableCircle.
     * Creates a new circle shape with the specified properties.
     * 
     * @param x The x-coordinate of the circle's center point
     * @param y The y-coordinate of the circle's center point
     * @param size The diameter of the circle in pixels
     * @param color The fill color of the circle
     * @see DrawableShape#DrawableShape(double, double, double, Color)
     */
    public DrawableCircle(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }
    
    /**
     * Draws the circle on the graphics context.
     * Renders a filled circle with a black border, centered on the shape's coordinates.
     * 
     * @param gc The GraphicsContext to draw on, must not be null
     * @throws NullPointerException if gc is null
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x - size/2, y - size/2, size, size);
        
        // Add a border for better visibility
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeOval(x - size/2, y - size/2, size, size);
    }
    
    /**
     * Calculates the area of the circle.
     * Uses the formula: π × radius² where radius = size/2
     * 
     * @return The area in square pixels (π × (size/2)²)
     */
    @Override
    public double getArea() {
        double radius = size / 2.0;
        return Math.PI * radius * radius;
    }
    
    /**
     * Gets the shape type name for this circle.
     * 
     * @return The string "Circle"
     */
    @Override
    public String getShapeType() {
        return "Circle";
    }
    
    /**
     * Returns a string representation of the circle.
     * Includes shape type, position coordinates, diameter, and calculated area.
     * 
     * @return A formatted string describing the circle
     */
    @Override
    public String toString() {
        return String.format("%s at (%.0f, %.0f) - Diameter: %.0f, Area: %.1f", 
            getShapeType(), x, y, size, getArea());
    }
}