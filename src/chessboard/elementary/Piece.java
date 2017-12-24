/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;


import java.util.List;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lucas
 */
abstract class Piece extends ImageView {

    /**
     * @return the ImageSize
     */
    public int getImageSize() {
        return ImageSize;
    }

    public void setImageSize(int ImageSize) {
        this.ImageSize = ImageSize;
    }

    public int getColor() {
        return Color;
    }

    public void setColor(int Color) {
        this.Color = Color;
    }

    public Coordinate getPoint() {
        return Point;
    }
    
    public void setPoint(int x, int y) {
        this.Point = new Coordinate(x, y);
    }
    
    public void setPoint(Coordinate c) {
        
        this.Point = c;
    }
    
    private Coordinate Point;
    private int ImageSize;
    private int Color;

    public Piece(String Image_url) {
        
        super(Image_url);
        setCursor(Cursor.HAND);
    }
    
    abstract List<List<Coordinate>> PlotPaths();
    abstract List<List<Coordinate>> PlotCaptures();
}
