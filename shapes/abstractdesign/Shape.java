package shapes.abstractdesign;

/**
 * Abstract class representing a generic Shape.
 * Provides fields for color and name, and abstract methods for area, drawing, and description.
 */
public abstract class Shape {
    protected String color;
    protected String name;

    /**
     * Constructor for Shape.
     * @param color The color of the shape.
     * @param name The name of the shape.
     */
    public Shape(String color, String name) {
        this.color = color;
        this.name = name;
    }

    /**
     * Abstract method to calculate the area of the shape.
     * @return The area of the shape.
     */
    public abstract double getArea();

    /**
     * Abstract method to draw the shape.
     */
    public abstract void draw();

    /**
     * Abstract method to describe the shape.
     */
    public abstract void describe();
}