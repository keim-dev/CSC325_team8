/* JavaDoc:
  * This is an abstract class representing a geometric shape.
  * It contains common properties like color and name, and declares
  * abstract methods for calculating area, drawing the shape, and describing it.
  *
*/
package sms_abstract;
public abstract class ShapeAbstract {
    protected String color;
    protected String name;

    public ShapeAbstract(String c, String n) {
        color = c;
        name = n;
    }

    public abstract double area();
    public abstract void draw();
    public abstract void describe();
}
