package com.akijoey.view;

import com.akijoey.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static com.akijoey.MagicTowerGame.frame;
import static com.akijoey.util.ConfigUtil.messages;

public class DialogPane extends JLayeredPane {

    public DialogPane() {
        setLayout(null);
        setBounds(675, 560, 540, 170);
        setVisible(false);
    }

    public void display(int id) {
        Insets insets = getInsets();
        String[] message = messages.get(id);
        ArrayList<BufferedImage> images = new ArrayList<>(){{
            add(ImageUtil.readPlayer("down"));
            add(ImageUtil.from.get(id));
        }};

        // background label
        JLabel background = new JLabel(new ImageIcon(ImageUtil.blank));
        background.setBorder(BorderFactory.createLineBorder(new Color(204, 102, 0), 8, true));
        background.setBounds(0, 0, 540, 170);
        add(background, 1, 0);

        // image label
        JLabel image = new JLabel(new ImageIcon(images.get(0)));
        image.setBounds(20 + insets.left, 20 + insets.top, 72, 72);
        add(image, 2, 0);

        // text area
        JTextArea text = new JTextArea(20, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Serif", 0, 30));
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setFocusable(false);
        text.setBounds(100 + insets.left, 20 + insets.top, 540 - 100, 170);
        text.setText(message[0]);
        add(text, 3, 0);

        setVisible(true);
        requestFocus();

        addKeyListener(new KeyAdapter() {
            private int count = 0;
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == e.VK_SPACE) {
                    remove(image);
                    remove(text);
                    if (++count >= message.length) {    // close
                        frame.requestFocus();
                        setVisible(false);
                        removeKeyListener(this);
                        return;
                    }
                    int x = count % 2 == 1 ? 400 : 675;
                    int y = count % 2 == 1 ? 310 : 560;
                    setBounds(x, y, 540, 170);
                    image.setIcon(new ImageIcon(images.get(count % 2)));
                    add(image, 2, 0);
                    text.setText(message[count]);
                    add(text, 3, 0);
                    repaint();
                }
            }
        });
    }

}
