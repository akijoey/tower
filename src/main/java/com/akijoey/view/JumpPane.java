package com.akijoey.view;

import com.akijoey.controller.PlayerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static com.akijoey.MagicTowerGame.frame;
import static com.akijoey.util.ConfigUtil.player;
import static com.akijoey.util.ConfigUtil.positions;
import static com.akijoey.view.ContentPane.messagePane;

public class JumpPane extends JLayeredPane {

    public JumpPane() {
        setLayout(null);
        setBounds(7 * 72, 2 * 72, 72 * 9, 72 * 9);
        setBorder(BorderFactory.createLineBorder(new Color(204, 102, 0), 8, true));
        setBackground(Color.BLACK);
        setOpaque(true);
        setVisible(false);
    }

    public void display() {
        ArrayList<JLabel> labels = new ArrayList<>();
        for (int i = 0;i <= player.getLimit();i++) {
            int x = 50 + i / 10 * 200, y = 50 + i % 10 * 50;
            JLabel label = new JLabel("▷ 第 " + i + " 层"){{
                setFont(new Font("Serif", 0, 30));
                setForeground(Color.WHITE);
                setBounds(x, y, 200, 50);
            }};
            labels.add(label);
            add(label);
        }

        setVisible(true);
        requestFocus();

        labels.get(0).setText("▶ 第 0 层");
        addKeyListener(new KeyAdapter() {
            private int select = 0;
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN && select < labels.size() - 1) {
                    increase(1);
                } else if (e.getKeyCode() == KeyEvent.VK_UP && select > 0) {
                    increase(-1);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    player.setDirection("down");
                    player.setFloor(select);
                    PlayerController.move(positions.get(0)[select][0], positions.get(0)[select][1]);
                    messagePane.display("第   " + select + "   层");
                    close();
                } else if (e.getKeyCode() == KeyEvent.VK_J) {
                    close();
                }
            }
            private void increase(int increment) {
                JLabel label = labels.get(select);
                label.setText(label.getText().replace("▶", "▷"));
                label = labels.get(select += increment);
                label.setText(label.getText().replace("▷", "▶"));
                repaint();
            }
            private void close() {
                frame.requestFocus();
                setVisible(false);
                labels.forEach(label -> remove(label));
                removeKeyListener(this);
            }
        });

    }

}
