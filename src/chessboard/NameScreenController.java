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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lucas
 */
public class NameScreenController implements Initializable {

    public int getRows() {
        return Rows;
    }

    public void setRows(int Rows) {
        this.Rows = Rows;
    }

    public int getColumns() {
        return Columns;
    }
    
    public void setColumns(int Columns) {
        this.Columns = Columns;
    }

    public String[] getPlayers() {
        return Players;
    }

    
    private final songPlayer media = new songPlayer();
    
    @FXML
    TextField jogador1, jogador2;
    
    @FXML
    Button button;
    
    @FXML
    Label Warning;
    
    final int SquareSize = 50;
    
    private int Rows, Columns;
    private String[] Players;
    
    public void ValidateNames() {
        
        Players = new String[2];
        
        media.playSong("/Songs/button.mp3");
        
        if(jogador1.getText().equals(jogador2.getText())) {
            
            Warning.setText("Nomes Iguais");
            return;
        }
        
        Players[0] = jogador1.getText();
        Players[1] = jogador2.getText();
        
        Stage Window = (Stage) button.getScene().getWindow();
        Window.close();
        
        GenerateWindowBoard(getRows(), getColumns(), Players);
    }
    
    
     public void GenerateWindowBoard(int Rows, int Columns, String[] Players) {
        
        FXMLLoader File = new FXMLLoader(getClass().getResource("WindowBoard.fxml"));
        Stage Window = new Stage();
        
        Parent Root = null;
        
        try {
            
            Root = (Parent) File.load();
        } catch (IOException ex) {
            
            Logger.getLogger(WindowSetupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene Content = new Scene(Root, Rows * SquareSize + 240, Columns * SquareSize + 40);
        Content.getStylesheets().add(getClass().getResource("WindowSetup.css").toExternalForm());
        
        Window.setScene(Content);
        
        Window.initModality(Modality.APPLICATION_MODAL);
        
        
        WindowBoardController Scrutineer = File.<WindowBoardController>getController();

        Scrutineer.GenerateBoard(Rows, Columns, SquareSize, Window, Players);
        
        Window.setTitle("Board");
        Window.setResizable(false);
        Window.getIcons().add(new Image("Images/Icon.png"));
        Window.show();
        Window.setOnCloseRequest((event) -> {
            
        event.consume();
        });
    }
    
    

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
