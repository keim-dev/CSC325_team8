package sms_abstract;

/**
 * This class represents a circle, extending the abstract ShapeAbstract class.
 * It includes a property for radius and provides implementations
 * for calculating area, drawing the circle, and describing it.
 */
public class CircleAbstract extends ShapeAbstract {
    private double radius;

    /**
     * Constructs a CircleAbstract object with the specified color, name, and radius.
     * @param c the color of the circle
     * @param n the name of the circle
     * @param r the radius of the circle
     */
    public CircleAbstract(String c, String n, double r) {
        super(c, n);
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
        System.out.println("Drawing a circle with a radius of " + radius);
    }

    /**
     * Prints a description of the circle to the console.
     */
    @Override
    public void describe() {
        System.out.println("This is a " + color + " circle named " + name + " with a radius of " + radius);
    }

}