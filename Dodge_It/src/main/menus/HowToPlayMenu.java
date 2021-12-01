package main.menus;

import main.MainGame;
import main.enumerations.STATE;
import main.music.MusicButton;
import main.others.Mice;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HowToPlayMenu extends MouseAdapter {
    public MainGame maingame;
    public HowToPlayMenu(MainGame maingame) {
        this.maingame = maingame;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (maingame.state == STATE.HowToPlayMode) {
            // Back button for How To Play screen
            if (MainGame.buttonSelected(mx, my, (int) (MainGame.width / 2.4), (int) (MainGame.height / 1.2),
                    (int) (MainGame.width / 6.25), MainGame.height / 14)) {
                maingame.state = STATE.MenuMode;
            }

            // MainMenu mode - Music on/off symbol
            MusicButton.turnOnOffMusic(mx, my);
        }
    }



    public void render(Graphics2D g) {
        g.setColor(new Color(238,232,170, 245));
        g.fillRect(MainGame.width / 4, MainGame.height / 25, MainGame.width / 2,
                MainGame.height/7);
        g.setColor(Color.BLACK);
        g.setFont(MainMenu.font2);
        g.drawString("How To Play", (float) MainGame.width / 3, (float) MainGame.height / 7);
        g.setColor(new Color(255, 255, 255, 245));
        g.fillRoundRect((int) (MainGame.width / 8), (int) (MainGame.height / 4.5), (int) (MainGame.width / 1.35),
                (int) (MainGame.height / 1.75), 10, 10);

        g.setColor(Color.BLACK);
        g.setFont(MainMenu.font3);
        g.drawString("Move your mouse to move your player and dodge the enemies as long as possible!",
                (float) (MainGame.width / 7), (float) (MainGame.height / 3.5));

        // mouse symbol
        Mice.drawSymbol(g);
        Mice.drawArrows(g);

        g.setFont(MainMenu.font3b);
        g.setColor(Color.RED);
        g.fillRect((int) (MainGame.width / 2.05), (int) (MainGame.height / 2.65),
                50, 50);
        g.drawString("red",
                (float) (MainGame.width / 2.325),  (float) (MainGame.height / 2.05));
        g.setColor(Color.BLACK);
        g.drawString("The        enemies go into a random direction.",
                (float) (MainGame.width / 2.5),  (float) (MainGame.height / 2.05));

        g.setColor(Color.ORANGE);
        g.fillRect((int) (MainGame.width / 1.75), (int) (MainGame.height / 1.75),
                50, 50);
        g.drawString("orange", (float) (MainGame.width / 2.55), (float) (MainGame.height / 1.475));
        g.setColor(Color.BLACK);
        g.drawString("The              enemies follow you, but if two happens to collide with each",
                (float) (MainGame.width / 2.75), (float) (MainGame.height / 1.475));
        g.drawString("other, then one of them disappears.", (float) (MainGame.width / 2.75),
                (float) (MainGame.height / 1.415));

        // Music button
        MusicButton.drawMusicButton(g);
        MusicButton.drawMuteLine(g);

        // back button
        g.setColor(Color.BLACK);
        g.setFont(MainMenu.font4);
        g.setStroke(new BasicStroke(10));
        g.drawRoundRect((int) (MainGame.width / 2.4), (int) (MainGame.height / 1.2), (int) (MainGame.width / 6.25),
                MainGame.height / 14,10, 10);
        g.setColor(new Color(232, 146, 146));
        g.fillRoundRect((int) (MainGame.width / 2.4), (int) (MainGame.height / 1.2), (int) (MainGame.width / 6.25),
                MainGame.height / 14,10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Back", (float) ((float) MainGame.width / 2.22), (float) (MainGame.height / 1.125));
    }
}
