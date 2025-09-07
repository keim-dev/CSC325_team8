package sms_interface;
import java.lang.Math;
public class Circle_i implements Calculable, Drawable, Describable {
    private String color;
    private String name;
    private double radius;

    public Circle_i(String c, String n, double r) {
        color = c;
        name = n;
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