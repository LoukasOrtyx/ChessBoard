/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessboard;

import chessboard.elementary.Board;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Lucas
 */
public class songPlayer {

    private MediaPlayer media;

    public void playSong(String url) {

        Media song = null;

        try {

            song = new Media(getClass().getResource(url).toURI().toString());
        } catch (URISyntaxException ex) {

            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }

        media = new MediaPlayer(song);
        media.setVolume(0.2);
        media.play();
    }

    public void playSong(String url, int time) {

        Media song = null;

        try {

            song = new Media(getClass().getResource(url).toURI().toString());
        } catch (URISyntaxException ex) {

            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }

        media = new MediaPlayer(song);
        media.setCycleCount(time);
        media.setVolume(0.2);
        media.play();
    }

    public void muteSong() {

        media.setMute(true);
    }

    public boolean SongIsMuted() {

        return media.isMute();
    }

    public void unmuteSong() {

        media.setMute(false);
    }

    public void setIntensity(double hz) {

        media.setVolume(hz);
    }

    public songPlayer() {

    }
}
