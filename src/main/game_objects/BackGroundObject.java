package main.game_objects;

import main.enumerations.ID;
import main.MainGame;

import java.awt.*;
import java.util.Random;

public class BackGroundObject extends GameObject {
    private final Random r = new Random();
    private final static float[] direction = new float[] {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5};
    private final String[] colors = new String[] {"b", "r", "y", "g", "o", "c", "m", "p"};


    public BackGroundObject(int x, int y, ID id) {
        super(x, y, id);

        velX = direction[r.nextInt(direction.length)];
        velY = direction[r.nextInt(direction.length)];
        String color_chosen = colors[r.nextInt(colors.length)];

        if (color_chosen.equals("b")) {
            color = Color.BLUE;
        }

        if (color_chosen.equals("r")) {
            color = Color.RED;
        }

        if (color_chosen.equals("y")) {
            color = Color.YELLOW;
        }

        if (color_chosen.equals("g")) {
            color = Color.GREEN;
        }

        if (color_chosen.equals("o")) {
            color = Color.ORANGE;
        }

        if (color_chosen.equals("c")) {
            color = Color.CYAN;
        }

        if (color_chosen.equals("m")) {
            color = Color.MAGENTA;
        }

        if (color_chosen.equals("p")) {
            color = Color.PINK;
        }
    }

    @Override
    public void tick() {
        // Move background object
        x += velX;
        y += velY;


        if (x <= 0 || x >= MainGame.width/1.025) {
            velX *= -1;
        }
        if (y <= 0 || y >= MainGame.height/1.085) {
            velY *= -1;
        }

    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(color);
        g.fillRect((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40));

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40));
    }

}
