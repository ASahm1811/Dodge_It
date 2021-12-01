package test;

import main.MainGame;
import main.enumerations.ID;
import main.game_objects.*;
import main.others.Handler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
    Tests game objects using JUnit5
 */
public class TestGameObjects {

    Player player;
    BackGroundObject backGroundObject;
    BlankObject blankObject;
    Enemy enemy;
    SmartEnemy smartEnemy;
    Handler handler = new Handler();
    MainGame mainGame;

    {
        try {
            mainGame = new MainGame();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeEach
    void init() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        player = new Player(0, 0, ID.Player, handler, mainGame);
        backGroundObject = new BackGroundObject(0,0, ID.BackGroundObject);
        blankObject = new BlankObject(0,0,ID.BlankObject);
        enemy = new Enemy(0,0, ID.Enemy);
        smartEnemy = new SmartEnemy(0,0, ID.SmartEnemy, "SE_1", handler, mainGame);
    }

    @Test
    @DisplayName("Creates Rectangle/Ellipse2D bounded shape for each game object")
    void testGetBounds() {
        // Player
        assertEquals(new Rectangle((int) player.getX(), (int) player.getY(), (int) (MainGame.width/26f),
                        (int) (MainGame.height/15)), player.getBounds());
        assertEquals(new Ellipse2D.Double(player.getX(), player.getY(), MainGame.width/26f,
                (int) (MainGame.height/15)), player.getCBounds());
        // Background object
        assertEquals(new Rectangle((int) backGroundObject.getX(), (int) backGroundObject.getY(),
                (int) MainGame.width/70, (int) (MainGame.height/40)), backGroundObject.getBounds());
        // Blank object
        assertNull(blankObject.getBounds());
        // Enemy object
        assertEquals(new Rectangle((int) enemy.getX(), (int) enemy.getY(),
                (int) MainGame.width/70, (int) (MainGame.height/40)), enemy.getBounds());
        // Smart enemy object
        assertEquals(new Rectangle((int) smartEnemy.getX(), (int) smartEnemy.getY(),
                (int) MainGame.width/70, (int) (MainGame.height/40)), smartEnemy.getBounds());
        assertEquals(new Rectangle((int) ((int) smartEnemy.getX() - (MainGame.width/4.7)/2.2),
                (int) ((int) smartEnemy.getY() - (MainGame.height/2.7)/2.25),
                (int) (MainGame.width/4.7), (int) (MainGame.height/2.7)), smartEnemy.getAreaBounds());
    }



}
