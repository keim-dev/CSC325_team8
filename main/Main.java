package main;

/**
 * Main class to demonstrate the ZooManager functionality.
 */
public class Main {
    public static void main(String[] args) {
        ZooManager zooManager = new ZooManager();
        zooManager.loadAnimals();
        zooManager.displayMenu();
    }
}