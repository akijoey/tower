package com.akijoey.view;

import com.akijoey.controller.NpcController;
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
        setVisible(false);
    }

    public void talk(int id) {
        Insets insets = getInsets();
        ArrayList<String> message = messages.get(id);
        if (message == null) {
            return;
        }
        ArrayList<BufferedImage> images = new ArrayList<>(){{
            add(ImageUtil.readPlayer("down"));
            add(ImageUtil.from.get(id));
        }};
        setBounds(675, 560, 540, 200);

        // background label
        JLabel background = createBackground();
        background.setBounds(0, 0, 540, 200);
        add(background, 1, 0);

        // image label
        JLabel image = new JLabel(new ImageIcon(images.get(0)));
        image.setBounds(20 + insets.left, 20 + insets.top, 72, 72);
        add(image, 2, 0);

        // text area
        JTextArea text = createTextArea();
        text.setBounds(100 + insets.left, 30 + insets.top, 400, 200);
        text.setText(message.get(0));
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
                    if (++count >= message.size()) {    // close
                        close();
                        return;
                    }
                    int x = count % 2 == 1 ? 400 : 675;
                    int y = count % 2 == 1 ? 310 : 560;
                    setBounds(x, y, 540, 200);
                    image.setIcon(new ImageIcon(images.get(count % 2)));
                    add(image, 2, 0);
                    text.setText(message.get(count));
                    add(text, 3, 0);
                    repaint();
                } else if (e.getKeyCode() == e.VK_ESCAPE) {
                    close();
                }
            }
            private void close() {
                frame.requestFocus();
                setVisible(false);
                removeKeyListener(this);
                NpcController.talk(id);
            }
        });
    }

    public void shop(int id) {
        Insets insets = getInsets();
        ArrayList<String> message = (ArrayList<String>)messages.get(id).clone();
        setBounds(550, 230, 550, 250);

        // background label
        JLabel background = createBackground();
        background.setBounds(0, 0, 550, 250);
        add(background, 1, 0);

        // image label
        JLabel image = new JLabel(new ImageIcon(ImageUtil.from.get(id)));
        image.setBounds(20 + insets.left, 20 + insets.top, 72, 72);
        add(image, 2, 0);

        // text area
        JTextArea text = createTextArea();
        text.setBounds(120 + insets.left, 20 + insets.top, 550 - 50, 250);
        text.setText("请选择一个:\n" + message.get(0) + "\n" + message.get(1) + "\n" + message.get(2) + "\n" + message.get(3));
        add(text, 3, 0);

        setVisible(true);
        requestFocus();

        DialogPane that = this;
        addKeyListener(new KeyAdapter() {
            private int select = 0;
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN && select < message.size() - 1) {
                    increase(1);
                } else if (e.getKeyCode() == KeyEvent.VK_UP && select > 0) {
                    increase(-1);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (select == 3) {
                        close();
                        return;
                    }
                    NpcController.shop(id, select);
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    close();
                }
            }
            private void increase(int increment) {
                message.set(select, message.get(select).replace("▶", "▷"));
                message.set(select += increment, message.get(select).replace("▷", "▶"));
                text.setText("请选择一个:\n" + message.get(0) + "\n" + message.get(1) + "\n" + message.get(2) + "\n" + message.get(3));
                repaint();
            }
            private void close() {
                remove(image);
                remove(text);
                frame.requestFocus();
                setVisible(false);
                removeKeyListener(this);
            }
        });

    }

    private JLabel createBackground() {
        return new JLabel(new ImageIcon(ImageUtil.blank)){{
            Color color = new Color(204, 102, 0);
            setBorder(BorderFactory.createLineBorder(color, 8, true));
        }};
    }

    private JTextArea createTextArea() {
        return new JTextArea(20, 20){{
            setForeground(Color.WHITE);
            setFont(new Font("Serif", 0, 28));
            setWrapStyleWord(true);
            setLineWrap(true);
            setOpaque(false);
            setEditable(false);
            setFocusable(false);
        }};
    }

}
