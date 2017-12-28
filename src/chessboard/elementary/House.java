/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import javafx.scene.effect.Glow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Lucas
 */
public class House extends Rectangle {

    public Glow getGlow() {
        return Glow;
    }

    public void setGlow(Glow Glow) {
        this.Glow = Glow;
    }

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
    private InnerShadow Shadow;
    private Glow Glow;
    
    public void setShadow() {
        
        this.Shadow = new InnerShadow();

        getShadow().setOffsetX(0.5f);
        getShadow().setOffsetY(0.5f);
    }

    public InnerShadow getShadow() {
        return this.Shadow;
    }
    
    public House(int x, int y, double Width, double Height, int Colour) {
        
        super(Width, Height);

        ImageView image;
        
        setShadow();
        setGlow(new Glow(0.2));
        
        setPoint(x, y);
        setUnit(null);
        setTwall(null);
        
        setEffect(getShadow());
        ((InnerShadow) getEffect()).setInput(getGlow());
        
        if(Colour == 1) image = new ImageView("/Images/blackhouse.jpg");
        else image = new ImageView("/Images/whitehouse.jpeg");
        
        setBackground(new ImagePattern(image.getImage()));
        
        setFill(background);
    } 
    
    public void setImagePattern(String background) {
        
        ImageView image = new ImageView(background);
        
        setBackground(new ImagePattern(image.getImage()));
        
        setFill(getBackground());
        
    }
    
    public void setImagePattern(ImagePattern background) {
        
        setBackground(background);
        setFill(background);
    }
}
