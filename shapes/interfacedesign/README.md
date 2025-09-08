# Shape Management System

This project demonstrates two approaches to designing a shape management system in Java:
1. Using **abstract classes**.
2. Using **interfaces**.

## Abstract Class Design
The abstract class design uses a base class `Shape` with shared fields (`color`, `name`) and abstract methods (`getArea()`, `draw()`, `describe()`). Subclasses (`Circle`, `Rectangle`, `Triangle`) inherit from `Shape` and provide their own implementations.

### How to Compile and Run
1. Navigate to the `shapes/abstractdesign` directory.
2. Compile the code:
   ```bash
   javac shapes/abstractdesign/*.java