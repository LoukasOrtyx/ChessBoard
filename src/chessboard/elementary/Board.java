package chessboard.elementary;

import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;

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
    }
}
