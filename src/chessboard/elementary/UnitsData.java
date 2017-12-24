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
public class UnitsData {
    
    private final int ImageSize = 50;

    public ArrayList<Piece> getData() {
        return Data;
    }

    public void setData(ArrayList<Piece> Data) {
        this.Data = Data;
    }
    
    public void setNewUnit() {
        
    }
    
    private ArrayList<Piece> Data;
    
    public UnitsData() {
        
        Data = new ArrayList<Piece>();
        
        Data.add(new Cajahyba(ImageSize));
        //Peças Padrão.
    }
    
    public Piece getUnit(int i) {
        
        return Data.get(i);
    }
}
