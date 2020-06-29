package com.akijoey.controller;

import com.akijoey.bean.Item;

import static com.akijoey.controller.PlayerController.player;
import static com.akijoey.controller.PlayerController.move;
import static com.akijoey.util.ConfigUtil.positions;

public class BlockController {

    public static boolean interaction(int id) {
        if (id == 1000 || id == 1030) {
            return true;
        } else if (id >= 1040 && id < 1050) {
            climbStair(id);
            return false;
        } else if (id >= 1050 && id < 1100) {
            return openDoor(id);
        }
        return false;
    }

    private static boolean openDoor(int id) {
        Item item = player.getItem();
        if (id == 1050 && item.getYellowKey() > 0) {
            item.setYellowKey(item.getYellowKey() - 1);
            return true;
        } else if (id == 1051 && item.getBlueKey() > 0) {
            item.setBlueKey(item.getBlueKey() - 1);
            return true;
        } else if (id == 1052 && item.getRedKey() > 0) {
            item.setRedKey(item.getRedKey() - 1);
            return true;
        } else if (id == 1053 && item.getGreenKey() > 0) {
            item.setGreenKey(item.getGreenKey() - 1);
            return true;
        }
        return false;
    }

    private static void climbStair(int id) {
        int floor = player.getFloor();
        player.setDirection("down");
        if (id % 2 == 0) {  // climb up
            if (id == 1040) {
                player.setFloor(++floor);
                if (floor > player.getLimit()) {    // update floor limit for jump
                    player.setLimit(floor);
                }
            } else if (id == 1042) {
                player.setFloor(floor += 9);
            } else if (id == 1044) {
                player.setFloor(floor += 10);
            }
            move(positions.get(0)[floor][0], positions.get(0)[floor][1]);
        } else {  // climb down
            if (id == 1041) {
                player.setFloor(--floor);
            } else if (id == 1043) {
                player.setFloor(floor -= 9);
            } else if (id == 1045) {
                player.setFloor(floor -= 10);
            }
            move(positions.get(1)[floor][0], positions.get(1)[floor][1]);
        }
    }

}
