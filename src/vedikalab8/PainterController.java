/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package vedikalab8;


 
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class PainterController {

    
     // GUI Component References 
    @FXML private Pane drawingAreaPane;
     
     @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML private RadioButton blackRadioButton;
    @FXML private RadioButton redRadioButton;
    @FXML private RadioButton blueRadioButton;
    @FXML private RadioButton greenRadioButton;

    @FXML private RadioButton smallRadioButton;
    @FXML private RadioButton mediumRadioButton;
    @FXML private RadioButton largeRadioButton;

    //  State Variables for coloring
    private PenSize penSize = PenSize.MEDIUM; // default
    private Color brushColor = Color.BLACK; // default

    
        // ===== Initialize method called automatically after FXML loads =====
    @FXML
    private void initialize() {

        // Attach UserData to color RadioButtons
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        blueRadioButton.setUserData(Color.BLUE);
        greenRadioButton.setUserData(Color.GREEN);

        // Attach UserData to size RadioButtons
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }
    
    private enum PenSize {  
        SMALL(2),
        MEDIUM(4),
        LARGE(6);

        private final int radius;

        PenSize(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }
    }
    
    //event handlers 
    
      @FXML
    private void colorRadioButtonSelected() {
        // Get selected RadioButton's color from its user data
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected() {
        // Get selected RadioButton's pen size from its user data
        penSize = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
       // Create a circle where mouse is dragged
        Circle newCircle = new Circle(event.getX(), event.getY(), penSize.getRadius(),brushColor );
        drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    private void undoButtonPressed() {
        int size = drawingAreaPane.getChildren().size();
        if (size > 0) {
            drawingAreaPane.getChildren().remove(size - 1);
        }
    }
        
    @FXML
    private void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
}
