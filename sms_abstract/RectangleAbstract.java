/* JavaDoc:
    * This class represents a rectangle, extending the abstract ShapeAbstract class.
    * It includes properties for height and width, and provides implementations
    * for calculating area, drawing the rectangle, and describing it.
    *
*/
package sms_abstract;
public class RectangleAbstract extends ShapeAbstract {
    private double height;
    private double width;
    public RectangleAbstract( String c, String n, double h, double w) {
        super( c , n );
        height = h;
        width = w;
    }
    @Override
    public double area() {
        return height * width;
    }
    @Override
    public void draw() {
      System.out.println( "Drawing a rectangle with a height of " + height + " and a width of " + width);
    }
    @Override
    public void describe() {
        System.out.println( "This is a " + color + " rectangle named " + name + " with an area of " + this.area() );
    }

}