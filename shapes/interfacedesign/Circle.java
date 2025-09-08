package shapes.interfacedesign;

/**
 * Circle class that implements Drawable, Calculable, and Describable interfaces.
 * Represents a circle with a specific radius.
 */
public class Circle implements Drawable, Calculable, Describable {
    private String color;
    private double radius;

    /**
     * Constructor for Circle.
     * @param color The color of the circle.
     * @param radius The radius of the circle.
     */
    public Circle(String color, double radius) {
        this.color = color;
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