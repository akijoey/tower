package com.akijoey.view;

import com.akijoey.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

import static com.akijoey.MagicTowerGame.keyEnable;

public class MessagePane extends JLayeredPane {

    public MessagePane() {
        setLayout(null);
        setBounds(10, 270, 72 * 18 - 20, 150);
        setOpaque(true);
        setVisible(false);

        // background label
        JLabel background = new JLabel(new ImageIcon(ImageUtil.blank));
        background.setLayout(null);
        background.setBounds(0, 0, 72 * 18 - 20, 150);
        background.setBorder(BorderFactory.createLineBorder(new Color(204, 102, 0), 8, true));
        add(background, 1, 0);

        // message label
        JLabel messageLabel = new JLabel();
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Serif", 0, 50));
        messageLabel.setBounds(0, 0, 72 * 18 - 20, 150);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageLabel, 2, 0);
    }

    public void display(String message) {

        // message label
        JLabel messageLabel = new JLabel();
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(new Font("Serif", 0, 50));
        messageLabel.setBounds(0, 0, 72 * 18 - 20, 150);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setText(message);
        add(messageLabel, 2, 0);

        setVisible(true);
        keyEnable = false;

        new Timer(500, event -> {
            keyEnable = true;
            setVisible(false);
            remove(messageLabel);
            ((Timer)event.getSource()).stop();
        }).start();
    }

}
