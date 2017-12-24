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
public class Cajahyba extends Piece {
    

    public Cajahyba(int x, int y, int color, int ImageSize) {
        
        super("Images/C.png");
        
        setImageSize(ImageSize - 5);
        
        setFitHeight(getImageSize());
        
        setTranslateX(2.5);
        setFitWidth(getImageSize());
        
        
        setPoint(x, y);
        setColor(color);
    }
    
    public Cajahyba(int ImageSize) {
        
        super("Images/C.png");
        
        setImageSize(ImageSize - 5);
        setTranslateX(2.5);
        setFitHeight(getImageSize());
        setFitWidth(getImageSize());
    }

    @Override
    List<List<Coordinate>> PlotPaths() {
       
        int x = getPoint().getX();
        int y = getPoint().getY();
        
        List<List<Coordinate>> Path = new ArrayList<>();
        
        for(int i = 0; i < 4; i++) {
            Path.add(i, new ArrayList<>());
        }
        
        Path.get(0).add(new Coordinate(x, y + 1));
        Path.get(0).add(new Coordinate(x - 1, y + 1));
        Path.get(0).add(new Coordinate(x - 2, y + 1));
        Path.get(0).add(new Coordinate(x - 2, y));
        
        Path.get(1).add(new Coordinate(x, y - 1));
        Path.get(1).add(new Coordinate(x + 1, y - 1));
        Path.get(1).add(new Coordinate(x + 2, y - 1));
        Path.get(1).add(new Coordinate(x + 2, y));
        
        Path.get(2).add(new Coordinate(x - 1, y));
        Path.get(2).add(new Coordinate(x - 1, y - 1));
        Path.get(2).add(new Coordinate(x - 1, y - 2));
        Path.get(2).add(new Coordinate(x, y - 2));
        
        Path.get(3).add(new Coordinate(x + 1, y));
        Path.get(3).add(new Coordinate(x + 1, y + 1));
        Path.get(3).add(new Coordinate(x + 1, y + 2));
        Path.get(3).add(new Coordinate(x, y + 2));
        
        return Path;
    }

    @Override
    List<List<Coordinate>> PlotCaptures() {
        
        int x = getPoint().getX();
        int y = getPoint().getY();
        
        List<List<Coordinate>> Captures = new ArrayList<>();
        
        for(int i = 0; i < 4; i++) {
            Captures.add(i, new ArrayList<>());
        }
    
        Captures.get(0).add(new Coordinate(x - 1, y));
        Captures.get(0).add(new Coordinate(x - 2, y));
        
        Captures.get(1).add(new Coordinate(x, y + 1));
        Captures.get(1).add(new Coordinate(x, y + 2));
        
        Captures.get(2).add(new Coordinate(x + 1, y));
        Captures.get(2).add(new Coordinate(x + 2, y));
        
        Captures.get(3).add(new Coordinate(x, y - 1));
        Captures.get(3).add(new Coordinate(x, y - 2));
        
        return Captures;
    }
}