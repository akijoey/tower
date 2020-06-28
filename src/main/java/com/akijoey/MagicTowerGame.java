package com.akijoey;

import com.akijoey.util.AudioUtil;
import com.akijoey.view.ContentPane;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.akijoey.controller.PlayerController.turn;
import static com.akijoey.view.ContentPane.forecastPane;

import static com.akijoey.view.ContentPane.jumpPane;
import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_UP;

public class MagicTowerGame {

    public static JFrame frame = new JFrame("Magic Tower v1.12");
    public static boolean keyEnable = true;

    public static void main(String[] args) {

//        AudioUtil.playBackgroundMusic();

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (keyEnable) {
                    switch (e.getKeyCode()) {
                        case VK_RIGHT:
                            turn("right");
                            break;
                        case VK_DOWN:
                            turn("down");
                            break;
                        case VK_LEFT:
                            turn("left");
                            break;
                        case VK_UP:
                            turn("up");
                            break;
                        case VK_L:
                            forecastPane.display();
                            break;
                        case VK_J:
                            jumpPane.display();
                            break;
                    }
                }
            }
        });

        ContentPane pane = new ContentPane();
        frame.setContentPane(pane);

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
