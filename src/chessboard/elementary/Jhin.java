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
public class Jhin extends Piece {

    private boolean bullet = true;

    public boolean getBullet() {

        return this.bullet;
    }

    public void setBullet(boolean Bullet) {

        this.bullet = Bullet;
    }

    @Override
    List<List<Coordinate>> PlotPaths() {

        int x = getPoint().getX();
        int y = getPoint().getY();

        List<List<Coordinate>> Path = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Path.add(i, new ArrayList<>());
        }

        Path.get(0).add(new Coordinate(x + 1, y));
        Path.get(1).add(new Coordinate(x, y + 1));
        Path.get(2).add(new Coordinate(x - 1, y));
        Path.get(3).add(new Coordinate(x, y - 1));

        return Path;

    }

    @Override
    List<List<Coordinate>> PlotCaptures() {

        int x = getPoint().getX();
        int y = getPoint().getY();

        List<List<Coordinate>> Capture = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Capture.add(i, new ArrayList<>());
        }
        
        Capture.get(0).add(new Coordinate(x + 1, y + 1));
        Capture.get(1).add(new Coordinate(x, y + 1));
        Capture.get(2).add(new Coordinate(x + 1, y));
        
        return Capture;
    }

    public Jhin(int x, int y, int color, double ImageSize) {

        super("/Images/jhin.png");

        setImageSize(ImageSize);
        setColor(color);

        setFitHeight(getImageSize());
        setFitWidth(getImageSize());

        setPoint(x, y);
    }

}
