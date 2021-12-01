package test;

import main.MainGame;
import main.music.MusicButton;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    Tests the music button using JUnit5
 */
public class TestMusicButton {

    @Test
    @DisplayName("Music button selected main menu")
    void testTurnOnOffMusic() {
        // not turned off
        MusicButton.turnOnOffMusic(MainGame.width/60 - 1, (int) (MainGame.height/1.25) - 1);
        assertTrue(MainGame.music_on);
        // turned off
        MusicButton.turnOnOffMusic(MainGame.width/60 + 1, (int) (MainGame.height/1.25) + 1);
        assertFalse(MainGame.music_on);
        // not turned on
        MusicButton.turnOnOffMusic(MainGame.width/60 - 1, (int) (MainGame.height/1.25) - 1);
        assertFalse(MainGame.music_on);
        // turned on
        MusicButton.turnOnOffMusic(MainGame.width/60 + 1, (int) (MainGame.height/1.25) + 1);
        assertTrue(MainGame.music_on);
    }

    @Test
    @DisplayName("Music button selected pause/endgame menu")
    void testTurnOnOffMusic_Pause_EndGame() {
        // not turned off
        MusicButton.turnOnOffMusic_Pause_EndGame(MainGame.width/60 - 1, (int) (MainGame.height/1.25) - 1);
        assertTrue(MainGame.music_on);
        // turned off
        MusicButton.turnOnOffMusic_Pause_EndGame(MainGame.width/60 + 1, (int) (MainGame.height/1.25) + 1);
        assertFalse(MainGame.music_on);
        // not turned on
        MusicButton.turnOnOffMusic_Pause_EndGame(MainGame.width/60 - 1, (int) (MainGame.height/1.25) - 1);
        assertFalse(MainGame.music_on);
        // turned on
        MusicButton.turnOnOffMusic_Pause_EndGame(MainGame.width/60 + 1, (int) (MainGame.height/1.25) + 1);
        assertTrue(MainGame.music_on);
    }
}
