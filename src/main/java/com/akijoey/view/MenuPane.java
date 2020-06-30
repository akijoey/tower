package com.akijoey.view;

import com.akijoey.util.ConfigUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPane extends JPanel {

    private JButton startButton;
    private JButton loadButton;
    private JButton quitButton;

    public MenuPane() {
        setLayout(null);
        setPreferredSize(new Dimension(550, 630));
        setBackground(Color.BLACK);

        startButton = createButton("Start Game");
        startButton.setBounds(175, 100, 200, 100);
        add(startButton);

        loadButton = createButton("Load Game");
        loadButton.setBounds(175, 250, 200, 100);
        if (!ConfigUtil.hasArchive()) {
            loadButton.setEnabled(false);
        }
        add(loadButton);

        quitButton = createButton("Quit Game");
        quitButton.setBounds(175, 400, 200, 100);
        add(quitButton);

    }

    public JButton createButton(String text) {
        return new JButton(text){{
            setFont(new Font("Serif", 3, 40));
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
            setBorder(null);
            setFocusPainted(false);
            setContentAreaFilled(false);
        }};
    }

    public void startGame(ActionListener actionListener) {
        startButton.addActionListener(actionListener);
    }

    public void loadGame(ActionListener actionListener) {
        loadButton.addActionListener(actionListener);
    }

    public void quitGame(ActionListener actionListener) {
        quitButton.addActionListener(actionListener);
    }

}
