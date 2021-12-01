package test;

import main.enumerations.ID;
import main.game_objects.BlankObject;
import main.others.Handler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Tests Handler using JUnit5
 */
public class TestHandler {

    Handler handler;

    @BeforeEach
    void init() {
        handler = new Handler();

        for (int i = 0; i < 100; i++) {
            handler.objects.add(new BlankObject(0,0, ID.BlankObject));
        }
    }

    @Test
    @DisplayName("Clears all game objects")
    void testClearObjects() {
        assertEquals(100, handler.objects.size());
        handler.clearObjects();
        assertEquals(0, handler.objects.size());
    }

    @Test
    @DisplayName("Adds a game object")
    void testAddObject() {
        handler.addObject(new BlankObject(0,0, ID.BlankObject));
        assertEquals(100 + 1, handler.objects.size());
    }

}
