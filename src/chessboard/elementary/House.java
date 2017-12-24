/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Lucas
 */
public class House extends Rectangle {

    public Wall getTwall() {
        return Twall;
    }
    public void setTwall(Wall Twall) {
        this.Twall = Twall;
    }

    public ImagePattern getBackground() {
        return background;
    }
    
    public void setBackground(ImagePattern background) {
        this.background = background;
    }

    public Piece getUnit() {
        return Unit;
    }

    public void setUnit(Piece Unit) {
        this.Unit = Unit;
        
        if(Unit != null) {
            Unit.setPoint(Point);
        }
    }

    public Coordinate getPoint() {
        return Point;
    }

    public void setPoint(int x, int y) {
        this.Point = new Coordinate(x, y);
    }
    
    private Piece Unit;
    private Wall Twall;
    private Coordinate Point;
    private ImagePattern background;
    
    public House(int x, int y, int Width, int Height, int Colour) {
        
        super(Width, Height);

        ImageView image;
        
        setPoint(x, y);
        setUnit(null);
        setTwall(null);
        
        if(Colour == 1) image = new ImageView("/Images/blackhouse.jpg");
        else image = new ImageView("/Images/whitehouse.jpeg");
        
        setBackground(new ImagePattern(image.getImage()));
        
        setFill(background);
    } 
    
    public void setImagePattern(String background) {
        
        ImageView image = new ImageView(background);
        
        setBackground(new ImagePattern(image.getImage()));
        
        setFill(this.background);
    }
    
    public void setImagePattern(ImagePattern background) {
        
        setBackground(background);
        setFill(background);
    }
}
