# Project: CSC325 Team 8 - OOP Demonstration

## Levels Completed
- [x] Level 1: Abstract Class
- [x] Level 2: Subclasses
- [x] Level 3: Interface

## Summary of Work Completed

### Level 1: Abstract Class
- Created an abstract class `Animal` with private variables and abstract methods:
  - `makeSound()`
  - `move()`

### Level 2: Subclasses
- Created 3 concrete subclasses:
  - `Bird`
  - `Fish`
  - `Mammal`
- Each subclass:
  - Overrides the abstract methods `makeSound()` and `move()`.
  - Implements unique sound and movement behaviors.
  - Includes a constructor to set the `name` variable.

### Level 3: Interface
- Created an interface (e.g., `Flyable`, `Swimmable`, `Runnable`) with at least one method.
- Implemented the interface in the appropriate subclasses:
  - `Bird` implements `Flyable`.
  - `Fish` implements `Swimmable`.
  - `Mammal` implements `Runnable`.

### OOP Principles Applied
- Used private variables with public getters/setters.
- Correctly used `extends` and `implements` for inheritance and interface implementation.
- Applied `@Override` annotations for overridden methods.

### Main.java
- Created a `Main` class to demonstrate polymorphism:
  - Stored all animals in an `ArrayList<Animal>`.
  - Looped through the list and called their methods dynamically.
  - Output each animal’s name, movement, and sound.

---

## Next Steps
- Add a second interface (e.g., `Climbable`, `Walkable`, or `Burrower`) and implement it in at least two subclasses.
- Update `Main.java` to demonstrate the new methods and behaviors.
- Continue tracking progress in this file.
