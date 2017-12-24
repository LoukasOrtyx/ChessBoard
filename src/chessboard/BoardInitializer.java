/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Lucas
 */
public class BoardInitializer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader File = new FXMLLoader(getClass().getResource("WindowSetup.fxml"));
        
        Parent Root = File.load();
        
        Scene scene = new Scene(Root);
        stage.setScene(scene);
        
        WindowSetupController Scrutineer = File.<WindowSetupController>getController();
        
        scene.getStylesheets().add(getClass().getResource("WindowSetup.css").toExternalForm());
        stage.setTitle("Setup");
        stage.getIcons().add(new Image("Images/Icon.png"));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
    }
    
}
