package shapes.abstractdesign;

/**
 * Rectangle class that extends Shape.
 * Represents a rectangle with a specific width and height.
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    /**
     * Constructor for Rectangle.
     * @param color The color of the rectangle.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(String color, double width, double height) {
        super(color, "Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public void describe() {
        System.out.println("This is a " + color + " Rectangle with width " + width + " and height " + height);
    }
}