 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lucas
 */

public class ThankYouController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private StackPane MainBox;
    
    @FXML
    private Label label;
    
    @FXML
    private ImageView Millie;
    
    private String[] Text;
    
    private int i = 1;
    private double j = 0.005;
    
    public void setSentence() {
       
        getTextTime().setCycleCount(Animation.INDEFINITE);
        getAppearance().setCycleCount(200);
        
        label.setFont(Font.font("Impact", 18));
        label.setTextFill(Color.ANTIQUEWHITE);
        
        label.setStyle("-fx-alignment: CENTER;");
        label.setMaxWidth(150);
        label.setOpacity(0);
        label.setText(Text[0]);
        
        System.err.println("for");
        getTextTime().play();
        getAppearance().play();
    }
    
    private final Timeline Appearance = new Timeline(new KeyFrame(Duration.millis(30), (event) -> {
        
        System.err.println("appear");
        label.setOpacity(j);
        j += 0.005;
        
    }));
    
    private final Timeline TextTime = new Timeline(new KeyFrame(Duration.millis(4000), (event) -> {
        
        System.err.println("texttime");
        label.setText(Text[i]);
        i++;
        
        if(i == 5) i = 0;
    }));
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Text = new String[5];
        
        Text[0] = "Agradeço a Dan pelas contribuições";
        Text[1] = "a Millie Bobby Brown, por existir,";
        Text[2] = "a mim, por ter (per)feito,";
        Text[3] = "e a você(s), por ter(em) jogado.";
        Text[4] = "Identação inspirada em João Gabriel";
        
        setSentence();
    }    

    public Timeline getAppearance() {
        return Appearance;
    }

    public Timeline getTextTime() {
        return TextTime;
    }
    
}
