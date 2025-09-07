package sms_abstract;
import java.lang.Math;
public class CircleAbstract extends ShapeAbstract {
    private double radius;
    public CircleAbstract( String c, String n, double r) {
        super( c , n );
        radius = r;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public void draw() {
      System.out.println( "Drawing a circle with a radius of " + radius);
    }
    @Override
    public void describe() {
        System.out.println( "This is a " + color + " circle named " + name + " with a radius of " + radius );
    }

}