package chessboard.elementary;

import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Window;

public class Board {

    public Piece getPriorUnit() {
        return PriorUnit;
    }

    public void setPriorUnit(Piece PriorUnit) {
        this.PriorUnit = PriorUnit;
    }

    public Coordinate getScene() {
        return Scene;
    }

    public void setScene(Coordinate Scene) {
        this.Scene = Scene;
    }

    public Coordinate getTranslate() {
        return Translate;
    }

    public void setTranslate(Coordinate Translate) {
        this.Translate = Translate;
    }

    public House getPriorSquare() {
        return PriorSquare;
    }

    public void setPriorSquare(House PriorSquare) {
        this.PriorSquare = PriorSquare;
    }

    public ImagePattern getBlack() {
        return black;
    }

    public void setBlack(ImagePattern black) {
        this.black = black;
    }

    public ImagePattern getWhite() {
        return white;
    }

    public void setWhite(ImagePattern white) {
        this.white = white;
    }

    public EventHandler getPiecePressed() {
        return PiecePressed;
    }

    public void setPiecePressed(EventHandler PiecePressed) {
        this.PiecePressed = PiecePressed;
    }

    public EventHandler getPieceDragged() {
        return PieceDragged;
    }

    public void setPieceDragged(EventHandler PieceDragged) {
        this.PieceDragged = PieceDragged;
    }

    public EventHandler getPieceDropped() {
        return PieceDropped;
    }

    public void setPieceDropped(EventHandler PieceDropped) {
        this.PieceDropped = PieceDropped;
    }

    public EventHandler getPieceEntered() {
        return PieceEntered;
    }

    public void setPieceEntered(EventHandler PieceEntered) {
        this.PieceEntered = PieceEntered;
    }

    public EventHandler getPieceExited() {
        return PieceExited;
    }

    public void setPieceExited(EventHandler PieceExited) {
        this.PieceExited = PieceExited;
    }

    public ImagePattern getGreen() {
        return green;
    }

    public void setGreen(ImagePattern green) {
        this.green = green;
    }

    public ImagePattern getLightgreen() {
        return lightgreen;
    }

    public void setLightgreen(ImagePattern lightgreen) {
        this.lightgreen = lightgreen;
    }

    public ImagePattern getRed() {
        return red;
    }

    public void setRed(ImagePattern red) {
        this.red = red;
    }

    public ImagePattern getLightred() {
        return lightred;
    }

    public void setLightred(ImagePattern lightred) {
        this.lightred = lightred;
    }

    public Animations getEffects() {
        return Effects;
    }

    public List<List<Coordinate>> getHighlighted() {
        return Highlighted;
    }

    public void setHighlighted(List<List<Coordinate>> Highlighted) {
        this.Highlighted = Highlighted;
    }

    public void setShadow(InnerShadow Shadow) {
        this.Shadow = Shadow;
    }

    public House[][] getSquare() {
        return Square;
    }

    public void setSquare(House[][] Square) {
        this.Square = Square;
    }

    public void setUser(Player[] User) {
        this.User = User;
    }

    public int getTurn() {
        return Turn;
    }

    public void setTurn(int Turn) {
        this.Turn = Turn;
    }

    public House[][] getSquares() {
        return getSquare();
    }

    public void setSquares(int rows, int columns) {
        this.setSquare(new House[rows][columns]);
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
        
        this.setUser(new Player[2]);
        
        this.getUser()[0] = new Player();
        this.getUser()[1] = new Player();
        
        this.getUser()[0].setName(User[0]);
        this.getUser()[1].setName(User[1]);
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
        this.setShadow(new InnerShadow());
        
        this.getShadow().setOffsetX(1.0f);
        this.getShadow().setOffsetY(1.0f);
    }
    
    public InnerShadow getShadow() {
        return this.Shadow;
    }
    
    public boolean HouseIsMovable(Coordinate Point) {
        
        int x = Point.getX();
        int y = Point.getY();
        
        return (x < getRows() && x > -1 && y < getColumns() && y > -1 && this.getSquare()[x][y].getUnit() == null);
    }
    
    public boolean HouseIsCapturable(Coordinate Point, int Color) {
        
        int x = Point.getX();
        int y = Point.getY();
        
        return (x < getRows() && x > -1 && y < getColumns() && y > -1 && this.getSquare()[x][y].getUnit() != null && this.getSquare()[x][y].getUnit().getColor() != Color);
    }
    
    public List<List<Coordinate>> ValidatePaths(List<List<Coordinate>> AllPaths) {
        
        int k = 0;
        
        List<List<Coordinate>> ValidPaths = new ArrayList<>();
        
        ValidPaths.add(k, new ArrayList<>());
        
        for (int i = 0; i < AllPaths.size(); i++) {
            
            for (int j = 0; j < AllPaths.get(i).size(); j++) {
                
                Coordinate Point = AllPaths.get(i).get(j);
                
                if (HouseIsMovable(Point)) {
                     
                    ValidPaths.get(k).add(Point);
                } else {
                    
                    break;
                }
            }
            
            if (!ValidPaths.get(k).isEmpty()) {

                ValidPaths.add(++k, new ArrayList<>());
            }
        }
        
        return ValidPaths;
    }
    
    public List<List<Coordinate>> ValidateCaptures(List<List<Coordinate>> AllCaptures, int Color) {

        int k = 0;

        List<List<Coordinate>> ValidCaptures = new ArrayList<>();
        
        ValidCaptures.add(k, new ArrayList<>());

        for (int i = 0; i < AllCaptures.size(); i++) {

            for (int j = 0; j < AllCaptures.get(i).size(); j++) {

                Coordinate Point = AllCaptures.get(i).get(j);

                if (HouseIsCapturable(Point, Color)) {

                    ValidCaptures.get(k).add(Point);
                } else {
                    
                    break;
                }
            }

            if (!ValidCaptures.get(k).isEmpty()) {

                ValidCaptures.add(++k, new ArrayList<>());
            }
        }

        return ValidCaptures;
    }
    
    public void ColorDichotomy(Coordinate Point, ImagePattern Even, ImagePattern Odd) {
        
        int x = Point.getX();
        int y = Point.getY();
        
        if (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0) {
            
            this.getSquare()[x][y].setFill(Even);
        } else {
            
            this.getSquare()[x][y].setFill(Odd);
        }
    }
    
    public void PaintBoard(List<List<Coordinate>> Points, ImagePattern Even, ImagePattern Odd) {
        
        for (int i = 0; i < Points.size(); i++) {
            
            for (int j = 0; j < Points.get(i).size(); j++) {
                
                ColorDichotomy(Points.get(i).get(j), Even, Odd);
            }
        }
    }
    
    public void CleanHighlight() {
        
        for (int i = 0; i < getHighlighted().size(); i++) {
            
            for (int j = 0; j < getHighlighted().get(i).size(); j++) {
                
                ColorDichotomy(getHighlighted().get(i).get(j), getBlack(), getWhite());
            }
        }
    }
    
    public void ShowMotions(Piece Unit) {
        
        List<List<Coordinate>> Captures = Unit.PlotCaptures();
        List<List<Coordinate>> Paths = Unit.PlotPaths();
        List<List<Coordinate>> Motions = new ArrayList<>();
        
        Captures = ValidateCaptures(Captures, Unit.getColor());
        Paths = ValidatePaths(Paths);
        
        Motions.addAll(Paths);
        Motions.addAll(Captures);
        
        setHighlighted(Motions);
        
        PaintBoard(Captures, getRed(), getLightred());
        PaintBoard(Paths, getGreen(), getLightgreen());
    }
    
    public void setImagePatterns() {
        
        ImageView image = new ImageView("/Images/greenhouse.jpg");
        setGreen(new ImagePattern(image.getImage()));

        image = new ImageView("/Images/lightgreenhouse.jpg");
        setLightgreen(new ImagePattern(image.getImage()));
        
        image = new ImageView("/Images/red.jpg");
        setRed(new ImagePattern(image.getImage()));

        image = new ImageView("/Images/lightred.jpg");
        setLightred(new ImagePattern(image.getImage()));
        
        image = new ImageView("/Images/whitehouse.jpeg");
        setWhite(new ImagePattern(image.getImage()));
        
        image = new ImageView("/Images/blackhouse.jpg");
        setBlack(new ImagePattern(image.getImage()));
    }
    
    public void setMouseActions() {
        
        setPiecePressed((event) -> {
            
            setPriorUnit((Piece) event.getSource());
            
            int x = getPriorUnit().getPoint().getX();
            int y = getPriorUnit().getPoint().getY();
            
            setPriorSquare(this.Square[x][y]);
            
            getEffects().onSelection(getPriorUnit());
            
            double dx = ((MouseEvent) event).getSceneX();
            double dy = ((MouseEvent) event).getSceneY();
            
            setScene(new Coordinate(dx, dy));
            setTranslate(new Coordinate(getPriorUnit().getTranslateX(), getPriorUnit().getTranslateY()));
            
            ShowMotions(getPriorUnit());
        });
        
        setPieceDragged((event) -> {
            
            double offsetX = ((MouseEvent) event).getSceneX() - getScene().getDx();
            double offsetY = ((MouseEvent) event).getSceneY() - getScene().getDy();
            
            double newTranslateX = offsetX + getTranslate().getDx();
            double newTranslateY = offsetY + getTranslate().getDy();
            
            getPriorUnit().setTranslateX(newTranslateX);
            getPriorUnit().setTranslateY(newTranslateY);
        });
        
        setPieceDropped((event) -> {
            
           Piece Unit = (Piece) event.getSource();
           
           getEffects().onExit(Unit);
           
           CleanHighlight();
        });
    }
    
    private EventHandler PiecePressed;
    private EventHandler PieceDragged;
    private EventHandler PieceDropped;
    private EventHandler PieceEntered;
    private EventHandler PieceExited;
    
    private ImagePattern green, lightgreen;
    private ImagePattern red, lightred;
    private ImagePattern black, white;
    
    private Coordinate Scene, Translate;
    private House PriorSquare;
    private Piece PriorUnit;
    private final Animations Effects = new Animations();
    private List<List<Coordinate>> Highlighted;
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
        
        setMouseActions();
        setImagePatterns();
        
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
        unit1.setOnMouseReleased(PieceDropped);
        unit1.setOnMouseDragged(PieceDragged);
        
        Piece unit2 = new Trump(5, 5, 1, getSquareHeight());
        this.Square[5][5].setUnit(unit2);
        unit2.setOnMousePressed(PiecePressed);
        unit2.setOnMouseReleased(PieceDropped);
        unit2.setOnMouseDragged(PieceDragged);
        getField().add(unit2, 5, 5);
        
        Piece unit3 = new Jhin(6, 6, 1, getSquareHeight());
        unit3.setOnMousePressed(PiecePressed);
        unit3.setOnMouseReleased(PieceDropped);
        unit3.setOnMouseDragged(PieceDragged);
        this.Square[6][6].setUnit(unit3);
        getField().add(unit3, 6, 6);
    }
}
