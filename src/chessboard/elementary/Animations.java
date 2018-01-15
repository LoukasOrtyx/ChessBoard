/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author Lucas
 */
public class Animations {

    public House[][] getSquare() {
        return Square;
    }

    public void setSquare(House[][] Square) {
        this.Square = Square;
    }

    public GridPane getField() {
        return Field;
    }

    public void setField(GridPane Field) {
        this.Field = Field;
    }

    public double getAngle() {
        return Angle;
    }

    public void setAngle(double Angle) {
        this.Angle = Angle;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public ImageView getBullet() {
        return Bullet;
    }

    public void setBullet(ImageView Bullet) {
        this.Bullet = Bullet;
    }

    public double getVar3() {
        return var3;
    }

    public void setVar3(double var3) {
        this.var3 = var3;
    }

    public Timeline getAction2() {
        return Action2;
    }

    public void setAction2(Timeline Action2) {
        this.Action2 = Action2;
    }

    public double getVar1() {
        return var1;
    }

    public void setVar1(double var1) {
        this.var1 = var1;
    }

    public double getVar2() {
        return var2;
    }

    public void setVar2(double var2) {
        this.var2 = var2;
    }

    public double getMaxSize() {
        return MaxSize;
    }

    public void setMaxSize(double MaxSize) {
        this.MaxSize = MaxSize;
    }

    public double getMinSize() {
        return MinSize;
    }

    public void setMinSize(double MinSize) {
        this.MinSize = MinSize;
    }

    public double getMaxGlow() {
        return MaxGlow;
    }

    public void setMaxGlow(double MaxGlow) {
        this.MaxGlow = MaxGlow;
    }

    public double getMinGlow() {
        return MinGlow;
    }

    public void setMinGlow(double MinGlow) {
        this.MinGlow = MinGlow;
    }

    public Timeline getAction1() {
        return Action1;
    }

    public void setAction1(Timeline Action1) {
        this.Action1 = Action1;
    }
    
    private ImageView Bullet;
    private double Angle;
    private double B;
    
    private Timeline Action1, Action2;
    private double var1, var2, var3;
    private double MaxSize;
    private double MinSize;
    private double MaxGlow;
    private double MinGlow;
    
    private GridPane Field;
    private House[][] Square;
    
    private House Prior;
    
    public Animations() {};
    
    
    public void onSelection(Piece Unit) {
        
        setMaxSize(Unit.getFitHeight() + 5);
        setMinSize(Unit.getFitHeight());
        
        setMaxGlow(0.4);
        setMinGlow(0);
        
        setVar1(getMaxSize());
        setVar2(getMaxGlow());
        
        Unit.setFitHeight(getVar1());
        Unit.setFitWidth(getVar1());
        
        Unit.setEffect(new Glow(getVar2()));
        
        setAction1(new  Timeline(new KeyFrame(Duration.seconds(1), (event) -> {
            
            setVar1(getVar1() == getMaxSize()? getMinSize() : getMaxSize());
            setVar2(getVar2() == getMaxGlow()? getMinGlow() : getMaxGlow());
            
            Unit.setFitHeight(getVar1());
            Unit.setFitWidth(getVar1());
            
            Unit.setEffect(new Glow(getVar2()));
        })));
        
        getAction1().setCycleCount(Animation.INDEFINITE);
        getAction1().play();
    }
    
    public void onExit(Piece Unit) {
        
        getAction1().stop();
        
        Unit.setEffect(new Glow(getMinGlow()));
        
        Unit.setFitHeight(getMinSize());
        Unit.setFitWidth(getMinSize());
    }
    
    public void BlinkLabel(Label Info) {
        
        setVar3(1);
        
        setAction2(new Timeline(new KeyFrame(Duration.millis(500), (event) -> {
            
            Info.setOpacity(getVar3());
            
            setVar3(getVar3() == 1? 0 : 1);
        })));
        
        getAction2().setCycleCount(4);
        getAction2().play();
    }
    
    public void CalculateAngle(Coordinate Destiny, Coordinate Origin) {
        
        double Angle = (((double) Destiny.getY() - Origin.getY()) / ( (double) Destiny.getX() - Origin.getX()));
        
        setAngle(Angle);
    }
    
    public void CalculateB(Coordinate Point) {
        
        double b = ((Point.getY() * 50) - getAngle() * (Point.getX() * 50));
        
        setB(b);
    }
    
    public void Shot(House PriorSquare, House TargetSquare, ImageView Bullet, GridPane Field, House[][] Square) {
        
        
        
        setBullet(Bullet);
       
        setField(Field);
        
        Prior = PriorSquare;
        
        setSquare(Square);
        
        getBullet().setTranslateX(PriorSquare.getLayoutX());
        getBullet().setTranslateY(PriorSquare.getLayoutY());
        
        setVar1(PriorSquare.getPoint().getX() * 50);
        setVar2(PriorSquare.getPoint().getY() * 50);
        
        setVar3(PriorSquare.getPoint().getX() >= TargetSquare.getPoint().getX()? -1 : 1);
        
        Jhin Unit = ((Jhin) PriorSquare.getUnit());
        
        ImageView bullet = new ImageView(Unit.getBulletImage().getImage());
        bullet.setRotate(-90);
        
        
        getBullet().setImage(bullet.getImage());
        
        CalculateAngle(TargetSquare.getPoint(), PriorSquare.getPoint()); 
        CalculateB(TargetSquare.getPoint());
        
        getBullet().setRotate(Math.toDegrees(Math.atan(getAngle())));
        
        System.err.println(getB());
        System.err.println(getAngle());
        
        
        setAction1(new Timeline(new KeyFrame(Duration.millis(2), (event) -> {
            
            setVar1(getVar1() + getVar3());
            setVar2(getVar1() * getAngle() + getB());
            
            System.err.println(getVar1());
            System.err.println(getVar2());
            
            getBullet().setTranslateX(getVar1());
            getBullet().setTranslateY(getVar2());
            
            int x = (int) getBullet().getTranslateX() / 50;
            int y = (int) getBullet().getTranslateY() / 50;
            
            if (getSquare()[x][y].getUnit() != null && Prior.getUnit().getColor() != getSquare()[x][y].getUnit().getColor()) {
                
                getAction1().stop();
                
                Piece HitUnit = getSquare()[x][y].getUnit();
                
                getField().getChildren().remove(HitUnit);
                
                ImageView explosion = new ImageView("/Images/explosion.gif");
                
                getField().add(explosion, x, y);
                
                setAction2(new Timeline(new KeyFrame(Duration.seconds(1), (ev) -> {
                    
                    getField().getChildren().remove(explosion);
                })));
                
                getAction2().play();
            }
        })));
        
        getAction1().setCycleCount(Animation.INDEFINITE);
        getAction1().play();
    }
}
