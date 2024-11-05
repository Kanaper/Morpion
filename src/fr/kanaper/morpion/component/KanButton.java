package fr.kanaper.morpion.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.AlphaComposite;

import javax.swing.JButton;

public class KanButton extends JButton {

    private String buttonName;
    private boolean mouseClicked = false;
    private int width;
    private int height;

    public KanButton(String title, String buttonName) {
        super(title);

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addMouseListener(new KanButtonListener(this));

        this.buttonName = buttonName;

        this.setOpaque(false);
    }

    public KanButton(String buttonName, int width, int height) {
        this("", buttonName);

        this.width = width;
        this.height = height;
    }

    public boolean setMouseClicked(boolean clicked) {
        return this.mouseClicked = clicked;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (this.mouseClicked) {
            float opacite = 0.2f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setColor(Color.GRAY);
            g2d.fillRoundRect(5, 5, this.width, this.height, 10, 10);

            opacite = 1f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(5, 5, this.width, this.height, 10, 10);

            g2d.setFont(g2d.getFont().deriveFont((float) this.width / 4));
            g2d.drawString(buttonName, this.width / 2 - 3 - this.width / 4, this.height / 2 + 3 + this.height / 4);
        } else {
            float opacite = 0.2f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setColor(getBackground());
            g2d.fillRoundRect(5, 5, this.width, this.height, 10, 10);

            opacite = 1f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(5, 5, this.width, this.height, 10, 10);

            g2d.setFont(g2d.getFont().deriveFont((float) this.width / 4));
            g2d.drawString(buttonName, this.width / 2 - 3 - this.width / 4, this.height / 2 + 3 + this.height / 4);
        }
    }
}
