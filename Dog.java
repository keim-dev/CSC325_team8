public class Dog extends Animal implements Runnable, Swimmable {
    private String name;
    private String breed;
    public Dog( String name, String breed ) {
        this.name = name;
        this.breed = breed;
    }
    
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed( String breed ) {
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