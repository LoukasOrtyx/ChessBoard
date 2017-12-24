/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

/**
 *
 * @author Lucas
 */
public class Coordinate {

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    private int x, y;
    private double dx, dy;
    
    public Coordinate(int x, int y) {
        
        setX(x);
        setY(y);
    }
    
    public Coordinate(double x, double y) {
        
        setDx(x);
        setDy(y);
    }
    
}
