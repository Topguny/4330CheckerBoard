/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lukas
 */
public class Board extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        
        FXMLDocumentController controller = loader.getController();
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
        controller.ready(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
