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
    private ToggleGroup colorToggleGroup; //group for the color radio buttons

    @FXML
    private ToggleGroup sizeToggleGroup; //grroup for the pen size radio buttons

    //color options 
    @FXML private RadioButton blackRadioButton;
    @FXML private RadioButton redRadioButton;
    @FXML private RadioButton blueRadioButton;
    @FXML private RadioButton greenRadioButton;

    @FXML private RadioButton smallRadioButton;
    @FXML private RadioButton mediumRadioButton;
    @FXML private RadioButton largeRadioButton;

    // Initalize State Variables for coloring
    private PenSize penSize = PenSize.MEDIUM; // default pen size
    private Color brushColor = Color.BLACK; // default brush color
    
    
    //Initialize method called automatically after FXML loads
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
        
         // Select default RadioButtons
        blackRadioButton.setSelected(true);   // default color
        mediumRadioButton.setSelected(true);  // default size

        // Update the brushColor and penSize variables to match the selected buttons
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
        penSize = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
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
        // Udate brushColor when user selcts a different color
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected() {
        // update penSize when the user selects a different size
        penSize = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
       // Create a circle where mouse is dragged
        Circle newCircle = new Circle(
                event.getX(), //the x coordinate of the mouse
                event.getY(), //the y coordinate of the mouse
                penSize.getRadius(), //radius based on the selected pen size
                brushColor //fill color depending on selected color 
        );
        //add the cirle to the pane 
        drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML
    private void undoButtonPressed() {
        //remove the circle that was last drawn from the pane 
        int size = drawingAreaPane.getChildren().size();
        if (size > 0) {
            drawingAreaPane.getChildren().remove(size - 1);
        }
    }
        
    @FXML
    private void clearButtonPressed(ActionEvent event) {
        //remove all the circles from the drawing pane 
        drawingAreaPane.getChildren().clear();
    }
}
