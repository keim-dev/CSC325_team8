import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args ) {
        List<Animal> animals = new ArrayList<>();
        animals.add( new Dog( "Ollie", "Shih Tzu" ) );
        animals.add( new Cat( "Tiger", "Calico" ) );
        animals.add( new Mouse( "Mickey", "Black" ) );
        for ( Animal animal : animals ) {
            animal.makeSound();
            if ( animal instanceof Runnable runnable ) {
                runnable.run();
                runnable.walk();
            }
            if ( animal instanceof Swimmable swimmable ) {
                swimmable.swim();
            }
        }
    }
}