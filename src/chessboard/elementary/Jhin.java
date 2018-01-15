/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;

/**
 *
 * @author Lucas
 */
public class Jhin extends Piece {

    public ImageView getAim() {
        return Aim;
    }

    public void setAim(ImageView Aim) {
        this.Aim = Aim;
    }

    public void setBulletImage(ImageView Bullet) {
        this.Bullet = Bullet;
    }
    
    public ImageView getBulletImage() {
        
        return this.Bullet;
    }

    private boolean Ammo;
    private ImageView Aim;
    private ImageView Bullet;

    public boolean getAmmo() {

        return this.Ammo;
    }

    public void setAmmo(boolean Bullet) {

        this.Ammo = Bullet;
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
        setBulletImage(new ImageView("/Images/Bullet.png"));
        setAim(new ImageView("/Images/aim.png"));
        
        setLMB("/Songs/jhin.mp3");
        setRMB("/Songs/JhinSpecial.mp3");

        setImageSize(ImageSize);
        setColor(color);
        setAmmo(true);
        
        setFitHeight(getImageSize());
        setFitWidth(getImageSize());

        setPoint(x, y);
    }

}
