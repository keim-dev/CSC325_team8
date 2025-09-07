package sms_interface;
import java.lang.Math;

/**
 * Circle_i implements a circle shape using interfaces.
 * Implements Calculable, Drawable, and Describable interfaces to provide area calculation,
 * drawing, and description functionality for a circle.
 */
public class Circle_i implements Calculable, Drawable, Describable {
    private String color;
    private String name;
    private double radius;

    /**
     * Constructs a Circle_i object with the specified color, name, and radius.
     * @param c the color of the circle
     * @param n the name of the circle
     * @param r the radius of the circle
     */
    public Circle_i(String c, String n, double r) {
        color = c;
        name = n;
        radius = r;
    }

    /**
     * Calculates and returns the area of the circle.
     * @return the area as a double
     */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Draws the circle (prints a message to the console).
     */
    @Override
    public void draw() {
      System.out.println( "Drawing a circle with a radius of " + radius);
    }

    /**
     * Prints a description of the circle to the console.
     */
    @Override
    public void describe() {
        System.out.println( "This is a " + color + " circle named " + name + " with a radius of " + radius );
    }
}