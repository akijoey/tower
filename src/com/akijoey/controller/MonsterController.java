package com.akijoey.controller;

import com.akijoey.bean.Monster;

import static com.akijoey.controller.PlayerController.player;
import static com.akijoey.util.ConfigUtil.monsters;
import static com.akijoey.view.ContentPane.battlePane;

public class MonsterController {

    public static boolean interaction(int id) {
        int loss = lose(create(id));
        if (loss != -1 && loss < player.getHealth()) {
            battlePane.display(id);
        }
        return false;
    }

    public static Monster create(int id) {
        Monster proto = monsters.get(id);
        Monster monster = new Monster();
        monster.setId(id);
        monster.setName(proto.getName());
        monster.setHealth(proto.getHealth());
        monster.setAttack(proto.getAttack());
        monster.setDefend(proto.getDefend());
        monster.setGold(proto.getGold());
        monster.setExperience(proto.getExperience());
        return monster;
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
