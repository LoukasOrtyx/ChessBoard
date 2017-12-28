/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
 public class Trump extends Piece {

     
     
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
     
    private int limit;

    public Trump(int x, int y, int color, double ImageSize) {
        
        super("/Images/trump.png");
         
        setImageSize(ImageSize);
        
        setLimit(0);
        setFitHeight(getImageSize());
        setFitWidth(getImageSize());
        setColor(color);
        
        setPoint(x, y);
    }

    @Override
    List<List<Coordinate>> PlotPaths() {
       
        int x = getPoint().getX();
        int y = getPoint().getY();
        
        List<List<Coordinate>> Path = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            Path.add(i, new ArrayList<>());
        }   
        
        if(getColor() == 1) {
         
            Path.get(0).add(new Coordinate(x, y - 1));
            Path.get(1).add(new Coordinate(x + 1, y + 1));
            Path.get(1).add(new Coordinate(x + 2, y));
            Path.get(1).add(new Coordinate(x + 2, y - 1));
            Path.get(2).add(new Coordinate(x - 1, y + 1));
            Path.get(2).add(new Coordinate(x - 2, y));
            Path.get(2).add(new Coordinate(x - 2, y - 1));
        } else {
            
            Path.get(0).add(new Coordinate(x, y + 1));
            Path.get(1).add(new Coordinate(x - 1, y - 1));
            Path.get(1).add(new Coordinate(x - 2, y));
            Path.get(1).add(new Coordinate(x - 2, y + 1));
            Path.get(2).add(new Coordinate(x + 1, y - 1));
            Path.get(2).add(new Coordinate(x + 2, y));
            Path.get(2).add(new Coordinate(x + 2, y + 1));
        }
        
        
        return Path;
    }

    @Override
    List<List<Coordinate>> PlotCaptures() {
        
        int x = getPoint().getX();
        int y = getPoint().getY();

        List<List<Coordinate>> Captures = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Captures.add(i, new ArrayList<>());
        }
        
        Captures.get(0).add(new Coordinate(x + 1, y + 1));
        Captures.get(1).add(new Coordinate(x - 1, y - 1));
        Captures.get(2).add(new Coordinate(x + 1, y - 1));
        Captures.get(3).add(new Coordinate(x - 1, y + 1));
        

        return Captures;
    }
}

     