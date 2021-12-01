package main.menus;

import main.MainGame;
import main.others.Window;
import main.enumerations.STATE;
import main.others.Handler;
import main.others.Spawner;
import main.music.MusicButton;
import main.music.MusicPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class EndGameMenu extends MouseAdapter {
    public MainGame maingame;
    public Handler handler;
    public Spawner spawner;

    public EndGameMenu(MainGame maingame, Handler handler,Spawner spawner) {
        this.maingame = maingame;
        this.handler = handler;
        this.spawner = spawner;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (maingame.state == STATE.EndGameMode) {

            // EndGameMenu mode - Music on/off symbol
            MusicButton.turnOnOffMusic_Pause_EndGame(mx, my);

            // Try again button
            if (MainGame.buttonSelected(mx, my, (int) (MainGame.width / 2.7), (int) (MainGame.height / 1.65),
                    (int) (MainGame.width / 3.85), (int) (MainGame.height / 10))) {
                spawner.setScore(-325);
                spawner.setSmartEnemyID(1);

                // hide cursor
                Window.frame.setCursor(Window.invisible_cursor);

                if (MainGame.music_on) {
                    // play gameplay music
                    try {
                        MusicPlayer.playMusic("gameplay_music.wav");
                    } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                        unsupportedAudioFileException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (LineUnavailableException lineUnavailableException) {
                        lineUnavailableException.printStackTrace();
                    }
                }

                maingame.state = STATE.GameMode;

            }

            // Exit button
            else if (MainGame.buttonSelected(mx, my, (int) (MainGame.width / 1.225), (int) (MainGame.height / 1.2),
                    (int) (MainGame.width / 6.25), MainGame.height / 14)) {
                spawner.setScore(-325);
                handler.clearObjects();
                MainMenu.menu_time = 0;

                if (MainGame.music_on) {
                    // play menu music
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

                maingame.state = STATE.MenuMode;

            }
        }
    }

    public void render(Graphics2D g) {
        // change background color
        g.setColor(new Color(232, 146, 146, 100));
        g.fillRect(0, 0, MainGame.width, MainGame.height);
        g.setColor(new Color(238,232,170, 245));
        g.fillRect(MainGame.width / 4, MainGame.height / 25, MainGame.width / 2,
                MainGame.height/7);
        g.setColor(Color.BLACK);
        g.setFont(MainMenu.font2);
        g.drawString("Game Over!", (float) ((float) MainGame.width / 2.8), (float)
                ((float) MainGame.height / 7.7));

        g.setFont(MainMenu.font3c);
        g.setColor(new Color(218,165,32));
        g.drawString("Your score: " + spawner.getScore(),(float) (MainGame.width / 3.25),
                (float) (MainGame.height/2.5));

        // try again button
        g.setColor(Color.BLACK);
        g.setFont(MainMenu.font2);
        g.setStroke(new BasicStroke(15));
        g.drawRoundRect((int) (MainGame.width / 2.7), (int) (MainGame.height / 1.65),
                (int) (MainGame.width / 3.85), (int) (MainGame.height / 10), 10,10);
        g.setColor(new Color(70, 224, 227));
        g.fillRoundRect((int) (MainGame.width / 2.7), (int) (MainGame.height / 1.65),
                (int) (MainGame.width / 3.85), (int) (MainGame.height / 10),10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Try again", (float) ((float) MainGame.width / 2.65),
                (float) ((float) MainGame.height / 1.475));

        // exit button
        g.setColor(Color.BLACK);
        g.setFont(MainMenu.font4);
        g.setStroke(new BasicStroke(10));
        g.drawRoundRect((int) (MainGame.width / 1.225), (int) (MainGame.height / 1.2),
                (int) (MainGame.width / 6.25), MainGame.height / 14,10, 10);
        g.setColor(new Color(232, 146, 146));
        g.fillRoundRect((int) (MainGame.width / 1.225), (int) (MainGame.height / 1.2),
                (int) (MainGame.width / 6.25), MainGame.height / 14,10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Exit", (float) ((float) MainGame.width / 1.1725), (float) (MainGame.height / 1.125));

        // music button
        MusicButton.drawMusicButton(g);
        MusicButton.drawMuteLine(g);
    }
}
