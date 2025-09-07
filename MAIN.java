import java.util.Scanner;
import sms_abstract.*;
import sms_interface.*;

/**
 * MAIN class to test shape classes implemented using both abstraction and interfaces.
 * Provides a menu for the user to select which design to test.
 */
public class MAIN {

    /**
     * Tests the abstract class implementations of shapes.
     * Creates RectangleAbstract, CircleAbstract, and TriangleAbstract objects,
     * calls their draw, describe, and area methods, and prints the results.
     */
    public void testAbstracts() {

        System.out.println( "Testing Abstract Classes:" );
        RectangleAbstract rect = new RectangleAbstract ( "Red" , "Richard" , 10 , 2.5 );
        rect.draw();
        rect.describe();
        System.out.println( "Area: " + rect.area() );

        CircleAbstract circ = new CircleAbstract ( "Blue" , "Berretta" , 5 );
        circ.draw();
        circ.describe();
        System.out.println( "Area: " + circ.area() );

        TriangleAbstract tri = new TriangleAbstract ( "Teal" , "Tristan" , 4 , 3 );
        tri.draw();
        tri.describe();
        System.out.println( "Area: " + tri.area() );
    }

    /**
     * Tests the interface-based implementations of shapes.
     * Creates Rectangle_i, Circle_i, and Triangle_i objects,
     * calls their draw, describe, and area methods, and prints the results.
     */
    public void testInterfaces() {

        System.out.println( "Testing Interface Classes:" );
        Rectangle_i rect2 = new Rectangle_i ( "Green" , "Randy" , 10 , 2.5 );
        rect2.draw();
        rect2.describe();
        System.out.println( "Area: " + rect2.area() );

        Circle_i circ2 = new Circle_i ( "Brown" , "Beatrice" , 5 );
        circ2.draw();
        circ2.describe();
        System.out.println( "Area: " + circ2.area() );

        Triangle_i tri2 = new Triangle_i ( "Turqoise" , "Tina" , 4 , 3 );
        tri2.draw();
        tri2.describe();
        System.out.println( "Area: " + tri2.area() );
    }

    /**
     * Main method. Prompts the user to select which design to test (abstraction, interface, or both).
     * Calls the appropriate test methods based on user input.
     * @param args Command-line arguments (not used)
     */
    public static void main( String[] args ) {
        MAIN run = new MAIN();
        Scanner scnr = new Scanner( System.in );
        String choice;

        System.out.println( "Which design would you like to test? (A)bstraction or (I)nterface or (B)oth?" );
        try ( scnr ) {
            choice = scnr.nextLine();
            if ( choice.equalsIgnoreCase( "A" ) ) {
                run.testAbstracts();
            }
            else if ( choice.equalsIgnoreCase( "I" ) ) {
                run.testInterfaces();
            }
            else if ( choice.equalsIgnoreCase(choice) ) {
                run.testAbstracts();
                System.out.println( " ********** ");
                run.testInterfaces();
            }
            else {
                System.out.println( "Invalid choice. Please enter 'A' for Abstraction or 'I' for Interface." );
            }
        }
        System.out.println( "End Test." );
        System.out.println( "End of program." );
    }
}