package com.akijoey.view;

import com.akijoey.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

import static com.akijoey.MagicTowerGame.frame;
import static com.akijoey.view.ContentPane.dialogPane;

public class MessagePane extends JLayeredPane {

    public MessagePane() {
        setLayout(null);
        setBounds(10, 270, 72 * 18 - 20, 150);
        setOpaque(true);
        setVisible(false);

        // background label
        add(new JLabel(new ImageIcon(ImageUtil.blank)){{
            setLayout(null);
            setBounds(0, 0, 72 * 18 - 20, 150);
            Color color = new Color(204, 102, 0);
            setBorder(BorderFactory.createLineBorder(color, 8, true));
        }}, 1, 0);
    }

    public void display(String message) {

        // message label
        JLabel messageLabel = new JLabel(message){{
            setForeground(Color.WHITE);
            setFont(new Font("Serif", 0, 50));
            setHorizontalAlignment(SwingConstants.CENTER);
            setBounds(0, 0, 72 * 18 - 20, 150);
        }};
        add(messageLabel, 2, 0);

        setVisible(true);
        requestFocus();

        new Timer(500, event -> {
            if (message.equals("经验不足") || message.equals("金币不足")) {
                dialogPane.requestFocus();
            } else {
                frame.requestFocus();
            }
            setVisible(false);
            remove(messageLabel);
            ((Timer)event.getSource()).stop();
        }).start();
    }

}
