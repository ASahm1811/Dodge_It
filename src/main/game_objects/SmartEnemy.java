package main.game_objects;

import main.others.Handler;
import main.enumerations.ID;
import main.MainGame;
import main.enumerations.STATE;

import java.awt.*;

public class SmartEnemy extends GameObject {
    private int spawn_time = 0;
    private Handler handler;
    private GameObject player;
    private MainGame maingame;

    public SmartEnemy(int x, int y, ID id, String object_id, Handler handler, MainGame maingame) {
        super(x, y, id);
        this.maingame = maingame;
        this.object_id = object_id;
        this.handler = handler;

    }



    @Override
    public void tick() {
        spawn_time++;

        for (int i = 0; i < handler.objects.size(); i++) {
            if (handler.objects.get(i).getId() == ID.Player) {
                player = handler.objects.get(i);
            }
        }


        // start moving after 100 time units
        if (spawn_time >= 100) {


            float diffX = x - player.getX();
            float diffY = y - player.getY();
            float distance = (float) Math.sqrt(Math.pow(diffX, 2) +
                    Math.pow(diffY, 2));
            if (maingame.state == STATE.PauseMode) {
                velX = 0;
                velY = 0;
            }
            else {
                // if the player is too close, increase velocity
                if (getAreaBounds().intersects(player.getBounds())) {
                    velX = (float) ((-1.0 / distance) * diffX) * 3f;
                    velY = (float) ((-1.0 / distance) * diffY) * 3f;
                } else {
                    velX = (float) ((-1.0 / distance) * diffX) * 1.5f;
                    velY = (float) ((-1.0 / distance) * diffY) * 1.5f;
                }
            }

            for (int i = 0; i < handler.objects.size(); i++) {
                GameObject tempObject = handler.objects.get(i);

                if (tempObject.getId() == ID.SmartEnemy && tempObject.getColor().equals(Color.ORANGE) &&
                        !(tempObject.getObjectID().equals(object_id))) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        handler.objects.set(i, new BlankObject(0, 0, ID.BlankObject));

                    }

                }
            }

            if (x <= 0 || x >= MainGame.width/1.025) {
                velX *= -1;
            }
            if (y <= 0 || y >= MainGame.height/1.085) {
                velY *= -1;
            }

            // Move smart enemy
            x += velX;
            y += velY;

        }
    }


    @Override
    public void render(Graphics2D g) {
        color = new Color(252, 218, 144);
        g.setColor(color);
        g.fillRect((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40));

        if (spawn_time >= 100) {
            color = Color.ORANGE;
            g.setColor(color);
            g.fillRect((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40));
//            g.drawSymbol(getAreaBounds());
        }
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, MainGame.width/70, (int) (MainGame.height/40)) {
        };
    }


    public Rectangle getAreaBounds() {
        return new Rectangle((int) ((int) x-(MainGame.width/4.7)/2.2), (int) ((int) y-(MainGame.height/2.7)/2.25),
                (int) (MainGame.width/4.7), (int) (MainGame.height/2.7)) {
        };
    }
}
