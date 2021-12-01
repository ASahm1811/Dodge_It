package main.user_input;

import main.MainGame;
import main.others.Window;
import main.enumerations.ID;
import main.enumerations.STATE;
import main.game_objects.BlankObject;
import main.game_objects.GameObject;
import main.others.Handler;
import main.others.Spawner;
import main.music.MusicPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class KeyInput extends KeyAdapter {

    private MainGame maingame;
    private Handler handler;
    public static ArrayList<ArrayList<Float>> speed_enemies = new ArrayList<>();
    public static float x_0 = 0;
    public static float y_0 = 0;

    public KeyInput(MainGame maingame, Handler handler) {
        this.maingame = maingame;
        this.handler = handler;
        speed_enemies.add(new ArrayList<>(Arrays.asList(x_0, y_0)));
    }



    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            MusicPlayer.stopMusic();
            System.exit(1);
        }

        if (key == KeyEvent.VK_M) {

            if (maingame.state == STATE.MenuMode || maingame.state == STATE.HowToPlayMode) {
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

            if (maingame.state == STATE.GameMode) {
                if (MainGame.music_on) {
                    MainGame.music_on = false;
                    // stop music
                    MusicPlayer.stopMusic();
                } else {
                    MainGame.music_on = true;
                    // play music
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
            }

            if (maingame.state == STATE.PauseMode || maingame.state == STATE.EndGameMode) {
                if (MainGame.music_on) {
                    MainGame.music_on = false;
                } else {
                    MainGame.music_on = true;

                }
            }
        }



        if (maingame.state == STATE.GameMode) {

            if (key == KeyEvent.VK_P && Spawner.score >= 0) {

                for (int i = 1; i < handler.objects.size(); i++) {
                    GameObject tempObject = handler.objects.get(i);
                    speed_enemies.add(new ArrayList<>(Arrays.asList(tempObject.getVelX(), tempObject.getVelY())));

                    tempObject.setVelX(0);
                    tempObject.setVelY(0);

                }
//                System.out.println(speed_enemies);
                handler.objects.set(0, new BlankObject(0, 0, ID.BlankObject));


                // show cursor
                Window.frame.setCursor(Cursor.getDefaultCursor());

                if (MainGame.music_on) {
                    // stop music
                    MusicPlayer.stopMusic();
                }

                maingame.state = STATE.PauseMode;
            }
        }

    }
}
