package com.akijoey.controller;

import com.akijoey.bean.Item;

import static com.akijoey.controller.PlayerController.player;
import static com.akijoey.controller.PlayerController.move;
import static com.akijoey.util.ConfigUtil.first;
import static com.akijoey.util.ConfigUtil.last;

public class BlockController {

    public static boolean interaction(int id) {
        if (id == 0 || id == 7) {   // pass 7
            return true;
        } else if (id > 2 && id < 7) {
            return openDoor(id);
        } else if (id == 8 || id == 9) {
            climbStair(id);
            return false;
        }
        return false;
    }

    private static boolean openDoor(int id) {
        Item item = player.getItem();
        if (id == 3 && item.getYellowKey() > 0) {
            item.setYellowKey(item.getYellowKey() - 1);
            return true;
        } else if (id == 4 && item.getBlueKey() > 0) {
            item.setBlueBottle(item.getBlueKey() - 1);
            return true;
        } else if (id == 5 && item.getRedKey() > 0) {
            item.setRedKey(item.getRedKey() - 1);
            return true;
        } else if (id == 6 && item.getGreenKey() > 0) {
            item.setGreenKey(item.getGreenKey() - 1);
            return true;
        }
        return false;
    }

    private static void climbStair(int id) {
        int floor = player.getFloor();
        if (id == 8) {
            player.setFloor(++floor);
            move(first[floor][0], first[floor][1]);
        } else {
            player.setFloor(--floor);
            move(last[floor][0], last[floor][1]);
        }
    }

}
