/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vedikalab8;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * //https://github.com/Vedika273/lab8Vedika
 * @author Vedika
 */
public class VedikaLab8 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
            stage.setTitle("FXML Welcome");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(VedikaLab8.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
