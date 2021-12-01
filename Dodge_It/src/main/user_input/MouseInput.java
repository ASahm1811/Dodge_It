package main.user_input;

import main.others.Handler;
import main.enumerations.ID;
import main.MainGame;
import main.game_objects.GameObject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private MainGame maingame;
    private Handler handler;

    public MouseInput(MainGame maingame, Handler handler) {
        this.maingame = maingame;
        this.handler = handler;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point p = e.getPoint();
        int x = (int) p.getX();
        int y = (int) p.getY();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            // Make Player object follow mouse input
            if (tempObject.getId() == ID.Player) {
                tempObject.setX(x-(MainGame.width/26f)/2.2f);
                tempObject.setY(y-(MainGame.height/15f)/2.2f);

            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = e.getPoint();
        int x = (int) p.getX();
        int y = (int) p.getY();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            // Make Player object follow mouse input
            if (tempObject.getId() == ID.Player) {
                tempObject.setX(x-(MainGame.width/26f)/2.2f);
                tempObject.setY(y-(MainGame.height/15f)/2.2f);

            }
        }

    }

}
