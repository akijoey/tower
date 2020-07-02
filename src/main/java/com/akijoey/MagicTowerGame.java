package com.akijoey;

import com.akijoey.util.AudioUtil;
import com.akijoey.view.ContentPane;
import com.akijoey.view.MenuPane;

import javax.swing.*;
import java.awt.event.*;

import static com.akijoey.controller.PlayerController.turn;

import static com.akijoey.util.ConfigUtil.*;
import static com.akijoey.view.ContentPane.*;
import static java.awt.event.KeyEvent.*;

public class MagicTowerGame {

    public static JFrame frame;

    public static void main(String[] args) {
        display(new JFrame("Magic Tower"){{
            setContentPane(new MenuPane(){{
                startGame(event -> {
                    dispose();
                    start();
                });
                loadGame(event -> {
                    loadArchive();
                    dispose();
                    start();
                });
                quitGame(event -> dispose());
            }});
        }});
    }

    public static void start() {
//        AudioUtil.playBackgroundMusic();
        display(frame = new JFrame("Magic Tower"){{
            setContentPane(new ContentPane());
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
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
                            if (player.getItem().isBadge()) {
                                forecastPane.display();
                            }
                            break;
                        case VK_J:
                            if (player.getItem().isCompass()) {
                                jumpPane.display();
                            }
                            break;
                        case VK_S:
                            saveArchive();
                            messagePane.display("保存成功");
                            break;
                        case VK_A:
                            loadArchive();
                            getContentPane().repaint();
                            messagePane.display("读档成功");
                            break;
                        case VK_R:
                            loadDefault();
                            getContentPane().repaint();
                            break;
                        case VK_Q:
                            dispose();
                            System.exit(0);
                            break;
                    }
                }
            });
        }});
    }

    public static void display(JFrame frame) {
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

}
