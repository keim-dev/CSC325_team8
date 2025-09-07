package sms_abstract;

/**
 * This class represents a triangle, extending the abstract ShapeAbstract class.
 * It includes properties for height and base, and provides implementations
 * for calculating area, drawing the triangle, and describing it.
 */
public class TriangleAbstract extends ShapeAbstract {
    private double height;
    private double base;

    /**
     * Constructs a TriangleAbstract object with the specified color, name, height, and base.
     * @param c the color of the triangle
     * @param n the name of the triangle
     * @param h the height of the triangle
     * @param b the base of the triangle
     */
    public TriangleAbstract(String c, String n, double h, double b) {
        super(c, n);
        height = h;
        base = b;
    }

    /**
     * Calculates and returns the area of the triangle.
     * @return the area as a double
     */
    @Override
    public double area() {
        return height * base / 2;
    }

    /**
     * Draws the triangle (prints a message to the console).
     */
    @Override
    public void draw() {
        System.out.println("Drawing a triangle with a height of " + height + " and a base of " + base);
    }

    /**
     * Prints a description of the triangle to the console.
     */
    @Override
    public void describe() {
        System.out.println("This is a " + color + " triangle named " + name + " with an area of " + this.area());
    }
}