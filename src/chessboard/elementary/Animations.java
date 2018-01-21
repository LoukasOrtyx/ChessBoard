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
import javafx.util.Duration;

/**
 *
 * @author Lucas
 */
public class Animations {

    public ImageView getIcon() {
        return Icon;
    }

    public void setIcon(ImageView Icon) {
        this.Icon = Icon;
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
    
    private ImageView Icon;
    private Timeline Action1, Action2;
    private double var1, var2, var3;
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
    
    public void SmokeEntropy(ImageView Smoke) {
        
        setVar1(1);
        setIcon(Smoke);
        
        setAction1(new Timeline(new KeyFrame(Duration.ONE, (event) -> {
            
            setVar1(getVar1() - 0.001);
            getIcon().setOpacity(getVar1());
        })));
        
        getAction1().setCycleCount(1000);
        getAction1().play();
    }
}
