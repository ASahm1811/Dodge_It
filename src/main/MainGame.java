package main;

import main.enumerations.STATE;
import main.menus.EndGameMenu;
import main.menus.HowToPlayMenu;
import main.menus.MainMenu;
import main.menus.PauseMenu;
import main.music.MusicPlayer;
import main.others.HUD;
import main.others.Handler;
import main.others.Spawner;
import main.others.Window;
import main.user_input.KeyInput;
import main.user_input.MouseInput;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;


public class MainGame extends Canvas implements Runnable {

    private Window window;
    private Handler handler;
    private Spawner spawner;
    private HUD hud;
    private MainMenu mainMenu;
    private HowToPlayMenu howtoplayMenu;
    private PauseMenu pauseMenu;
    private EndGameMenu endgameMenu;

    // get window size
    private final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public final static int width = (int) ((int) screenSize.getWidth()/1.5);
    public final static int height = (int) ((int) screenSize.getHeight()/1.5);

    private Graphics2D g;

    private Thread thread;
    private boolean running = false;

    public STATE state = STATE.MenuMode;
    public static boolean music_on = true;

    public MainGame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        handler = new Handler();
        spawner = new Spawner(this, handler);
        hud = new HUD();
        mainMenu = new MainMenu(this, handler, spawner);
        howtoplayMenu = new HowToPlayMenu(this);
        pauseMenu = new PauseMenu(this, handler, spawner);
        endgameMenu = new EndGameMenu(this, handler, spawner);
        window = new main.others.Window(width, height, "Dodge It!", this);

        this.addMouseMotionListener(new MouseInput(this, handler));
        this.addKeyListener(new KeyInput(this, handler));
        this.addMouseListener(mainMenu);
        this.addMouseMotionListener(mainMenu);
        this.addMouseListener(howtoplayMenu);
        this.addMouseListener(pauseMenu);
        this.addMouseListener(endgameMenu);

        // start playing mainMenu music when launching game
        MusicPlayer.playMusic("menu_music.wav");
        System.out.println("Resolution: " + screenSize.width + "x" + screenSize.height);


    }

    public static void main(String[] a) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        new MainGame();
    }

    public synchronized void startThread() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stopThread() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountofTicks = 60.0;
        double ns = 1000000000/amountofTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;

            while (delta >= 1) {
                try {
                    tick();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
//                // state
//                System.out.println(state);
                frames = 0;
            }
        }
        stopThread();
    }

    private void tick() throws InterruptedException {
        handler.tick();

        if (state == STATE.GameMode) {
            spawner.tick();

        }
        else if (state == STATE.MenuMode) {
            mainMenu.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        g = (Graphics2D) bs.getDrawGraphics();

        // Background color
        g.setColor(new Color(196, 252, 255));
        g.fillRect(0, 0, width, height);

        handler.render(g);

        if (state == STATE.GameMode) {
            hud.render(g);
        }
        else if (state == STATE.MenuMode) {
            mainMenu.render(g);
        }
        else if (state == STATE.HowToPlayMode) {
            howtoplayMenu.render(g);
        }
        else if (state == STATE.PauseMode) {
            pauseMenu.render(g);
        }
        else if (state == STATE.EndGameMode) {
            endgameMenu.render(g);
        }

        g.dispose();
        bs.show();
    }


    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            var = max;
        }
        else if (var <= min) {
            var = min;
        }
        else {
            return var;
        }
        return var;
    }

    /*
        Button selection
     */
    public static boolean buttonSelected(int mx, int my, int x, int y, int width, int height) {
        return mx > x && mx < x + width && my > y && my < y + height;
    }
}
