package main.others;

import main.game_objects.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    // List of objects in game
    public LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (GameObject tempObject : objects) {
            tempObject.tick();

        }
    }

    public void render(Graphics2D g) {
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    public void clearObjects() {

        this.objects.clear();
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

}
