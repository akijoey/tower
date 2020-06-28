package com.akijoey.view;

import com.akijoey.bean.Monster;
import com.akijoey.controller.MonsterController;
import com.akijoey.controller.PlayerController;
import com.akijoey.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

import static com.akijoey.MagicTowerGame.keyEnable;
import static com.akijoey.controller.PlayerController.player;
import static com.akijoey.util.ConfigUtil.monsters;

public class BattlePane extends JLayeredPane {

    public BattlePane() {
        setLayout(null);
        setBounds(27, 72 * 2, 1242, 541);
        setOpaque(true);
        setVisible(false);
    }

    public void display(int id) {

        Monster monster = new Monster(monsters.get(id));

        // background label
        JLabel background = new JLabel(new ImageIcon(ImageUtil.battle));
        background.setBounds(0, 0, 1242, 541);
        add(background, 1, 0);

        // monster image label
        JLabel monsterImage = new JLabel(new ImageIcon(ImageUtil.from.get(id)));
        monsterImage.setBounds(100, 120, 72, 72);
        add(monsterImage, 8, 0);

        // monster health label
        JLabel monsterHealth = createLabel();
        monsterHealth.setBounds(400, 37 - 50, 300, 300);
        monsterHealth.setText(monster.getHealth() + "");
        add(monsterHealth, 2, 0);

        // monster attack label
        JLabel monsterAttack = createLabel();
        monsterAttack.setBounds(400, 157 - 50, 300, 300);
        monsterAttack.setText(monster.getAttack() + "");
        add(monsterAttack, 3, 0);

        // monster defend label
        JLabel monsterDefend = createLabel();
        monsterDefend.setBounds(400, 291 - 50, 300, 300);
        monsterDefend.setText(monster.getDefend() + "");
        add(monsterDefend, 4, 0);

        // player health label
        JLabel playerHealth = createLabel();
        playerHealth.setBounds(785, 37 - 50, 300, 300);
        playerHealth.setText(player.getHealth() + "");
        add(playerHealth, 5, 0);

        // player attack label
        JLabel playerAttack = createLabel();
        playerAttack.setBounds(785, 157 - 50, 300, 300);
        playerAttack.setText(player.getAttack() + "");
        add(playerAttack, 6, 0);

        // player defend label
        JLabel playerDefend = createLabel();
        playerDefend.setBounds(785, 291 - 50, 300, 300);
        playerDefend.setText(player.getDefend() + "");
        add(playerDefend, 7, 0);

        keyEnable = false;
        setVisible(true);

        new Timer(500, event -> {
            MonsterController.battle(monster);
            monsterHealth.setText(monster.getHealth() + "");
            playerHealth.setText(player.getHealth() + "");
            if (monster.getHealth() <= 0) {
                setVisible(false);
                keyEnable = true;

                MonsterController.defeat(monster);
                removeAll();

                PlayerController.move();
                ((Timer)event.getSource()).stop();
            }
        }).start();
    }

    private JLabel createLabel() {
        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Serif", 0, 35));
        return label;
    }

}
