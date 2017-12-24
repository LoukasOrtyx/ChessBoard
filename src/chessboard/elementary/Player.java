/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Player {

    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Piece> getTaken() {
        return Taken;
    }
    
    public void setTaken(ArrayList<Piece> Taken) {
        this.Taken = Taken;
    }
    
    public Player() {
        
        
    }
    
    private String Name;
    private ArrayList<Piece> Taken;
}
