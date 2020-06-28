package com.akijoey.controller;

import com.akijoey.bean.Item;

import static com.akijoey.util.ConfigUtil.maps;
import static com.akijoey.view.ContentPane.dialogPane;
import static com.akijoey.controller.PlayerController.player;

public class NpcController {

    public static boolean interaction(int id) {
        if (id >= 1200 && id < 1203) {
            dialogPane.shop(1201);
        } else if (id >= 1203 && id < 1206) {
            dialogPane.shop(1204);
        } else if (id == 1211 || id == 1212 || id == 1221 || id == 1222) {
            dialogPane.shop(id);
        } else {
            dialogPane.talk(id);
        }
        return false;
    }

    public static void talk(int id) {
        if (id == 1230) {   // 0层 仙子 第一次对话
            maps.get(0)[8][5] = 1000;
            maps.get(0)[8][4] = 1230;
            Item item = player.getItem();
            item.setYellowKey(item.getYellowKey() + 1);
            item.setBlueKey(item.getBlueKey() + 1);
            item.setRedKey(item.getRedKey() + 1);
        }
    }

    public static void shop(int id, int select) {
        int gold = player.getGold();
        int experience = player.getExperience();
        if (id == 1201 && gold >= 25) {   // 3层 商店
            player.setGold(gold - 25);
            if (select == 0) {
                player.setHealth(player.getHealth() + 800);
            } else if (select == 1) {
                player.setAttack(player.getAttack() + 4);
            } else {
                player.setDefend(player.getDefend() + 4);
            }
        } else if (id == 1204 && gold >= 100) {    // 11层 商店
            player.setGold(gold - 100);
            if (select == 0) {
                player.setHealth(player.getHealth() + 4000);
            } else if (select == 1) {
                player.setAttack(player.getAttack() + 20);
            } else {
                player.setDefend(player.getDefend() + 20);
            }
        } else if (id == 1211) {    // 5层 老人
            if (select == 0 && experience >= 100) {
                player.setExperience(experience - 100);
                player.setLevel(player.getLevel() + 1);
                player.setHealth(player.getHealth() + 1000);
                player.setAttack(player.getAttack() + 7);
                player.setDefend(player.getDefend() + 7);
            } else if (select == 1 && experience >= 30) {
                player.setExperience(experience - 30);
                player.setAttack(player.getAttack() + 5);
            } else if (select == 2 && experience >= 30) {
                player.setExperience(experience - 30);
                player.setDefend(player.getDefend() + 5);
            }
        } else if (id == 1212) {    // 13层 老人
            if (select == 0 && experience >= 270) {
                player.setExperience(experience - 270);
                player.setLevel(player.getLevel() + 3);
                player.setHealth(player.getHealth() + 3000);
                player.setAttack(player.getAttack() + 21);
                player.setDefend(player.getDefend() + 21);
            } else if (select == 1 && experience >= 95) {
                player.setExperience(experience - 95);
                player.setAttack(player.getAttack() + 17);
            } else if (select == 2 && experience >= 95) {
                player.setExperience(experience - 95);
                player.setDefend(player.getDefend() + 17);
            }
        } else if (id == 1221) {    // 5层 商人
            Item item = player.getItem();
            if (select == 0 && gold >= 10) {
                player.setGold(gold - 10);
                item.setYellowKey(item.getYellowKey() + 1);
            } else if (select == 1 && gold >= 50) {
                player.setGold(gold - 50);
                item.setBlueKey(item.getBlueKey() + 1);
            } else if (select == 2 && gold >= 100) {
                player.setGold(gold - 100);
                item.setRedKey(item.getRedKey() + 1);
            }
        } else if (id == 1222) {    // 12层 商人
            Item item = player.getItem();
            if (select == 0 && item.getYellowKey() > 0) {
                item.setYellowKey(item.getYellowKey() - 1);
                player.setGold(gold + 7);
            } else if (select == 1 && item.getBlueKey() > 0) {
                item.setBlueKey(item.getBlueKey() - 1);
                player.setGold(gold + 35);
            } else if (select == 2 && item.getRedKey() > 0) {
                item.setRedKey(item.getRedKey() - 1);
                player.setGold(gold + 70);
            }
        }
    }


}
