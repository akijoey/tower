package com.akijoey.controller;

import com.akijoey.bean.Monster;

import static com.akijoey.controller.PlayerController.player;
import static com.akijoey.util.ConfigUtil.monsters;
import static com.akijoey.view.ContentPane.battlePane;
import static com.akijoey.view.ContentPane.messagePane;

public class MonsterController {

    public static boolean interaction(int id) {
        int loss = lose(new Monster(monsters.get(id)));
        if (loss != -1 && loss < player.getHealth()) {
            battlePane.display(id);
        }
        return false;
    }

    public static void battle(Monster monster) {
        if (player.getAttack() > monster.getDefend()) {
            monster.setHealth(monster.getHealth() - player.getAttack() + monster.getDefend());
        }
        if (monster.getHealth() <= 0) {
            return;
        }
        if (monster.getAttack() > player.getDefend()) {
            player.setHealth(player.getHealth() - monster.getAttack() + player.getDefend());
        }
    }

    public static void defeat(Monster monster) {
        player.setGold(player.getGold() + monster.getGold());
        player.setExperience(player.getExperience() + monster.getExperience());
        messagePane.display("获得金币 " + monster.getGold() + " 经验值 " + monster.getExperience() + " !");
    }

    public static int lose(Monster monster) {
        if (player.getAttack() <= monster.getDefend()) {
            return -1;
        } else if (player.getDefend() >= monster.getAttack()) {
            return 0;
        } else {
            int count = monster.getHealth() / (player.getAttack() - monster.getDefend());
            return (monster.getAttack() - player.getDefend()) * count;
        }
    }

}
