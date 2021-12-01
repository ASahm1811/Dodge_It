package main.others;

import main.MainGame;
import main.game_objects.*;
import main.menus.MainMenu;
import main.enumerations.ID;

import java.util.Random;

public class Spawner {

    private MainGame maingame;
    private Handler handler;
    public static int score = -325;
    private Random r = new Random();
    private static int smart_enemy_id = 1;

    public Spawner(MainGame maingame, Handler handler) {
        this.maingame = maingame;
        this.handler = handler;
    }

    public void tick() {
        score++;

        if (score == -300) {
            // Spawn player
            GameObject player = new Player((float) (MainGame.width/2.1), (float) (MainGame.height/2.25),
                    ID.Player, handler, maingame);
            // chosen color from menu
            player.setColor(MainMenu.chosen_color);
            handler.addObject(player);
        }
        else if (score == -100) {
            // Spawn first enemy
            handler.addObject(new Enemy(r.nextInt(MainGame.width-50), r.nextInt(MainGame.height-50),
                    ID.Enemy));
        }
        else if (score > 0) {
            if (score % 500 == 0) {

                // Spawn next enemy
                handler.addObject(new Enemy(r.nextInt(MainGame.width - 50),
                        r.nextInt(MainGame.height - 50), ID.Enemy));

                if (score % 1000 == 0) {
                    // Spawn a smart enemy
                    handler.addObject(new SmartEnemy(r.nextInt(MainGame.width - 50),
                            r.nextInt(MainGame.height - 50), ID.SmartEnemy,
                            "SE_" + smart_enemy_id, handler, maingame));
                    smart_enemy_id++;
                }
            }
        }
    }


    public void setScore(int score) {
        Spawner.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setSmartEnemyID(int se_id) {
        Spawner.smart_enemy_id = se_id;
    }

}
