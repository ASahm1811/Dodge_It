package test;

import main.MainGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Tests MainGame class using JUnit5
 */
public class TestMainGame {

    @Test
    @DisplayName("Clamps the number between min and max")
    void testClamp() {
        float var = 10.5f;
        float min = 10.55f;
        float max = 10.49f;
        assertEquals(var, MainGame.clamp(var, 10f, 11.3f));
        assertEquals(min, MainGame.clamp(var, min, 11.3f));
        assertEquals(max, MainGame.clamp(var, 10f, max));
    }

    @Test
    @DisplayName("Button is selected")
    void testButtonSelected() {
        assertTrue(MainGame.buttonSelected(2,2,1,1, MainGame.width, MainGame.height));
    }

    @Test
    @DisplayName("Button is not selected")
    void testButtonNotSelected() {
        assertFalse(MainGame.buttonSelected(0,0,1,1, MainGame.width, MainGame.height));
    }
}
