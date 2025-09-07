package sms_interface;
public class Triangle_i implements Calculable, Drawable, Describable {
    private String color;
    private String name;
    private double base;
    private double height;

    public Triangle_i(String c, String n, double b, double h) {
        color = c;
        name = n;
        base = b;
        height = h;
    }
    @Override
    public double area() {
        return 0.5 * base * height;
    }
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " triangle named " + name);
    }
    @Override
    public void describe() {
        System.out.println("This is a triangle named " + name + " with base " + base + " and height " + height);
    }
    
}
