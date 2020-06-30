package com.akijoey.view;

import com.akijoey.controller.PlayerController;
import com.akijoey.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import static com.akijoey.util.ConfigUtil.player;
import static com.akijoey.util.ConfigUtil.maps;

public class ContentPane extends JPanel {

    public static HashMap<Integer, BufferedImage> keyframe = ImageUtil.from;

    public static BattlePane battlePane = new BattlePane();
    public static ForecastPane forecastPane = new ForecastPane();
    public static JumpPane jumpPane = new JumpPane();
    public static MessagePane messagePane = new MessagePane();
    public static DialogPane dialogPane = new DialogPane();

    public ContentPane() {
        setLayout(null);
        setPreferredSize(new Dimension(72 * 18, 72 * 13));

        add(battlePane);
        add(forecastPane);
        add(jumpPane);
        add(messagePane);
        add(dialogPane);

        new Timer(500, new ActionListener() {
            private boolean state = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state) {
                    keyframe = ImageUtil.from;
                    state = false;
                } else {
                    keyframe = ImageUtil.to;
                    state = true;
                }
                repaint();
            }
        }).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        // draw background
        g2.drawImage(ImageUtil.readBackground("content"), 0, 0, null);

        // draw map
        for (int x = 0;x < 11;x++) {
            for (int y = 0;y < 11;y++) {
                int id = maps.get(player.getFloor())[y][x];
                g2.drawImage(keyframe.get(id), (x + 6) * 72, (y + 1) * 72, null);
            }
        }

        // draw player block
        g2.drawImage(PlayerController.draw(), (player.getX() + 6) * 72, (player.getY() + 1) * 72, null);

        // draw player data
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", 0, 30));
        g2.drawString(player.getLevel() + "", 230, 150);
        g2.drawString(player.getHealth() + "", 220, 215);
        g2.drawString(player.getAttack() + "", 220, 270);
        g2.drawString(player.getDefend() + "", 220, 325);
        g2.drawString(player.getGold() + "", 220, 385);
        g2.drawString(player.getExperience() + "", 220, 440);

        // draw player key
        g2.drawString(player.getItem().getYellowKey() + "", 240, 530);
        g2.drawString(player.getItem().getBlueKey() + "", 240, 605);
        g2.drawString(player.getItem().getRedKey() + "", 240, 680);

        // draw floor
        int floor = player.getFloor();
        if (floor == 31 || floor == 32) {
            floor = 23;
        }
        g2.drawString(floor + "", 200, 750);

    }

}
