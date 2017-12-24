/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Lucas
 */
public class WindowSetupController implements Initializable {
    
    
    @FXML
    Label Warning;
    
    @FXML
    TextField txtRows, txtColumns;
    
    @FXML
    AnchorPane MainPane;
    
    private final songPlayer media = new songPlayer();
    
    @FXML
    private void GenerateBoard(ActionEvent event) throws IOException {

        int Rows = 0, Columns = 0;
        String[] Players = null;
        
        media.playSong("/Songs/button.mp3");

        try {

            Rows = Integer.parseInt(txtRows.getText());
            Columns = Integer.parseInt(txtColumns.getText());
            
            if(Rows <= 0 || Columns <= 0) throw new IOException();   
        } catch(NumberFormatException | IOException ex) {
            
            Warning.setText("Formato Inválido");
            
            
            Warning.setLayoutX(MainPane.getWidth()/3);
            Warning.setLayoutY(61);
            return;
        }
        
        setPlayersName(Rows, Columns);
    }
    
    public void setPlayersName(int Rows, int Columns) {
        
        FXMLLoader File = new FXMLLoader(getClass().getResource("NameScreen.fxml"));
        Stage Window = new Stage();
        Parent Root = null;
        
        try {
            
            Root = (Parent) File.load();
        } catch (IOException ex) {
            
            Logger.getLogger(WindowSetupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene Content = new Scene(Root);
        Content.getStylesheets().add(BoardInitializer.class.getResource("WindowSetup.css").toExternalForm());
        
        Window.setScene(Content);
        
        NameScreenController Scrutineer = File.<NameScreenController>getController();
        Scrutineer.setColumns(Columns);
        Scrutineer.setRows(Rows);
        
        Window.setTitle("Nomes");
        Window.setResizable(false);
        Window.getIcons().add(new Image("Images/Icon.png"));
        Window.setOnCloseRequest((WindowEvent event) -> {
            event.consume();
        });
        
        Window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }    
    
}
