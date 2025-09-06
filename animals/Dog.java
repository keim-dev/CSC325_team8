package animals;
import interfaces.*;

public class Dog extends Animal implements AnimalRunnable, Swimmable {
    private String name;
    private String breed;
    public Dog( String name, String breed ) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println( name + ": " + "Bark! Bark!" );
    }

    @Override
    public void run() {
        System.out.println( name + " the " + breed + " is running." );
    }

    @Override
    public void walk() {
        System.out.println( name + " the " + breed + " is walking." );
    }

    @Override
    public void swim() {
        System.out.println( name + " the " + breed + " is swimming." );
    }
}