package chessboard.elementary;

import chessboard.songPlayer;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Window;

public class Board {

    public ImageView getIcon() {
        return Icon;
    }

    public void setIcon(ImageView Icon) {
        this.Icon = Icon;
    }

    public EventHandler getAimFieldExited() {
        return AimFieldExited;
    }

    public void setAimFieldExited(EventHandler AimFieldExited) {
        this.AimFieldExited = AimFieldExited;
    }

    public EventHandler getAimFieldEntered() {
        return AimFieldEntered;
    }

    public void setAimFieldEntered(EventHandler AimFieldEntered) {
        this.AimFieldEntered = AimFieldEntered;
    }

    public EventHandler getAimFieldMoved() {
        return AimFieldMoved;
    }

    public void setAimFieldMoved(EventHandler AimFieldMoved) {
        this.AimFieldMoved = AimFieldMoved;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }

    public songPlayer getMedia() {
        return media;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public boolean isLandable() {
        return Landable;
    }

    public void setLandable(boolean Landable) {
        this.Landable = Landable;
    }

    public House getGlowSquare() {
        return GlowSquare;
    }

    public void setGlowSquare(House GlowSquare) {
        this.GlowSquare = GlowSquare;
    }

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
    
    public boolean HouseIsValid(House Square) {
        
        return (Square.getFill().equals(getLightgreen()) || Square.getFill().equals(getGreen()) || Square.getFill().equals(getRed()) || Square.getFill().equals(getLightred()));
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
    
    public House FindSquare(double dx, double dy) {
        
        int x = (int) (dx / getSquareHeight());
        int y = (int) ((dy - 30) / getSquareHeight());
        
        return this.Square[x][y];
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
       
        setAimFieldClick((event) -> {
          
            if (((MouseEvent) event).getButton() == MouseButton.PRIMARY) {
            
                double dx = ((MouseEvent) event).getSceneX();
                double dy = ((MouseEvent) event).getSceneY();
                
                House Square = FindSquare(dx, dy);
                
               if (Square.getUnit() != null && Square.getUnit().getColor() != getPriorUnit().getColor()) {
                  
                  getIcon().setTranslateX(0);
                  getIcon().setTranslateY(0);
                  
                  getField().getChildren().remove(getIcon());
                  getField().add(getIcon(), 0, 0);
                  
                  getMedia().playSong("/Songs/jhin_shot.mp3", 1.0);
                  getEffects().Shot(getPriorSquare(), Square, getIcon(), getField(), getSquares());
               }
            }
            
            event.consume();
        });
        
        setAimFieldExited((event) -> {
          
            getField().setCursor(Cursor.DEFAULT);

            event.consume();
        });
        
        setAimFieldEntered((event) -> {
          
            Elipse = true;
            getField().setCursor(Cursor.NONE);  
            
            event.consume();
        });
        
        setAimFieldMoved((event) -> {
            
            double SceneX = ((MouseEvent) event).getSceneX();
            double SceneY = ((MouseEvent) event).getSceneY();
            
            double AimX = getIcon().getLayoutX();
            double AimY = getIcon().getLayoutY();

            double dx = SceneX - AimX;
            double dy = SceneY - AimY;
            
            getIcon().setTranslateX(dx - 25);
            getIcon().setTranslateY(dy - 55);
            
            
            event.consume();
        });
        
        setPiecePressed((event) -> {
            
            setPriorUnit((Piece) event.getSource());
            
            int x = getPriorUnit().getPoint().getX();
            int y = getPriorUnit().getPoint().getY();

            setPriorSquare(this.Square[x][y]);
            setGlowSquare(this.Square[x][y]);
            
            if (((MouseEvent) event).getButton() == MouseButton.SECONDARY && getPriorUnit().getColor() == getTurn()) {
                
                Propagate = false;
                
                if (getPriorUnit() instanceof Jhin) {
                    
                    getPriorUnit().setCursor(Cursor.NONE);
                    
                    getField().addEventHandler(MouseEvent.MOUSE_CLICKED, getAimFieldClick());
                    getField().addEventHandler(MouseEvent.MOUSE_ENTERED, getAimFieldEntered());
                    getField().addEventHandler(MouseEvent.MOUSE_EXITED, getAimFieldExited());
                    getField().addEventHandler(MouseEvent.MOUSE_MOVED, getAimFieldMoved());
                    
                    setIcon(((Jhin) getPriorUnit()).getAim());
                    
                    getField().add(getIcon(), getPriorSquare().getPoint().getX(), getPriorSquare().getPoint().getY());
                    
                    
                    getField().setCursor(Cursor.NONE);
                    
                    
                } else if (getPriorUnit() instanceof Trump){
                    
                    
                } else {
                    
                    event.consume();
                    return;
                }
                
                getMedia().playSong(getPriorUnit().getRMB());
                
            } else {
                

                setSong(getPriorUnit().getLMB());
                setWrong(getPriorUnit().getWrong());

                if (getPriorUnit().getColor() != Turn) {

                    Propagate = false;
                    
                    getPriorUnit().toFront();

                    getMarker().setText("Vez de: " + getUser()[Turn].getName());
                    getMarker().setTextFill(Color.RED);

                    getMarker().setLayoutX(((MouseEvent) event).getSceneX() - 30);
                    getMarker().setLayoutY(((MouseEvent) event).getSceneY() + 30);

                    getMarker().toFront();
                    Effects.BlinkLabel(getMarker());

                    getMedia().playSong(getWrong());
                } else {

                    getMedia().playSong(getSong());

                    getEffects().onSelection(getPriorUnit());

                    double dx = ((MouseEvent) event).getSceneX();
                    double dy = ((MouseEvent) event).getSceneY();

                    setScene(new Coordinate(dx, dy));
                    setTranslate(new Coordinate(getPriorUnit().getTranslateX(), getPriorUnit().getTranslateY()));

                    ShowMotions(getPriorUnit());
                }
            }
            
            event.consume();
        });
        
        setPieceDragged((event) -> {
            
            if (Propagate == true) {
            
                double dx = ((MouseEvent) event).getSceneX();
                double dy = ((MouseEvent) event).getSceneY();

                double offsetX = dx - getScene().getDx();
                double offsetY = dy - getScene().getDy();

                getPriorUnit().setCursor(Cursor.CLOSED_HAND);

                House Square = FindSquare(dx, dy);

                if (Square != getGlowSquare()) {

                    getGlowSquare().getShadow().setInput(getGlowSquare().getGlow());
                    setGlowSquare(Square);
                }

                if (HouseIsValid(getGlowSquare())) {

                    setLandable(true);
                    getGlowSquare().getShadow().setInput(new Glow(1));
                } else {
                    setLandable(false);
                }

                double newTranslateX = offsetX + getTranslate().getDx();
                double newTranslateY = offsetY + getTranslate().getDy();

                getPriorUnit().setTranslateX(newTranslateX);
                getPriorUnit().setTranslateY(newTranslateY);
            } else {
                
                Propagate = true;
            }
                      
            event.consume();
        });
        
        setPieceDropped((event) -> {
            
            if (Propagate == false) {
                
                Propagate = true;
                event.consume();
                return;
            }
            
            double dx = ((MouseEvent) event).getSceneX();
            double dy = ((MouseEvent) event).getSceneY();
           
            House Square = FindSquare(dx, dy);
            
            if(Landable == true) {
                
                getField().getChildren().remove(getPriorUnit());
                getPriorSquare().setUnit(null);
                
                getField().add(getPriorUnit(), Square.getPoint().getX(), Square.getPoint().getY());
                Square.setUnit(getPriorUnit());
                
                Turn ^= 1;
                
                getMedia().playSong(getSong());
                setLandable(false);
            } else {

                getMedia().playSong(getWrong());
            }
                           
            getPriorUnit().setCursor(Cursor.HAND);
            
            getPriorUnit().setTranslateX(getTranslate().getDx());
            getPriorUnit().setTranslateY(getTranslate().getDy());
            
            getGlowSquare().getShadow().setInput(getGlowSquare().getGlow());
            
            getEffects().onExit(getPriorUnit());
           
            CleanHighlight();
            
            event.consume();
        });
        
        setPieceEntered((event) -> {
           
            Piece Unit = (Piece) event.getSource();
            
            if (Unit.getColor() != Turn || Elipse == true) {
                
                Unit.setCursor(Cursor.NONE);
            } else {
                
                Unit.setCursor(Cursor.HAND);
            }
            
            event.consume();
        });
    }
    
    private EventHandler AimFieldClick;
    private EventHandler AimFieldExited;
    private EventHandler AimFieldEntered;
    private EventHandler AimFieldMoved;
    private EventHandler PiecePressed;
    private EventHandler PieceDragged;
    private EventHandler PieceDropped;
    private EventHandler PieceEntered;
    
    private ImagePattern green, lightgreen;
    private ImagePattern red, lightred;
    private ImagePattern black, white;
    
    private final songPlayer media = new songPlayer();
    private String song;
    private String wrong;
    
    private ImageView Icon;
    private boolean Elipse = false;
    private boolean Propagate = true;
    private boolean Landable;
    private Coordinate Scene, Translate;
    private House PriorSquare;
    private House GlowSquare;
    private Piece PriorUnit;
    private final Animations Effects = new Animations();
    private List<List<Coordinate>> Highlighted;
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
        
        getField().setCursor(Cursor.DEFAULT);
        
        setInfo(info);
        setMarker(marker);
        
        setUser(players);
        
        setMouseActions();
        setImagePatterns();       
        
        for (int x = 0; x < getRows(); x++) {
            
            setColumnsConstraint();
            
            for (int y = 0; y < getColumns(); y++) {
                
                setRowConstraint();
                
                if (x % 2 == 0 && y % 2 == 0 || x % 2 != 0 && y % 2 != 0) {
                    
                    this.Square[x][y] = new House(x, y, getSquareHeight(), getSquareHeight(), 1);
                } else {
                    this.Square[x][y] = new House(x, y, getSquareHeight(), getSquareHeight(), 0);
                }
                
                getField().add(this.Square[x][y], x, y);
            }
        }
        
        Piece unit1 = new Cajahyba(0, 1, 0, getSquareHeight());
        this.Square[0][1].setUnit(unit1);
        getField().add(unit1, 0, 1);
        
        unit1.setOnMousePressed(PiecePressed);
        unit1.setOnMouseReleased(PieceDropped);
        unit1.setOnMouseDragged(PieceDragged);
        unit1.setOnMouseEntered(PieceEntered);
        
        Piece unit2 = new Trump(5, 5, 1, getSquareHeight());
        this.Square[5][5].setUnit(unit2);
        unit2.setOnMousePressed(PiecePressed);
        unit2.setOnMouseReleased(PieceDropped);
        unit2.setOnMouseDragged(PieceDragged);
        unit2.setOnMouseEntered(PieceEntered);
        getField().add(unit2, 5, 5);
        
        Piece unit3 = new Jhin(6, 6, 1, getSquareHeight());
        unit3.setOnMousePressed(PiecePressed);
        unit3.setOnMouseReleased(PieceDropped);
        unit3.setOnMouseDragged(PieceDragged);
        unit3.setOnMouseEntered(PieceEntered);
        this.Square[6][6].setUnit(unit3);
        getField().add(unit3, 6, 6);
    }

    public EventHandler getAimFieldClick() {
        return AimFieldClick;
    }

    public void setAimFieldClick(EventHandler AimFieldClick) {
        this.AimFieldClick = AimFieldClick;
    }
}
