package main.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    static Clip clip;

    static {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playMusic(String music_name) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
            // music file path
            File musicPath = new File("Res/" + music_name);
            AudioInputStream musicInput = AudioSystem.getAudioInputStream(musicPath);
            clip.open(musicInput);
            clip.start();
            // loop infinitely
            clip.loop(-1);
    }


    public static void stopMusic()  {
        try {
            clip.stop();
            clip.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}