package sms_abstract;
public class TriangleAbstract extends ShapeAbstract{
    private double height;
    private double base;
    public TriangleAbstract( String c, String n, double h, double b) {
        super( c , n );
        height = h;
        base = b;
    }
    @Override
    public double area() {
        return height * base / 2;
    }
    @Override
    public void draw() {
      System.out.println( "Drawing a triangle with a height of " + height + " and a base of " + base);
    }
    @Override
    public void describe() {
        System.out.println( "This is a " + color + " triangle named " + name + " with an area of " + this.area() );
    }

}