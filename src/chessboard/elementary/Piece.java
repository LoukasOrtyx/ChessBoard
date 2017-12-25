/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;


import java.util.List;
import javafx.scene.Cursor;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lucas
 */
abstract class Piece extends ImageView {

    /**
     * @return the ImageSize
     */
    public double getImageSize() {
        return ImageSize;
    }

    public void setImageSize(double ImageSize) {
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
    
    public void setShadow() {
        this.Shadow = new InnerShadow();
        
        this.Shadow.setOffsetX(2.0f);
        this.Shadow.setOffsetY(2.0f);
    }
    
    public InnerShadow getShadow() {
        return this.Shadow;
    }
    
    
    private InnerShadow Shadow;
    private Coordinate Point;
    private double ImageSize;
    private int Color;

    public Piece(String Image_url) {
        
        super(Image_url);
        setCursor(Cursor.HAND);
        setEffect(Shadow);
    }
    
    abstract List<List<Coordinate>> PlotPaths();
    abstract List<List<Coordinate>> PlotCaptures();
}
