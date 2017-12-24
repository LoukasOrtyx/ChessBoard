/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard.elementary;

import javafx.scene.image.ImageView;

/**
 *
 * @author Lucas
 */
public class Wall extends ImageView {

    public int getColor() {
        return Color;
    }

    public void setColor(int Color) {
        this.Color = Color;
    }

    public int getImageSize() {
        return ImageSize;
    }

    public void setImageSize(int ImageSize) {
        this.ImageSize = ImageSize;
    }
    
    private int ImageSize, Color;
    
    public Wall(int ImageSize, int Color) {
        
        super("/Images/wall.png");
        setImageSize(ImageSize);
        
        setFitHeight(getImageSize());
        setFitWidth(getImageSize());
        
        setColor(Color);
    }
}
