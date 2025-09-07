/* JavaDoc:
  * This is an abstract class representing a geometric shape.
  * It contains common properties like color and name, and declares
  * abstract methods for calculating area, drawing the shape, and describing it.
  *
*/
package sms_abstract;

/**
 * This is an abstract class representing a geometric shape.
 * It contains common properties like color and name, and declares
 * abstract methods for calculating area, drawing the shape, and describing it.
 */
public abstract class ShapeAbstract {
    /**
     * The color of the shape.
     */
    protected String color;

    /**
     * The name of the shape.
     */
    protected String name;

    /**
     * Constructs a ShapeAbstract object with the specified color and name.
     * @param c the color of the shape
     * @param n the name of the shape
     */
    public ShapeAbstract(String c, String n) {
        color = c;
        name = n;
    }

    /**
     * Calculates and returns the area of the shape.
     * @return the area as a double
     */
    public abstract double area();

    /**
     * Draws the shape (prints a representation to the console).
     */
    public abstract void draw();

    /**
     * Prints a description of the shape to the console.
     */
    public abstract void describe();
}
