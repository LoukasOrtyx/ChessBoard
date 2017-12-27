/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.util.Duration;

/**
 *
 * @author Lucas
 */
public class Animations {

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

    public Timeline getMotion() {
        return Motion;
    }

    public void setMotion(Timeline Motion) {
        this.Motion = Motion;
    }
    
    private Timeline Motion;
    private double var1, var2;
    private double MaxSize;
    private double MinSize;
    private double MaxGlow;
    private double MinGlow;
    
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
        
        setMotion(new  Timeline(new KeyFrame(Duration.seconds(1), (event) -> {
            
            setVar1(getVar1() == getMaxSize()? getMinSize() : getMaxSize());
            setVar2(getVar2() == getMaxGlow()? getMinGlow() : getMaxGlow());
            
            Unit.setFitHeight(getVar1());
            Unit.setFitWidth(getVar1());
            
            Unit.setEffect(new Glow(getVar2()));
        })));
        
        getMotion().setCycleCount(Animation.INDEFINITE);
        getMotion().play();
    }
    
    public void onExit(Piece Unit) {
        
        getMotion().stop();
        
        Unit.setEffect(new Glow(getMinGlow()));
        
        Unit.setFitHeight(getMinSize());
        Unit.setFitWidth(getMinSize());
        
    }
}
