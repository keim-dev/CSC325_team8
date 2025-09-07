package sms_interface;

/**
 * Triangle_i implements a triangle shape using interfaces.
 * Implements Calculable, Drawable, and Describable interfaces to provide area calculation,
 * drawing, and description functionality for a triangle.
 */
public class Triangle_i implements Calculable, Drawable, Describable {
    private String color;
    private String name;
    private double base;
    private double height;

    /**
     * Constructs a Triangle_i object with the specified color, name, base, and height.
     * @param c the color of the triangle
     * @param n the name of the triangle
     * @param b the base of the triangle
     * @param h the height of the triangle
     */
    public Triangle_i(String c, String n, double b, double h) {
        color = c;
        name = n;
        base = b;
        height = h;
    }

    /**
     * Calculates and returns the area of the triangle.
     * @return the area as a double
     */
    @Override
    public double area() {
        return 0.5 * base * height;
    }

    /**
     * Draws the triangle (prints a message to the console).
     */
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " triangle named " + name);
    }

    /**
     * Prints a description of the triangle to the console.
     */
    @Override
    public void describe() {
        System.out.println("This is a triangle named " + name + " with base " + base + " and height " + height);
    }
    
}
