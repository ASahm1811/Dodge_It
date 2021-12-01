package main.game_objects;

import main.enumerations.ID;
import main.MainGame;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {
    private int time = 0;
    private final Random r = new Random();
    public final static float[] direction = new float[] {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5};

    public Enemy(int x, int y, ID id) {
        super(x, y, id);

        velX = direction[r.nextInt(direction.length)];
        velY = direction[r.nextInt(direction.length)];
    }

    @Override
    public void tick() {
        time++;

        // start moving after 100 time units
        if (time >= 100) {
            // Move enemy
            x += velX;
            y += velY;

            if (x <= 0 || x >= MainGame.width/1.025) {
                velX *= -1;
            }
            if (y <= 0 || y >= MainGame.height/1.085) {
                velY *= -1;
            }
        }


    }

    @Override
    public void render(Graphics2D g) {
        color = new Color(255, 204, 204);
        g.setColor(color);
        g.fillRect((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40));

        if (time >= 100) {
            color = Color.RED;
            g.setColor(color);
            g.fillRect((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40));
        }


    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40));
    }

}
