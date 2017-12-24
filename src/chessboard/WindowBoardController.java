/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard;

import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import chessboard.elementary.Board;
import chessboard.elementary.UnitsData;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lucas
 */
public class WindowBoardController implements Initializable {

    /**
     * @return the Info
     */
    public Label getInfo() {
        return Info;
    }

    /**
     * @param Info the Info to set
     */
    public void setInfo(Label Info) {
        this.Info = Info;
    }

    public String[] getPlayers() {
        return Players;
    }

    public void setPlayers(String[] Players) {
        this.Players = Players;
    }

    public Stage getWindow() {
        return Window;
    }
    
    public void setWindow(Stage Window) {
        this.Window = Window;
    }

    public int getSquareSize() {
        return SquareSize;
    }

    public void setSquareSize(int SquareSize) {
        this.SquareSize = SquareSize;
    }

    public int getRows() {
        return Rows;
    }

    public void setRows(int Rows) {
        this.Rows = Rows;
    }

    int getColumns() {
        return Columns;
    }

    public void setColumns(int Columns) {
        this.Columns = Columns;
    }
    
    private Board PlayBoard;
    private int Rows, Columns, SquareSize;
    final int MenuHeight = 30;
    private final songPlayer media = new songPlayer();
    private String[] Players;
    
    @FXML
    private AnchorPane MainPane;
    
    @FXML
    private GridPane Field = new GridPane();
    
    @FXML
    private MenuBar Options;
    
    @FXML
    private TitledPane UnitPane;
    
    @FXML
    private Label Info;
    
    @FXML
    private Label TrumpLabel;
    
    @FXML
    private ImageView Volume;
    
    private Stage Window;
    
    private EventHandler<MouseEvent> event;
    
    public void GenerateBoard(int Rows, int Columns, int SquareSize, Stage Window, String[] Players) {
        
        setRows(Rows);
        setColumns(Columns);
        setSquareSize(SquareSize);
        setPlayers(Players);
        
        setWindow(Window);
        
        Options = setOptions();
        
        MainPane.getChildren().add(Options);
        
        setInferiorTab();
        setUnitsMenu();
        
        PlayBoard = new Board(Rows, Columns, SquareSize, SquareSize, Field, MainPane, getWindow(), Players, getInfo(), TrumpLabel);
        
        Field.setLayoutY(MenuHeight);
        MainPane.getChildren().add(Field);
    }
    
    public void setInferiorTab() {
        
        setInfo(new Label("Teste"));
        getInfo().setPrefSize(Rows * SquareSize + 250, 30);
        getInfo().setLayoutY(Columns * SquareSize + 25);
        
        MainPane.getChildren().add(getInfo());
        
        setVolume(new ImageView("Images/volumeIcon.png"));
        
        MainPane.getChildren().add(getVolume());
    }
    
    public void setUnitsMenu() {
        
        UnitPane = new TitledPane();
        UnitPane.setPrefSize(250, Columns * SquareSize);
        UnitPane.setLayoutX(Rows * SquareSize);
        
        UnitPane.setLayoutY(30);
        UnitPane.setText("Escolha suas peças:");
        MainPane.getChildren().add(UnitPane);
        
    }
    
    public void RestartBoard() {
        
        PlayBoard = new Board(Rows, Columns, SquareSize, SquareSize, Field, MainPane, getWindow(), getPlayers(), getInfo(), TrumpLabel);
    }
    
    public MenuBar setOptions() {
        
       MenuBar Bar = new MenuBar();
       Bar.setPrefSize(Rows * SquareSize + 250, MenuHeight);
       
       Menu Game = new Menu("Jogo");
       
       MenuItem Restart = new MenuItem("Reiniciar");
       MenuItem Exit = new MenuItem("Sair");
       
       Restart.setOnAction((ActionEvent restart) -> {
           RestartBoard();
        });
       
       Exit.setOnAction((ActionEvent exit) -> {
           System.exit(0);
        });
       
       Game.getItems().addAll(Restart, Exit);
       
       Menu AddInfo = new Menu("Informações Adicionais");
       
       MenuItem About = new MenuItem("Agradecimentos");
       
       About.setOnAction((ActionEvent about) -> { 
           try {
               
               AcknowledgementsWindow();
           } catch (IOException ex) {
               
               Logger.getLogger(WindowBoardController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
       
       AddInfo.getItems().add(About);
       
       Bar.getMenus().addAll(Game, AddInfo);
 
       return Bar;
    }
    
    public void AcknowledgementsWindow() throws IOException {
        
        FXMLLoader File = new FXMLLoader(getClass().getResource("ThankYou.fxml"));
        
        Parent Root = File.load();
        
        Stage Window = new Stage();
        
        Scene Content = new Scene(Root, 300, 220);
        
        Window.setScene(Content);
        
        Window.initModality(Modality.APPLICATION_MODAL);
        
        ThankYouController Scrutineer = File.<ThankYouController>getController();
        
        Window.setTitle("Agradecimentos");
        Window.setResizable(false);
        Window.getIcons().add(new Image("Images/Icon.png"));
        Window.show();
        
        Window.setOnCloseRequest((event) -> {
           
            Scrutineer.getAppearance().stop();
            Scrutineer.getTextTime().stop();
            Window.close();
        });
    }
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        media.playSong("/Songs/Uwa.mp3", MediaPlayer.INDEFINITE);
    }    

    public ImageView getVolume() {
        return Volume;
    }

    public void setVolume(ImageView Volume) {
        
        this.Volume = Volume;
        
        this.Volume.setFitHeight(20);
        this.Volume.setFitWidth(20);
        
        this.Volume.setLayoutX(Rows * SquareSize + 220);  
        this.Volume.setLayoutY(Columns * SquareSize + 30);
        
        this.Volume.setCursor(Cursor.HAND);
        
        this.Volume.setOnMouseClicked(this.event = (MouseEvent event)-> {
           
            String url = "Images/mutedIcon.png";
           if(media.SongIsMuted()) {
               
                media.unmuteSong();
                url = "Images/volumeIcon.png";
           } else {
               
               media.muteSong();
           } 
           
            MainPane.getChildren().remove(getVolume());
            
            setVolume(new ImageView(url));
            
            MainPane.getChildren().add(getVolume());
        });
    }
}
