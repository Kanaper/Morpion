package fr.kanaper.morpion.component;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class KanButton extends JButton {

    private int cX;
    private int cY;

    public KanButton(String title, int cX, int cY) {
        super(title);

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(lineborder);

        this.setBounds(this.cX, this.cY, 75, 75);

        this.cX = cX;
        this.cY = cY;

        this.setOpaque(false);
    }

    public KanButton(int cX, int cY) {
        this("", cX, cY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.fillRect(this.cX, this.cY, 50, 50);

    }
}
