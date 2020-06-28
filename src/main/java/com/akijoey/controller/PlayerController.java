package com.akijoey.controller;

import com.akijoey.bean.Player;
import com.akijoey.util.ImageUtil;

import java.awt.image.BufferedImage;

import static com.akijoey.util.ConfigUtil.maps;
import static com.akijoey.MagicTowerGame.frame;
import static com.akijoey.util.ConfigUtil.attributes;

public class PlayerController {

    public static Player player = new Player(attributes);

    public static BufferedImage draw() {
        return ImageUtil.readPlayer(player.getDirection());
    }

    public static void turn(String direction) {
        player.setDirection(direction);
        int x = nextX(direction), y = nextY(direction);
        if (x >= 0 && x < 11 && y >= 0 && y < 11) {   // edge case
            int id = maps.get(player.getFloor())[y][x];
            if (interaction(id)) {
                move(x, y);
            }
        }
    }

    public static void move(int x, int y) {
        maps.get(player.getFloor())[y][x] = 1000;
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
        if (id >= 1000 && id < 1100) {
            return BlockController.interaction(id);
        } else if (id >= 1100 && id < 1200) {
            return ItemController.interaction(id);
        } else if (id >= 1200 && id < 1300) {
            return NpcController.interaction(id);
        } else if (id >= 1300) {
            return MonsterController.interaction(id);
        }
        return false;
    }

}
