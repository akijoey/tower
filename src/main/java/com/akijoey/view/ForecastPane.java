package com.akijoey.view;

import com.akijoey.bean.Monster;
import com.akijoey.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import static com.akijoey.MagicTowerGame.*;
import static com.akijoey.util.ConfigUtil.player;
import static com.akijoey.util.ConfigUtil.maps;
import static com.akijoey.util.ConfigUtil.monsters;
import static com.akijoey.controller.MonsterController.lose;
import static com.akijoey.controller.MonsterController.isMonster;

public class ForecastPane extends JLayeredPane {

    public ForecastPane() {
        setLayout(null);
        setBounds(72 * 6, 72, 72 * 11, 72 * 11);
        setBackground(Color.BLACK);
        setOpaque(true);
        setVisible(false);
    }

    public void display() {
        setVisible(true);
        requestFocus();
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int x = 0;x < 11;x++) {
            for (int y = 0;y < 11;y++) {
                int id = maps.get(player.getFloor())[y][x];
                if (isMonster(id) && !set.contains(id)) {

                    Monster monster = new Monster(monsters.get(id));

                    // monster image label
                    JLabel monsterImage = new JLabel(new ImageIcon(ImageUtil.from.get(id)));
                    monsterImage.setBounds(25, 24 + 96 * count, 72, 72);
                    add(monsterImage);

                    // monster name label
                    JLabel monsterName = createLabel("名称：" + monster.getName());
                    monsterName.setBounds(115, 24 + 96 * count, 3 * 72, 72 / 2);
                    add(monsterName);

                    // monster health label
                    JLabel monsterHealth = createLabel("生命：" + monster.getHealth());
                    monsterHealth.setBounds(115, 24 + 96 * count + 72 / 2, 3 * 72, 72 / 2);
                    add(monsterHealth);

                    // monster attack label
                    JLabel monsterAttack = createLabel("攻击：" + monster.getAttack());
                    monsterAttack.setBounds(339, 24 + 96 * count, 3 * 72, 72 / 2);
                    add(monsterAttack);

                    // monster defend label
                    JLabel monsterDefend = createLabel("防御：" + monster.getDefend());
                    monsterDefend.setBounds(339, 24 + 96 * count + 72 / 2, 3 * 72, 72 / 2);
                    add(monsterDefend);

                    // monster gold and experience label
                    JLabel monsterResource = createLabel("金 · 经：" + monster.getGold() + " · " + monster.getExperience());
                    monsterResource.setBounds(563, 24 + 96 * count, 3 * 72, 72 / 2);
                    add(monsterResource);

                    // player loss label
                    int loss = lose(monster);
                    JLabel playerLoss = createLabel("损失：" + (loss == -1 ? "???" : loss));
                    playerLoss.setBounds(563, 24 + 96 * count + 72 / 2, 3 * 72, 72 / 2);
                    add(playerLoss);

                    set.add(id);
                    count++;
                }
            }

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == e.VK_L) {
                        frame.requestFocus();
                        setVisible(false);
                        removeAll();
                    }
                }
            });
        }
    }

    private JLabel createLabel(String text) {
        return new JLabel(text){{
            setForeground(Color.WHITE);
            setFont(new Font("Serif", 0, 25));
        }};
    }

}
