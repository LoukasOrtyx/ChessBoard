package chessboard.elementary;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Window;
import javafx.util.Duration;

public class Board {

    public House[][] getSquares() {
        return Square;
    }

    public void setSquares(int rows, int columns) {
        this.Square = new House[rows][columns];
    }

    public AnchorPane getBackground() {
        return Background;
    }

    public void setBackground(AnchorPane Background) {
        this.Background = Background;
    }

    public double getSquareHeight() {
        return SquareHeight;
    }

    public void setSquareHeight(double SquareHeight) {
        this.SquareHeight = SquareHeight;
    }

    public Label getInfo() {
        return Info;
    }

    public void setInfo(Label Info) {
        this.Info = Info;
    }

    public Label getMarker() {
        return Marker;
    }

    public void setMarker(Label Marker) {
        this.Marker = Marker;
    }

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

    public GridPane getField() {
        return Field;
    }

    public void setField(GridPane Field) {
        this.Field = Field;
    }

    public Player[] getUser() {
        return User;
    }

    public void setUser(String[] User) {
        
        this.User = new Player[2];
        
        this.User[0] = new Player();
        this.User[1] = new Player();
        
        this.User[0].setName(User[0]);
        this.User[1].setName(User[1]);
    }

    public Window getStage() {
        return Stage;
    }

    public void setStage(Window Stage) {
        this.Stage = Stage;
    }
    
    public void setRowConstraint() {
        
        RowConstraints rc = new RowConstraints(getSquareHeight());
        getField().getRowConstraints().add(rc);
    }

    public void setColumnsConstraint() {
        
        ColumnConstraints rc = new ColumnConstraints(getSquareHeight());
        getField().getColumnConstraints().add(rc);
    }
    
    public void setShadow() {
        this.Shadow = new InnerShadow();
        
        this.Shadow.setOffsetX(1.0f);
        this.Shadow.setOffsetY(1.0f);
    }
    
    public InnerShadow getShadow() {
        return this.Shadow;
    }
    
    public boolean HouseIsMovable(Coordinate Point) {
        
        int x = Point.getX();
        int y = Point.getY();
        
        return this.Square[x][y].getUnit() == null && x < getRows() && x > -1 && y < getColumns() && y > -1;
    }
    
    public List<List<Coordinate>> ValidatePaths(List<List<Coordinate>> AllPaths) {
        
        List<List<Coordinate>> ValidPaths = new ArrayList<>();
        
        for (int i = 0; i < AllPaths.size(); i++) {
            
            for (int j = 0; j < AllPaths.get(i).size(); j++) {
                
                Coordinate Point = AllPaths.get(i).get(j);
                
                if(HouseIsMovable(Point)) {
                    
                }
            }
        }
        
    }
    
    public void ShowMotions(Piece Unit) {
        
        List<List<Coordinate>> AllCaptures = Unit.PlotCaptures();
        List<List<Coordinate>> AllPaths = Unit.PlotPaths();
    }
    
    public void OnClicked(Piece Unit) {
        
        Size = getSquareHeight() + 5;
        
        Glow = 0.2;
        
        Unit.setEffect(new Glow(Glow));
        
        Unit.setFitHeight(Size);
        Unit.setFitWidth(Size);
        
        Time = new Timeline(new KeyFrame(Duration.seconds(1), (event) -> {
            
            if (Size == getSquareHeight()) Size = getSquareHeight() + 5;
            else Size = getSquareHeight();
            
            Glow = 0.2 - Glow;
            
            Unit.setEffect(new Glow(Glow));
            
            Unit.setFitHeight(Size);
            Unit.setFitWidth(Size);
        }));
        
        Time.setCycleCount(Animation.INDEFINITE);
        Time.play();
    }
    
    public void setMouseActions() {
        
        PiecePressed = (event) -> {
            
            Piece Unit = (Piece) event.getSource();
            
            OnClicked(Unit);
        };
        
        PieceDragged = (event) -> {
            
        };
    }
    
    private EventHandler PiecePressed;
    private EventHandler PieceDragged;
    private EventHandler PieceDropped;
    private EventHandler PieceEntered;
    private EventHandler PieceExited;
    
    private Timeline Time, Blink, Transport;
    
    private InnerShadow Shadow;
    private AnchorPane Background;
    private double SquareHeight;
    private Label Info, Marker;
    private House[][] Square;
    private int Rows, Columns;
    private GridPane Field; 
    private Player[] User;
    private Window Stage;
    private int Turn = 0;
    private double Size;
    private double Glow;
    
    
    public Board(int rows, int columns, double height, double width, GridPane field, AnchorPane mainPane, Window window, String[] players, Label info, Label marker) {
        
        setRows(rows);
        setColumns(columns);
        setSquareHeight(height);
        setSquares(getRows(), getColumns());
        
        setBackground(mainPane);
        setStage(window);
        setField(field);
        
        setInfo(info);
        setMarker(marker);
        
        setUser(players);
        setMouseActions();
        
        setShadow();
        
        for (int x = 0; x < getRows(); x++) {
            
            setColumnsConstraint();
            
            for (int y = 0; y < getColumns(); y++) {
                
                setRowConstraint();
                
                if (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0) {
                    
                    this.Square[x][y] = new House(x, y, getSquareHeight(), getSquareHeight(), 1);
                } else {
                    this.Square[x][y] = new House(x, y, getSquareHeight(), getSquareHeight(), 0);
                }
                
                this.Square[x][y].setEffect(getShadow());
                getField().add(this.Square[x][y], x, y);
            }
        }
        
        Piece unit1 = new Cajahyba(0, 1, 0, getSquareHeight());
        this.Square[0][1].setUnit(unit1);
        getField().add(unit1, 0, 1);
        
        unit1.setOnMousePressed(PiecePressed);
        
        Piece unit2 = new Trump(5, 5, 1, getSquareHeight());
        this.Square[5][5].setUnit(unit2);
        unit2.setOnMousePressed(PiecePressed);
        getField().add(unit2, 5, 5);
        
        Piece unit3 = new Jhin(6, 6, 1, getSquareHeight());
        unit3.setOnMousePressed(PiecePressed);
        this.Square[6][6].setUnit(unit3);
        getField().add(unit3, 6, 6);
    }
}
