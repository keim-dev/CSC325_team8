package sms_interface;
public class Rectangle_i implements Calculable, Drawable, Describable {
    private String color;
    private String name;
    private double width;
    private double height;

    public Rectangle_i(String c, String n, double w, double h) {
        color = c;
        name = n;
        width = w;
        height = h;
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
