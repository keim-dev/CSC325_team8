package shapes.interfacedesign;

/**
 * Triangle class that implements Drawable, Calculable, and Describable interfaces.
 * Represents a triangle with a specific base and height.
 */
public class Triangle implements Drawable, Calculable, Describable {
    private String color;
    private double base;
    private double height;

    /**
     * Constructor for Triangle.
     * @param color The color of the triangle.
     * @param base The base of the triangle.
     * @param height The height of the triangle.
     */
    public Triangle(String color, double base, double height) {
        this.color = color;
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }

    @Override
    public void describe() {
        System.out.println("This is a " + color + " Triangle with base " + base + " and height " + height);
    }
}