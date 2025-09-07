package sms_abstract;

/**
 * This class represents a rectangle, extending the abstract ShapeAbstract class.
 * It includes properties for height and width, and provides implementations
 * for calculating area, drawing the rectangle, and describing it.
 */
public class RectangleAbstract extends ShapeAbstract {
    private double height;
    private double width;

    /**
     * Constructs a RectangleAbstract object with the specified color, name, height, and width.
     * @param c the color of the rectangle
     * @param n the name of the rectangle
     * @param h the height of the rectangle
     * @param w the width of the rectangle
     */
    public RectangleAbstract(String c, String n, double h, double w) {
        super(c, n);
        height = h;
        width = w;
    }

    /**
     * Calculates and returns the area of the rectangle.
     * @return the area as a double
     */
    @Override
    public double area() {
        return height * width;
    }

    /**
     * Draws the rectangle (prints a message to the console).
     */
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with a height of " + height + " and a width of " + width);
    }

    /**
     * Prints a description of the rectangle to the console.
     */
    @Override
    public void describe() {
        System.out.println("This is a " + color + " rectangle named " + name + " with an area of " + this.area() );
    }

}