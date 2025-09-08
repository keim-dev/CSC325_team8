package shapes.interfacedesign;

/**
 * Main class to demonstrate polymorphism with the interface design.
 */
public class Main {
    public static void main(String[] args) {
        // Create an array of Drawable objects
        Drawable[] shapes = {
            new Circle("Red", 5.0),
            new Rectangle("Blue", 4.0, 6.0),
            new Triangle("Green", 3.0, 4.0)
        };

        // Loop through the array and call polymorphic methods
        for (Drawable shape : shapes) {
            if (shape instanceof Describable) {
                ((Describable) shape).describe(); // Polymorphic call to describe()
            }
            if (shape instanceof Calculable) {
                System.out.println("Area: " + ((Calculable) shape).getArea()); // Polymorphic call to getArea()
            }
            shape.draw(); // Polymorphic call to draw()
            System.out.println();
        }
    }
}