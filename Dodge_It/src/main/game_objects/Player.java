package main.game_objects;

import main.others.Handler;
import main.MainGame;
import main.others.Window;
import main.enumerations.ID;
import main.enumerations.STATE;
import main.music.MusicPlayer;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Player extends GameObject {

    private MainGame maingame;
    private Handler handler;
    private final Random r = new Random();

    public Player(float x, float y, ID id, Handler handler, MainGame maingame) {
        super(x, y, id);
        this.handler = handler;
        this.maingame = maingame;
    }


    @Override
    public void tick() {
        x = MainGame.clamp(x, 0, (float) (MainGame.width/1.054));
        y = MainGame.clamp(y, 0, (float) (MainGame.height/1.1375));

        collision();
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if ((tempObject.getId() == ID.Enemy && tempObject.getColor().equals(Color.RED)) ||
                    (tempObject.getId() == ID.SmartEnemy && tempObject.getColor().equals(Color.ORANGE))) {
                if (getCBounds().intersects(tempObject.getBounds())) {
                    handler.clearObjects();

                    // show cursor
                    Window.frame.setCursor(Cursor.getDefaultCursor());

                    if (MainGame.music_on) {
                        // stop music
                        MusicPlayer.stopMusic();
                    }

                    maingame.state = STATE.EndGameMode;
                }
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int) x, (int) y, MainGame.width/26, (int) (MainGame.height/15));

        double thickness = 3;
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke((float) thickness));
        g.drawOval((int) x, (int) y, MainGame.width/26, (int) (MainGame.height/15));

        }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) (MainGame.width/26f), (int) (MainGame.height/15));
    }

    public Ellipse2D.Double getCBounds() {
        return new Ellipse2D.Double((int) x, (int) y, MainGame.width/26f, (int) (MainGame.height/15)) {
        };
    }
}
