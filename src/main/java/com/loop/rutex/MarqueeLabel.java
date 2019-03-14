package com.loop.rutex;


import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

public class MarqueeLabel extends JLabel {

    public static int LEFT_TO_RIGHT = 1;
    public static int RIGHT_TO_LEFT = 2;
    String text;
    int Option;
    int Speed;

    public MarqueeLabel(int Option, int Speed) {
        this.Option = Option;
        this.Speed = Speed;
        this.setFont(new Font("Arial", Font.BOLD, 36));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (Option == LEFT_TO_RIGHT) {
            g.translate((int) ((System.currentTimeMillis() / Speed) % (getWidth() * 2) - getWidth()), 0);
        } else if (Option == RIGHT_TO_LEFT) {
            g.translate((int) (getWidth() - (System.currentTimeMillis() / Speed) % (getWidth() * 2)), 0);
        }
        super.paintComponent(g);
        repaint(5);
    }
}
