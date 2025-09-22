# JavaFX Drawing App

A simple drawing app where you can click to draw shapes on a canvas.

## Completion Level: Level 3 ✅

This project implements all requirements through Level 3

## Features Overview

### Core Features
- Click on canvas to draw rectangles or circles
- Choose shape type with radio buttons
- Pick colors from dropdown menu (8 colors available)
- Change size with slider (20-100 pixels)
- Clear all shapes with button
- See how many shapes you've drawn
- View total area of all shapes
- List of all shapes on the right side

### Enhanced Features (Level 3)
- **Keyboard Shortcuts**: 
  - `C` = Clear canvas
  - `R` = Switch to Rectangle mode
  - `O` = Switch to Circle mode
- **Real-time Statistics**: Live count and total area calculation
- **Interactive Shape List**: Click shapes to see details
- **JavaDoc Documentation**: Complete API documentation for all classes
- **Custom Shape Architecture**: Proper inheritance with DrawableShape interface

## Project Architecture

### Files Structure
- **DrawableShape.java** - Abstract base class for all shapes (Strategy pattern)
- **DrawableRectangle.java** - Rectangle shape implementation
- **DrawableCircle.java** - Circle shape implementation  
- **DrawingController.java** - Manages shapes and canvas (MVC Controller)
- **DrawingApp.java** - Main app with UI layout (MVC View)

### Design Patterns Implemented
- **Strategy Pattern**: Each shape (Rectangle/Circle) implements DrawableShape interface
- **MVC Pattern**: Clear separation of Model (shapes), View (UI), Controller (logic)
- **Observer Pattern**: JavaFX bindings automatically update UI when data changes
- **Template Method**: DrawableShape defines common structure, subclasses implement specifics

## How to Compile and Run



###  (Windows)
1. Download JavaFX SDK from https://openjfx.io/
2. Extract to a folder (e.g., `C:\javafx-sdk-21`)
3. Edit `run.bat` and update the JAVAFX_PATH to your JavaFX location
4. Double-click `run.bat` to compile and run

### Manual Compilation
```bash
# Windows
javac --module-path "C:\path\to\javafx\lib" --add-modules javafx.controls *.java
java --module-path "C:\path\to\javafx\lib" --add-modules javafx.controls DrawingApp

# Linux/Mac  
javac --module-path /path/to/javafx/lib --add-modules javafx.controls *.java
java --module-path /path/to/javafx/lib --add-modules javafx.controls DrawingApp
```

### Using IDE
- **IntelliJ IDEA**: Add JavaFX to module path, configure VM options
- **Eclipse**: Install e(fx)clipse plugin
- **VS Code**: Install Extension Pack for Java + JavaFX support

## How to use

### Basic Drawing
1. Run the app
2. Pick rectangle or circle using radio buttons
3. Choose a color from the dropdown
4. Set the size with the slider
5. Click on canvas to draw shapes
6. See your shapes listed on the right panel
7. Click "Clear Canvas" to start over

### Keyboard Shortcuts
- **C** - Clear the canvas
- **R** - Switch to Rectangle mode  
- **O** - Switch to Circle mode

### Real-time Features
- Shape count updates automatically
- Total area calculation shown live
- Click shapes in the list to see details
- Status bar shows current settings and shortcuts

## Implementation Notes

### Level 3 Enhancements Completed

1. **Keyboard Input**: 
   - C key clears canvas
   - R key switches to Rectangle mode
   - O key switches to Circle mode
   - Keys work from anywhere in the application

2. **Custom Shape Subclasses**:
   - DrawableRectangle and DrawableCircle extend DrawableShape
   - Proper implementation of shared interface
   - Each shape handles its own drawing and area calculation

3. **JavaDoc Documentation**:
   - Complete JavaDoc comments for all public classes and methods
   - Follows standard JavaDoc conventions
   - Includes @param, @return, @throws, @since tags
   - Documents design patterns and architecture decisions

4. **Enhanced README**:
   - Feature overview with completion level
   - Detailed compilation and run instructions
   - Architecture explanation with design patterns
   - Usage guide including keyboard shortcuts

### Code Quality Features
- **Error Handling**: Proper null checks and validation
- **Design Patterns**: Strategy, MVC, Observer, Template Method
- **Real-time Updates**: JavaFX property bindings
- **Extensible Architecture**: Easy to add new shape types
- **Professional Documentation**: Complete JavaDoc coverage

## Why it's built this way

**GUI Layout:**
- Controls on the left (buttons, color picker, size slider)
- Drawing area in the middle (canvas)
- Shape information on the right (list and stats)
- Status bar at the bottom
- This layout makes sense because you pick settings, then draw, then see results

**Simple design patterns:**
- **MVC Pattern**: Controller (manages data) + View (buttons/canvas) + Model (shapes)
- **Strategy Pattern**: Each shape knows how to draw itself differently 
- **Observer Pattern**: When shapes change, the display updates automatically
- Each shape knows how to draw itself
- The controller manages all the shapes
- The main app handles the buttons and layout
- Everything updates automatically when you add shapes

**Good programming practices:**
- Code is organized into separate classes
- Easy to add new shape types (just make a new class like DrawableTriangle)
- UI updates happen automatically (no manual refresh needed)
- Clean separation between drawing logic and display



