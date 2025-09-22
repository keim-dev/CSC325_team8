import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rectangle shape class that extends DrawableShape.
 * Draws a filled square rectangle with a black border on the canvas.
 * 
 * <p>This class implements the Strategy pattern by providing its own
 * implementation of the draw() and getArea() methods. The rectangle
 * is drawn as a square where both width and height equal the size parameter.</p>
 * 
 * <p>The rectangle is centered on the provided coordinates, with the
 * top-left corner positioned at (x - size/2, y - size/2).</p>
 * 
 * @author CSC325 Team 8
 * @version 1.0
 * @since 2025-09-21
 * @see DrawableShape
 */
public class DrawableRectangle extends DrawableShape {
    
    /**
     * Constructor for DrawableRectangle.
     * Creates a new rectangle shape with the specified properties.
     * 
     * @param x The x-coordinate of the rectangle's center point
     * @param y The y-coordinate of the rectangle's center point
     * @param size The size (width and height) of the square rectangle in pixels
     * @param color The fill color of the rectangle
     * @see DrawableShape#DrawableShape(double, double, double, Color)
     */
    public DrawableRectangle(double x, double y, double size, Color color) {
        super(x, y, size, color);
    }
    
    /**
     * Draws the rectangle on the graphics context.
     * Renders a filled square rectangle with a black border, centered on the shape's coordinates.
     * 
     * @param gc The GraphicsContext to draw on, must not be null
     * @throws NullPointerException if gc is null
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x - size/2, y - size/2, size, size);
        
        // Add a border for better visibility
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(x - size/2, y - size/2, size, size);
    }
    
    /**
     * Calculates the area of the rectangle.
     * Since this is a square rectangle, the area is size squared.
     * 
     * @return The area in square pixels (size × size)
     */
    @Override
    public double getArea() {
        return size * size; // Square rectangle
    }
    
    /**
     * Gets the shape type name for this rectangle.
     * 
     * @return The string "Rectangle"
     */
    @Override
    public String getShapeType() {
        return "Rectangle";
    }
    
    /**
     * Returns a string representation of the rectangle.
     * Includes shape type, position coordinates, size, and calculated area.
     * 
     * @return A formatted string describing the rectangle
     */
    @Override
    public String toString() {
        return String.format("%s at (%.0f, %.0f) - Size: %.0f, Area: %.1f", 
            getShapeType(), x, y, size, getArea());
    }
}