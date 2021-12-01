package main.others;

import main.MainGame;

import javax.swing.*;
import java.awt.*;


public class Window extends Canvas {

    public static JFrame frame;
    private static final byte[] imageByte=new byte[0];
    private static final Point myPoint = new Point(0,0);
    private static final Image cursorImage = Toolkit.getDefaultToolkit().createImage(imageByte);
    public static Cursor invisible_cursor = Toolkit.getDefaultToolkit()
            .createCustomCursor(cursorImage,myPoint,"inv_cursor");

    public Window(int width, int height, String name, MainGame game) {
        frame = new JFrame(name);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.startThread();
    }
}
