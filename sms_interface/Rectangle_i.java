package sms_interface;

/**
 * Rectangle_i implements a rectangle shape using interfaces.
 * Implements Calculable, Drawable, and Describable interfaces to provide area calculation,
 * drawing, and description functionality for a rectangle.
 */
public class Rectangle_i implements Calculable, Drawable, Describable {
    private String color;
    private String name;
    private double width;
    private double height;

    /**
     * Constructs a Rectangle_i object with the specified color, name, width, and height.
     * @param c the color of the rectangle
     * @param n the name of the rectangle
     * @param w the width of the rectangle
     * @param h the height of the rectangle
     */
    public Rectangle_i(String c, String n, double w, double h) {
        color = c;
        name = n;
        width = w;
        height = h;
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
      System.out.println( "Drawing a rectangle with a height of " + height + " and a width of " + width);
    }

    /**
     * Prints a description of the rectangle to the console.
     */
    @Override
    public void describe() {
        System.out.println( "This is a " + color + " rectangle named " + name + " with an area of " + this.area() );
    }

    
}
