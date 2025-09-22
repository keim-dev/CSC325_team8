import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Main application class for the Drawing App.
 * Creates the JavaFX Stage, Scene, and UI layout with controls.
 */
public class DrawingApp extends Application {
    private DrawingController controller;
    private Canvas canvas;
    private Label statusLabel;
    private Label shapeCountLabel;
    private Label totalAreaLabel;
    private Label selectedShapeLabel;
    private ToggleGroup shapeToggleGroup;
    private ComboBox<Color> colorComboBox;
    private Slider sizeSlider;
    private ListView<DrawableShape> shapeListView;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Drawing App");
        
        // Create the main layout
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        
        // Create and setup canvas
        setupCanvas();
        
        // Create controller
        controller = new DrawingController(canvas);
        
        // Create and setup controls
        VBox controlPanel = createControlPanel();
        
        // Create shape information panel
        VBox infoPanel = createInfoPanel();
        
        // Create status bar
        HBox statusBar = createStatusBar();
        
        // Layout components
        root.setCenter(canvas);
        root.setLeft(controlPanel);
        root.setRight(infoPanel);
        root.setBottom(statusBar);
        
        // Setup event handling
        setupEventHandling();
        
        // Create and show scene
        Scene scene = new Scene(root, 1200, 700);
        
        // Setup keyboard shortcuts
        setupKeyboardShortcuts(scene);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(600);
        primaryStage.show();
        
        updateStatus();
    }
    
    /**
     * Sets up the drawing canvas
     */
    private void setupCanvas() {
        canvas = new Canvas(600, 500);
        canvas.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
    }
    
    /**
     * Creates the control panel with shape selection and options
     * @return VBox containing all controls
     */
    private VBox createControlPanel() {
        VBox controlPanel = new VBox(15);
        controlPanel.setPadding(new Insets(10));
        controlPanel.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 1px;");
        controlPanel.setPrefWidth(200);
        
        // Title
        Label titleLabel = new Label("Drawing Controls");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        // Shape selection
        Label shapeLabel = new Label("Shape Type:");
        shapeLabel.setStyle("-fx-font-weight: bold;");
        
        shapeToggleGroup = new ToggleGroup();
        
        RadioButton rectangleButton = new RadioButton("Rectangle");
        rectangleButton.setToggleGroup(shapeToggleGroup);
        rectangleButton.setSelected(true);
        rectangleButton.setUserData(DrawingController.ShapeType.RECTANGLE);
        
        RadioButton circleButton = new RadioButton("Circle");
        circleButton.setToggleGroup(shapeToggleGroup);
        circleButton.setUserData(DrawingController.ShapeType.CIRCLE);
        
        VBox shapeBox = new VBox(5);
        shapeBox.getChildren().addAll(rectangleButton, circleButton);
        
        // Color selection
        Label colorLabel = new Label("Color:");
        colorLabel.setStyle("-fx-font-weight: bold;");
        
        colorComboBox = new ComboBox<>();
        colorComboBox.getItems().addAll(
            Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, 
            Color.PURPLE, Color.YELLOW, Color.PINK, Color.CYAN
        );
        colorComboBox.setValue(Color.BLUE);
        colorComboBox.setCellFactory(lv -> new ColorListCell());
        colorComboBox.setButtonCell(new ColorListCell());
        
        // Size selection
        Label sizeLabel = new Label("Size:");
        sizeLabel.setStyle("-fx-font-weight: bold;");
        
        sizeSlider = new Slider(20, 100, 50);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setMajorTickUnit(20);
        
        Label sizeValueLabel = new Label("50");
        sizeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            sizeValueLabel.setText(String.valueOf(newVal.intValue()));
            controller.setCurrentSize(newVal.doubleValue());
        });
        
        HBox sizeBox = new HBox(10);
        sizeBox.getChildren().addAll(sizeSlider, sizeValueLabel);
        sizeBox.setAlignment(Pos.CENTER_LEFT);
        
        // Clear button
        Button clearButton = new Button("Clear Canvas");
        clearButton.setStyle("-fx-background-color: #ff6b6b; -fx-text-fill: white; -fx-font-weight: bold;");
        clearButton.setPrefWidth(150);
        
        // Add all components to control panel
        controlPanel.getChildren().addAll(
            titleLabel,
            new Separator(),
            shapeLabel,
            shapeBox,
            new Separator(),
            colorLabel,
            colorComboBox,
            new Separator(),
            sizeLabel,
            sizeBox,
            new Separator(),
            clearButton
        );
        
        return controlPanel;
    }
    
    /**
     * Creates the information panel with real-time shape statistics and list
     * @return VBox containing shape information and list
     */
    private VBox createInfoPanel() {
        VBox infoPanel = new VBox(10);
        infoPanel.setPadding(new Insets(10));
        infoPanel.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #cccccc; -fx-border-width: 1px;");
        infoPanel.setPrefWidth(250);
        
        // Title
        Label titleLabel = new Label("Shape Information");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        
        // Real-time statistics
        Label statsTitle = new Label("Statistics:");
        statsTitle.setStyle("-fx-font-weight: bold;");
        
        shapeCountLabel = new Label("Shapes: 0");
        totalAreaLabel = new Label("Total Area: 0.0");
        
        // Selected shape info
        Label selectionTitle = new Label("Selection:");
        selectionTitle.setStyle("-fx-font-weight: bold;");
        
        selectedShapeLabel = new Label("No shape selected");
        selectedShapeLabel.setWrapText(true);
        selectedShapeLabel.setStyle("-fx-text-fill: #666666;");
        
        // Shape list
        Label listTitle = new Label("All Shapes:");
        listTitle.setStyle("-fx-font-weight: bold;");
        
        shapeListView = new ListView<>();
        shapeListView.setPrefHeight(200);
        shapeListView.setStyle("-fx-font-size: 12px;");
        
        // Add tooltip to list view
        Tooltip listTooltip = new Tooltip("Click on a shape to select it");
        Tooltip.install(shapeListView, listTooltip);
        
        infoPanel.getChildren().addAll(
            titleLabel,
            new Separator(),
            statsTitle,
            shapeCountLabel,
            totalAreaLabel,
            new Separator(),
            selectionTitle,
            selectedShapeLabel,
            new Separator(),
            listTitle,
            shapeListView
        );
        
        return infoPanel;
    }
    
    /**
     * Creates the status bar
     * @return HBox containing status information
     */
    private HBox createStatusBar() {
        HBox statusBar = new HBox();
        statusBar.setPadding(new Insets(5));
        statusBar.setStyle("-fx-background-color: #e0e0e0; -fx-border-color: #cccccc; -fx-border-width: 1px 0 0 0;");
        
        statusLabel = new Label("Ready to draw - Click on canvas to add shapes");
        statusBar.getChildren().add(statusLabel);
        
        return statusBar;
    }
    
    /**
     * Sets up all event handling for the application
     */
    private void setupEventHandling() {
        // Set up real-time bindings
        setupBindings();
        
        // Canvas mouse click event
        canvas.setOnMouseClicked(event -> {
            controller.addShape(event.getX(), event.getY());
            updateStatus();
        });
        
        // Shape type selection
        shapeToggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                DrawingController.ShapeType shapeType = (DrawingController.ShapeType) newToggle.getUserData();
                controller.setCurrentShapeType(shapeType);
                updateStatus();
            }
        });
        
        // Color selection
        colorComboBox.setOnAction(event -> {
            Color selectedColor = colorComboBox.getValue();
            if (selectedColor != null) {
                controller.setCurrentColor(selectedColor);
                updateStatus();
            }
        });
        
        // Shape list selection
        shapeListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                controller.selectShape(newSelection);
            }
        });
        
        // Clear button
        Button clearButton = (Button) ((VBox) ((BorderPane) canvas.getParent()).getLeft()).getChildren().get(8);
        clearButton.setOnAction(event -> {
            controller.clearCanvas();
            shapeListView.getSelectionModel().clearSelection();
            updateStatus();
        });
        
        // Add tooltips to controls
        setupTooltips();
    }
    
    /**
     * Sets up JavaFX property bindings for real-time updates
     */
    private void setupBindings() {
        // Bind shape count label to controller's shape count property
        shapeCountLabel.textProperty().bind(
            controller.shapeCountProperty().asString("Shapes: %d")
        );
        
        // Bind total area label to controller's total area property
        totalAreaLabel.textProperty().bind(
            controller.totalAreaProperty().asString("Total Area: %.1f")
        );
        
        // Bind selected shape label to controller's selected shape info
        selectedShapeLabel.textProperty().bind(
            controller.selectedShapeInfoProperty()
        );
        
        // Bind shape list view to controller's shapes list
        shapeListView.setItems(controller.getShapes());
    }
    
    /**
     * Sets up tooltips for better user experience
     */
    private void setupTooltips() {
        // Canvas tooltip
        Tooltip canvasTooltip = new Tooltip("Click anywhere to draw the selected shape");
        Tooltip.install(canvas, canvasTooltip);
        
        // Color combo box tooltip
        Tooltip colorTooltip = new Tooltip("Select the color for new shapes");
        colorComboBox.setTooltip(colorTooltip);
        
        // Size slider tooltip
        Tooltip sizeTooltip = new Tooltip("Adjust the size of new shapes");
        sizeSlider.setTooltip(sizeTooltip);
        
        // Radio button tooltips
        ((RadioButton) shapeToggleGroup.getToggles().get(0))
            .setTooltip(new Tooltip("Draw square rectangles"));
        ((RadioButton) shapeToggleGroup.getToggles().get(1))
            .setTooltip(new Tooltip("Draw circles"));
    }
    
    /**
     * Updates the status label with current settings and shape count
     */
    private void updateStatus() {
        String shapeType = controller.getCurrentShapeType().toString().toLowerCase();
        String colorName = getColorName(controller.getCurrentColor());
        int shapeCount = controller.getShapeCount();
        
        statusLabel.setText(String.format(
            "Drawing %s shapes in %s (Size: %.0f) - Total shapes: %d | Shortcuts: C=Clear, R=Rectangle, O=Circle",
            shapeType, colorName, controller.getCurrentSize(), shapeCount
        ));
    }
    
    /**
     * Gets a readable name for a color
     * @param color The color to get name for
     * @return String representation of the color
     */
    private String getColorName(Color color) {
        if (color.equals(Color.BLUE)) return "Blue";
        if (color.equals(Color.RED)) return "Red";
        if (color.equals(Color.GREEN)) return "Green";
        if (color.equals(Color.ORANGE)) return "Orange";
        if (color.equals(Color.PURPLE)) return "Purple";
        if (color.equals(Color.YELLOW)) return "Yellow";
        if (color.equals(Color.PINK)) return "Pink";
        if (color.equals(Color.CYAN)) return "Cyan";
        return "Unknown";
    }
    
    /**
     * Custom ListCell for displaying colors in the ComboBox
     */
    private class ColorListCell extends ListCell<Color> {
        @Override
        protected void updateItem(Color color, boolean empty) {
            super.updateItem(color, empty);
            
            if (empty || color == null) {
                setText(null);
                setGraphic(null);
            } else {
                setText(getColorName(color));
                
                // Create a small rectangle showing the color
                Region colorRect = new Region();
                colorRect.setStyle(String.format("-fx-background-color: %s; -fx-border-color: black;", 
                    color.toString().replace("0x", "#")));
                colorRect.setPrefSize(15, 15);
                setGraphic(colorRect);
            }
        }
    }
    
    /**
     * Sets up keyboard shortcuts for the application
     * @param scene The scene to attach keyboard events to
     */
    private void setupKeyboardShortcuts(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case C:
                    // Clear canvas
                    controller.clearCanvas();
                    shapeListView.getSelectionModel().clearSelection();
                    updateStatus();
                    break;
                case R:
                    // Switch to Rectangle
                    ((RadioButton) shapeToggleGroup.getToggles().get(0)).setSelected(true);
                    controller.setCurrentShapeType(DrawingController.ShapeType.RECTANGLE);
                    updateStatus();
                    break;
                case O:
                    // Switch to Circle (O for oval/circle)
                    ((RadioButton) shapeToggleGroup.getToggles().get(1)).setSelected(true);
                    controller.setCurrentShapeType(DrawingController.ShapeType.CIRCLE);
                    updateStatus();
                    break;
                default:
                    break;
            }
        });
        
        // Make sure the scene can receive key events
        scene.getRoot().setFocusTraversable(true);
        scene.getRoot().requestFocus();
    }
    
    /**
     * Main method to launch the application
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}