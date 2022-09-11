package main.menus;

import main.MainGame;
import main.enumerations.ID;
import main.enumerations.STATE;
import main.game_objects.BackGroundObject;
import main.music.MusicButton;
import main.music.MusicPlayer;
import main.others.Handler;
import main.others.SelectionColorBox;
import main.others.Spawner;
import main.others.Window;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;


public class MainMenu extends MouseAdapter {

    public MainGame maingame;
    public Handler handler;
    public Spawner spawner;
    public static int menu_time = 0;
    private final Random r = new Random();
    public static Color chosen_color = Color.WHITE;
    public static boolean[] checked_color = new boolean[] {true, false, false, false, false, false, false,
            false, false, false};

    // title font
    public static Font font = new Font("Ravie", Font.BOLD, (int) MainGame.height/10);
    // smaller title font
    public static Font font2 = new Font("Ravie", Font.PLAIN, (int) MainGame.height/15);
    // smallest title
    public static Font font3 = new Font("Monaco", Font.BOLD, (int) ( MainGame.height/31));
    // big notifier
    public static Font font3a = new Font("Monaco", Font.BOLD, (int) ( MainGame.height/10));
    // small description
    public static Font font3b = new Font("Monaco", Font.BOLD, (int) ( MainGame.height/40));
    // for countdown
    public static Font font3c = new Font("Monaco", Font.BOLD, (int) ( MainGame.height/15));
    // back
    public static Font font4 = new Font("Ravie", Font.PLAIN, (int) MainGame.height/20);

    public MainMenu(MainGame maingame, Handler handler, Spawner spawner) {
        this.maingame = maingame;
        this.handler = handler;
        this.spawner = spawner;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();


        // If in menu:
        if (maingame.state == STATE.MenuMode) {

            // Play button
            if (MainGame.buttonSelected(mx, my, (int) MainGame.width / 3, (int) (MainGame.height / 4.5),
                    (MainGame.width / 3), (MainGame.height / 8))) {

                handler.clearObjects();
                spawner.setSmartEnemyID(1);

                // hide cursor
                Window.frame.setCursor(Window.invisible_cursor);

                // stop music
                MusicPlayer.stopMusic();
                if (MainGame.music_on) {

                    // play gameplay music
                    try {
                        MusicPlayer.playMusic("gameplay_music.wav");
                    } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                        unsupportedAudioFileException.printStackTrace();
                    } catch (LineUnavailableException lineUnavailableException) {
                        lineUnavailableException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                maingame.state = STATE.GameMode;

            }
            // How To Play button
            if (MainGame.buttonSelected(mx, my, (int) (MainGame.width / 3), (int) ((MainGame.height / 4.5) +
                            (MainGame.height / 5)), (MainGame.width / 3), (MainGame.height / 8))) {
                // show cursor
                Window.frame.setCursor(Cursor.getDefaultCursor());
                maingame.state = STATE.HowToPlayMode;
            }

            // Quit button
            if (MainGame.buttonSelected(mx, my, (int) (MainGame.width / 3), (int) ((MainGame.height / 4.5) +
                    (MainGame.height / 5) + (MainGame.height / 5)), (MainGame.width / 3), (MainGame.height / 8))) {
                if (MainGame.music_on) {
                    // stop music
                    MusicPlayer.stopMusic();
                }
                System.exit(1);
            }

            // MainMenu mode - Music on/off symbol
            MusicButton.turnOnOffMusic(mx, my);

            // button selection colors for player
            SelectionColorBox.selectColor(mx, my);

            }


        }

    public void tick() {
        menu_time++;

        if (menu_time == 1) {
            // add background objects
            for (int i = 0; i < 50; i++) {
                handler.addObject(new BackGroundObject(r.nextInt(MainGame.width - 50),
                        r.nextInt(MainGame.height - 50), ID.BackGroundObject));
            }
        }

    }

    /*
        Render menu
     */
    public void render(Graphics2D g) {
        g.setStroke(new BasicStroke(15));
        g.setColor(new Color(238,232,170, 245));
        // Title
        g.fillRect(MainGame.width / 4, MainGame.height / 25, MainGame.width / 2,
                MainGame.height/7);
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Dodge It!",  (float) MainGame.width / 3, (float) MainGame.height / 7);

        // Play button
        g.setColor(Color.BLACK);
        g.drawRoundRect((int) (MainGame.width / 3), (int) (MainGame.height / 4.5), (MainGame.width / 3),
                (MainGame.height / 8), 10, 10);
        g.setColor(new Color(70, 224, 227));
        g.fillRoundRect((int) (MainGame.width / 3), (int) (MainGame.height / 4.5), (MainGame.width / 3),
                (MainGame.height / 8), 10, 10);
        g.setColor(Color.BLACK);
        g.setFont(font2);
        g.drawString("Play", (float) ((float) MainGame.width / 2.25), (float) (MainGame.height / 3.25));

        // How to play button
        g.drawRoundRect((int) (MainGame.width / 3), (int) ((MainGame.height / 4.5) + (MainGame.height / 5)),
                (MainGame.width / 3), (MainGame.height / 8), 10,10);
        g.setColor(new Color(156, 240, 168));
        g.fillRoundRect((int) (MainGame.width / 3), (int) (MainGame.height / 4.5) + (MainGame.height / 5),
                (MainGame.width / 3), (MainGame.height / 8), 10, 10);
        g.setColor(Color.BLACK);
        g.setFont(font2);
        g.drawString("How To Play", (float) (MainGame.width / 2.85), (float) ((MainGame.height / 3.25) +
                            (MainGame.height / 5)));

        // Quit button
        g.drawRoundRect((int) (MainGame.width / 3), (int) ((MainGame.height / 4.5) + (MainGame.height / 5)
                        + (MainGame.height / 5)), (MainGame.width / 3), (MainGame.height / 8), 10,
                10);
        g.setColor(new Color(232, 146, 146));
        g.fillRoundRect((int) (MainGame.width / 3), (int) (MainGame.height / 4.5) + (MainGame.height / 5) +
                        (MainGame.height / 5), (MainGame.width / 3), (MainGame.height / 8),
                10, 10);
        g.setColor(Color.BLACK);
        g.setFont(font2);
        g.drawString("Quit", (float) ((float) MainGame.width / 2.25), (float) ((MainGame.height / 3.25) +
                (MainGame.height / 5) + (MainGame.height / 5)));

        // Music button
        MusicButton.drawMusicButton(g);
        MusicButton.drawMuteLine(g);
        g.setFont(font3b);
        g.drawString("Press the speaker icon or         to turn the music on/off",
                (float) MainGame.width/70, (float) (MainGame.height/1.065));

        g.fillRoundRect((int) (MainGame.width/5.125), (int) (MainGame.height/1.1), 25, 25, 10,
                10);
        g.setColor(Color.WHITE);
        g.drawString("M", (int) (MainGame.width/5.025), (int) (MainGame.height/1.07));

        // Selection color box
        SelectionColorBox.drawSelectionBox(g);
        SelectionColorBox.drawCheckedSymbol(g);

    }

}
