package com.akijoey.controller;

import com.akijoey.bean.Player;
import com.akijoey.util.ImageUtil;

import java.awt.image.BufferedImage;

import static com.akijoey.util.ConfigUtil.map;
import static com.akijoey.MagicTowerGame.frame;

public class PlayerController {

    public static Player player = Player.getInstance();

    public static BufferedImage draw() {
        return ImageUtil.readPlayer(player.getDirection());
    }

    public static void turn(String direction) {
        player.setDirection(direction);
        int x = nextX(direction), y = nextY(direction);
        if (x >= 0 && x < 11 && y >= 0 && y < 11) {   // edge case
            int id = map[player.getFloor()][y][x];
            if (interaction(id)) {
                move(x, y);
            }
        }
    }

    public static void move(int x, int y) {
        map[player.getFloor()][y][x] = 0;
        player.setX(x);
        player.setY(y);
        frame.repaint();
    }
    public static void move() {
        String direction = player.getDirection();
        move(nextX(direction), nextY(direction));
    }

    private static int nextX(String direction) {
        if (direction.equals("left")) {
            return player.getX() - 1;
        } else if (direction.equals("right")) {
            return player.getX() + 1;
        }
        return player.getX();
    }

    private static int nextY(String direction) {
        if (direction.equals("up")) {
            return player.getY() - 1;
        } else if (direction.equals("down")) {
            return player.getY() + 1;
        }
        return player.getY();
    }

    private static boolean interaction(int id) {
        if (id >= 0 && id < 12) {
            return BlockController.interaction(id);
        } else if (id >= 12 && id < 40) {
            return ItemController.interaction(id);
        } else if (id >= 40 && id < 50) {
            return NpcController.interaction(id);
        } else if (id >= 50 && id < 110) {
            return MonsterController.interaction(id);
        }
        return false;
    }

}
