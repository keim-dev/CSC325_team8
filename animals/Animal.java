package animals;

import interfaces.Climbable;
import interfaces.Flyable;
import interfaces.Runnable;
import interfaces.Swimmable;

/**
 * Abstract class representing an animal.
 */
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    public abstract void move();
}

/**
 * Bird class that extends Animal and implements Flyable and Climbable.
 */
public class Bird extends Animal implements Flyable, Climbable {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Chirp Chirp!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is flying.");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is soaring through the sky.");
    }

    @Override
    public void climb() {
        System.out.println(getName() + " is climbing a tree.");
    }
}

/**
 * Fish class that extends Animal and implements Swimmable.
 */
public class Fish extends Animal implements Swimmable {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Blub Blub!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is swimming.");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is gliding through the water.");
    }
}

/**
 * Mammal class that extends Animal and implements Runnable and Climbable.
 */
public class Mammal extends Animal implements Runnable, Climbable {
    public Mammal(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Roar!");
    }

    @Override
    public void move() {
        System.out.println(getName() + " is running.");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is sprinting across the field.");
    }

    @Override
    public void climb() {
        System.out.println(getName() + " is climbing a mountain.");
    }
}

/**
 * Interface for animals that can climb.
 */
public interface Climbable {
    void climb();
}

/**
 * Interface for animals that can fly.
 */
public interface Flyable {
    void fly();
}

/**
 * Interface for animals that can swim.
 */
public interface Swimmable {
    void swim();
}

/**
 * Interface for animals that can run.
 */
public interface Runnable {
    void run();
}
package main;

import animals.*;
import interfaces.Climbable;
import interfaces.Flyable;
import interfaces.Swimmable;
import interfaces.Runnable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a collection of animals and provides a menu for user interaction.
 */
public class ZooManager {
    private ArrayList<Animal> animals;

    public ZooManager() {
        animals = new ArrayList<>();
    }

    /**
     * Loads animals into the collection.
     */
    public void loadAnimals() {
        animals.add(new Bird("Parrot"));
        animals.add(new Fish("Goldfish"));
        animals.add(new Mammal("Lion"));
    }

    /**
     * Displays the menu and handles user interaction.
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Zoo Manager Menu:");
            System.out.println("1. List All Animals");
            System.out.println("2. Make All Animals Move");
            System.out.println("3. Make All Animals Make Sound");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        listAllAnimals();
                        break;
                    case 2:
                        makeAllMove();
                        break;
                    case 3:
                        makeAllSound();
                        break;
                    case 4:
                        System.out.println("Exiting Zoo Manager. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void listAllAnimals() {
        System.out.println("Listing all animals:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName());
        }
    }

    private void makeAllMove() {
        System.out.println("Making all animals move:");
        for (Animal animal : animals) {
            animal.move();
        }
    }

    private void makeAllSound() {
        System.out.println("Making all animals make sound:");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}