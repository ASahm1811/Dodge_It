package main.music;

import main.MainGame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class MusicButton {

    public static void turnOnOffMusic(int mx, int my) {
        if (MainGame.buttonSelected(mx, my, MainGame.width/60, (int) (MainGame.height/1.25), MainGame.width/16,
                MainGame.height/10)) {
            if (MainGame.music_on) {
                MainGame.music_on = false;
                // stop music
                MusicPlayer.stopMusic();
            } else {
                MainGame.music_on = true;
                // play music
                try {
                    MusicPlayer.playMusic("menu_music.wav");
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }

            }

        }
    }

    public static void turnOnOffMusic_Pause_EndGame(int mx, int my) {
        if (MainGame.buttonSelected(mx, my, MainGame.width/60, (int) (MainGame.height/1.25), MainGame.width/16,
                MainGame.height/10)) {
            if (MainGame.music_on) {
                MainGame.music_on = false;
            } else {
                MainGame.music_on = true;

            }

        }
    }

    public static void drawMusicButton(Graphics2D g) {
        g.setStroke(new BasicStroke(4));
        if (MainGame.music_on) {
            g.setColor(Color.BLACK);
            g.drawArc((int) (MainGame.width/27.5), (int) (MainGame.height/1.2), (int) (MainGame.width/50),
                    (MainGame.height/30), -45, 90);
            g.drawArc(MainGame.width/33, (int) (MainGame.height/1.222), (int) (MainGame.width/28),
                    (int) (MainGame.height/16), -45, 90);
            g.drawArc((int) (MainGame.width/41), (int) (MainGame.height/1.242), (MainGame.width/20),
                    (MainGame.height/11), -45, 90);
        }
        else {
            g.setColor(Color.GRAY);
        }

//        // selection area
//        g.drawRect(MainGame.width/60, (int) (MainGame.height/1.25), MainGame.width/16,
//                MainGame.height/10);

        g.fillRect(MainGame.width/50, (int) (MainGame.height/1.2), (int) (MainGame.width/36.5),
                (int) (MainGame.height/27.5));
        g.fillPolygon(new int[] {(int) (MainGame.width/50 + (MainGame.width/36.5)/2),
                (int) (MainGame.width/50 + (MainGame.width/36.5)), (int) (MainGame.width/50 + (MainGame.width/36.5))},
                new int[]{(int) (MainGame.height/1.2), (int) (MainGame.height/1.245), (int) (MainGame.height/1.2)},
                3);
        g.fillPolygon(new int[] {(int) (MainGame.width/50 + (MainGame.width/36.5)/2),
                (int) (MainGame.width/50 + (MainGame.width/36.5)), (int) (MainGame.width/50 + (MainGame.width/36.5))},
                new int[]{(int) ((int) (MainGame.height/1.2) + (MainGame.height/1.2)/25),
                        (int) ((MainGame.height/1.2) + (MainGame.height/1.2)/25 + (MainGame.height/1.2)/27.5),
                        (int) ((int) (MainGame.height/1.2) + (MainGame.height/1.2)/25)},
                3);


    }

    public static void drawMuteLine(Graphics2D g) {
        if (!MainGame.music_on) {
            g.setColor(Color.BLACK);
            g.drawLine(MainGame.width/45, (int) (MainGame.height/1.1), (int) (MainGame.width/17.5),
                    (int) (MainGame.height/1.26));
        }
    }

}
