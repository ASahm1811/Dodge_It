package main.others;

import main.MainGame;

import java.awt.*;

public class Mice {

    public static void drawSymbol(Graphics2D g) {
        g.setStroke(new BasicStroke(4));
        g.setColor(new Color(238,232,170));
        g.fillArc((int) (MainGame.width / 4.5), (int) (MainGame.height / 2.35), MainGame.width / 11,
                MainGame.height / 7,0,180);
        g.setColor(Color.BLACK);
        g.drawArc((int) (MainGame.width / 4.5), (int) (MainGame.height / 2.35), MainGame.width / 11,
                MainGame.height / 7,0,180);
        g.drawLine((int) (MainGame.width / 4.5), (int) (MainGame.height / 2.025),
                (int) (MainGame.width / 4.5) + MainGame.width / 11, (int) (MainGame.height / 2.025));
        g.fillRoundRect((int) ((int) (MainGame.width / 4.5) + (MainGame.width / 11) /2.2),
                (int) (MainGame.height / 2.35) + (MainGame.height / 7)/7,
                (int) (MainGame.width / 100), (int) (MainGame.height / 25), 10,10);
        g.drawLine((int) (MainGame.width / 4.5)+ ((MainGame.width / 11) /2), (int) (MainGame.height / 2.025),
                (int) (MainGame.width / 4.5)+ ((MainGame.width / 11) /2) , (int) (MainGame.height / 2.35));

        g.setColor(new Color(238,232,170));
        g.fillRect( (int) (MainGame.width / 4.5), (int) (MainGame.height / 2.015),
                MainGame.width / 11, (int) ((int) (MainGame.height / 1.7) - (MainGame.height / 2)));
        g.setColor(Color.BLACK);
        // two vertical lines
        g.drawLine((int) (MainGame.width / 4.5), (int) (MainGame.height / 2),
                (int) (MainGame.width / 4.5), (int) (MainGame.height / 1.7));
        g.drawLine((int) (MainGame.width / 4.5) + MainGame.width / 11, (int) (MainGame.height / 2),
                (int) (MainGame.width / 4.5) + MainGame.width / 11, (int) (MainGame.height / 1.7));

        g.setColor(new Color(238,232,170));
        g.fillArc((int) (MainGame.width / 4.5), (int) (MainGame.height / 2), MainGame.width / 11,
                MainGame.height / 6,0,-180);
        g.setColor(Color.BLACK);
        g.drawArc((int) (MainGame.width / 4.5), (int) (MainGame.height / 2), MainGame.width / 11,
                MainGame.height / 6,0,-180);
    }

    public static void drawArrows(Graphics2D g) {
        g.setColor(Color.BLACK);

        int[] x_coordinates_up_down = new int[] {MainGame.width/4, (int) (MainGame.width/4 +
                ((MainGame.width/3.5) - (MainGame.width/4))/2), (int) (MainGame.width/3.5)};

        int[] y_coordinates_left_right = new int[] {(int) (MainGame.height/1.95 + ((MainGame.height/1.725) -
                (MainGame.height/1.95))/2), (int) (MainGame.height/1.95), (int) (MainGame.height/1.725)};

        // up arrow
        g.fillPolygon(x_coordinates_up_down,
                new int[]{(int) (MainGame.height/2.55), (int) (MainGame.height/3.05), (int) (MainGame.height/2.55)},
                3);

        // down arrow
        g.fillPolygon(x_coordinates_up_down, new int[]{(int) (MainGame.height/1.425), (int) (MainGame.height/1.3),
                        (int) (MainGame.height/1.425)}, 3);

        // left arrow
        g.fillPolygon(new int[] {(int) (MainGame.width/6.125), (int) (MainGame.width/5), (int) (MainGame.width/5)},
                y_coordinates_left_right, 3);

        // right arrow
        g.fillPolygon(new int[] {(int) (MainGame.width/2.7), (int) (MainGame.width/3), (int) (MainGame.width/3)},
                y_coordinates_left_right, 3);
    }
}
