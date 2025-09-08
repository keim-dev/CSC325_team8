package shapes.abstractdesign;

/**
 * Circle class that extends Shape.
 * Represents a circle with a specific radius.
 */
public class Circle extends Shape {
    private double radius;

    /**
     * Constructor for Circle.
     * @param color The color of the circle.
     * @param radius The radius of the circle.
     */
    public Circle(String color, double radius) {
        super(color, "Circle");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public void describe() {
        System.out.println("This is a " + color + " Circle with radius " + radius);
    }
}