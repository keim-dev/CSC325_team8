package shapes.abstractdesign;

/**
 * Main class to demonstrate polymorphism with the abstract Shape design.
 */
public class Main {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = {
            new Circle("Red", 5.0),
            new Rectangle("Blue", 4.0, 6.0),
            new Triangle("Green", 3.0, 4.0)
        };

        // Loop through the array and call polymorphic methods
        for (Shape shape : shapes) {
            shape.describe(); // Polymorphic call to describe()
            System.out.println("Area: " + shape.getArea()); // Polymorphic call to getArea()
            shape.draw(); // Polymorphic call to draw()
            System.out.println();
        }
    }
}