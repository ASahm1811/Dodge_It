package main.others;

import main.MainGame;
import main.menus.MainMenu;

import java.awt.*;

public class HUD {

    public void render(Graphics2D g) {
        // draw countdown
        if (Spawner.score < 0) {
            g.setFont(MainMenu.font3a);
            g.setColor(Color.BLACK);
            if (-300 <= Spawner.score && Spawner.score <= -225) {
                g.setColor(new Color(252, 54, 54));
                g.drawString("3", (float) (MainGame.width/2.1), (float) (MainGame.height/2.25));
            }
            else if (-225 <= Spawner.score && Spawner.score <= -150) {
                g.setColor(new Color(59, 241, 85));
                g.drawString("2", (float) (MainGame.width/2.1), (float) (MainGame.height/2.25));
            }
            else if (-150 <= Spawner.score && Spawner.score <= -75) {
                g.setColor(new Color(25, 219, 224));
                g.drawString("1", (float) (MainGame.width/2.1), (float) (MainGame.height/2.25));
            }

            else if (-75 <= Spawner.score && Spawner.score <= -25) {
                g.setColor(new Color(218,165,32));
                g.drawString("Start!", (float) (MainGame.width/2.35), (float) (MainGame.height/2.25));
            }
            g.setFont(MainMenu.font3);
            // Draw HUD
            g.setColor(new Color(218,165,32));
            g.drawString("Score: 0", (float) (MainGame.width/1.25), (float) (MainGame.height/20));
        }
        else {
            g.setFont(MainMenu.font3);
            // Draw main.others.HUD
            g.setColor(new Color(218,165,32));
            g.drawString("Score: " + Spawner.score, (float) (MainGame.width/1.25), (float) (MainGame.height/20));

            // PauseMenu notifier
            g.setColor(Color.BLACK);
            g.drawString("Press        to pause the game" , (float) (MainGame.width/70),
                    (float) (MainGame.height/20));

            g.fillRoundRect((int) (MainGame.width/14.125), (MainGame.height/55), 30, 30, 10,
                    10);
            g.setColor(Color.WHITE);
            g.drawString("P", (int) (MainGame.width/13.125), (MainGame.height/20));
        }
    }

}
