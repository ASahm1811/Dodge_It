package main.others;

import main.MainGame;
import main.menus.MainMenu;

import java.awt.*;
import java.awt.geom.Line2D;

public class SelectionColorBox {
    static int x = (int) (MainGame.width / 1.45);
    static int y = MainGame.height / 3;
    static int width = (int) (MainGame.width / 3.5);
    static int height = (int) (MainGame.height / 1.75);

    static String[] colors = new String[] {"w", "b", "r", "y", "g", "o",
            "c", "m", "p", "dg"};


    public static void selectColor(int mx, int my) {
        int d = 8;
        double div = 1.9;
        for (int c = 0; c < MainMenu.checked_color.length; c++) {
            if (c == 5) {
                // second row colors
                d = 8;
                div = 1.35;
            }
            if (MainGame.buttonSelected(mx, my, x + d, (int) (y +  (height/div)),
                    width /6, (int) (height/6.5))) {

                for (int i = 0; i < MainMenu.checked_color.length; i++) {
                    if (i == c) {
                        MainMenu.checked_color[i] = true;
                    }
                    else {
                        MainMenu.checked_color[i] = false;
                    }
                }
                if (c == 0) {
                    MainMenu.chosen_color = Color.WHITE;
                }

                if (c == 1) {
                    MainMenu.chosen_color = Color.BLUE;
                }

                if (c == 2) {
                    MainMenu.chosen_color = Color.RED;
                }

                if (c == 3) {
                    MainMenu.chosen_color = Color.YELLOW;
                }

                if (c == 4) {
                    MainMenu.chosen_color = Color.GREEN;
                }

                if (c == 5) {
                    MainMenu.chosen_color = Color.ORANGE;
                }

                if (c == 6) {
                    MainMenu.chosen_color = Color.CYAN;
                }

                if (c == 7) {
                    MainMenu.chosen_color = Color.MAGENTA;
                }

                if (c == 8) {
                    MainMenu.chosen_color = Color.PINK;
                }

                if (c == 9) {
                    MainMenu.chosen_color = Color.DARK_GRAY;
                }

            }
            d+=width/5.05;
        }
    }


    public static void drawSelectionBox(Graphics2D g) {

        // Colorbox
        g.setColor(new Color(238,232,170, 245));
        g.fillRoundRect(x, y, width, height, 10,
                10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, width, height, 10,
                10);

        g.setColor(MainMenu.chosen_color);
        g.fillOval((int) (x + width/3.5), y + height/30, (int) (width/2.5), (int) (height/3));
        g.setColor(Color.BLACK);
        double thickness = 3;
        g.setStroke(new BasicStroke((float) thickness));
        g.drawOval((int) (x + width/3.5), y + height/30,(int) (width/2.5), (int) (height/3));

        // choose color
        g.setFont(MainMenu.font3);
        g.drawString("Choose your color:", (x + width/4), (int) (y + height/2.25));
        int d = 8;
        double div = 1.9;
        for (int i = 0; i < 10; i++) {

            // second row
            if (i == 5) {
                d = 8;
                div = 1.35;
            }

            if (colors[i].equals("w")) {
                g.setColor(Color.WHITE);
            }
            if (colors[i].equals("b")) {
                g.setColor(Color.BLUE);
            }
            if (colors[i].equals("r")) {
                g.setColor(Color.RED);
            }
            if (colors[i].equals("y")) {
                g.setColor(Color.YELLOW);
            }
            if (colors[i].equals("g")) {
                g.setColor(Color.GREEN);
            }
            if (colors[i].equals("o")) {
                g.setColor(Color.ORANGE);
            }
            if (colors[i].equals("c")) {
                g.setColor(Color.CYAN);
            }
            if (colors[i].equals("m")) {
                g.setColor(Color.MAGENTA);
            }
            if (colors[i].equals("p")) {
                g.setColor(Color.PINK);
            }
            if (colors[i].equals("dg")) {
                g.setColor(Color.DARK_GRAY);
            }
            g.fillRoundRect(x + d, (int) (y + height/div), width/6, (int) (height/6.5), 2,
                    2);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x + d, (int) (y +  height/div), width/6, (int) (height/6.5), 2,
                    2);

            d += width/5.05;

        }

    }

    public static void drawCheckedSymbol(Graphics2D g) {
        // check symbol for chosen color
        double d = 0;
        double div = 1.9;
        for (int i = 0; i < MainMenu.checked_color.length; i++) {
            if (i == 5) {
                d = 0;
                div = 1.35;
            }
            if (MainMenu.checked_color[i]) {
                g.draw(new Line2D.Double((x + 4) + 12.5 + d,
                        (y + SelectionColorBox.height / div) + 32.5,
                        (x + 4) + 25 + d, (y + height / div) + 45));
                g.draw(new Line2D.Double((x + 4) + 25 + d, (y +
                        height / div) + 45, (x + 4) + 55 + d,
                        (y + height / div) + 15));
            }
            d += width / 5.05;
        }
    }
}
