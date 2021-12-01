package main.game_objects;

import main.enumerations.ID;

import java.awt.*;

public class BlankObject extends GameObject {


    public BlankObject(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

}

