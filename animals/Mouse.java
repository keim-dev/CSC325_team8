public class Mouse extends Animal implements Runnable, Swimmable {
    private String name;
    private String color;
    public Mouse( String name, String color ) {
        this.name = name;
        this.color = color;
    }


    @Override 
    public void makeSound() {
        System.out.println( name + ": " + "Squeak! Squeak!" );
    }
    @Override
    public void run() {
        System.out.println( name + " ,the " + color + " mouse, is running." );
    }
    @Override
    public void walk() {
        System.out.println( name + " ,the " + color + " mouse, is walking." );
    }
    @Override
    public void swim() {
        System.out.println( name + " ,the " + color + " mouse, is swimming." );
    }


    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor( String color ) {
        this.color = color;
    }

}