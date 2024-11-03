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
    private boolean mouseStatement = false;

    public KanButton(String title, String buttonName) {
        super(title);

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addMouseListener(new KanButtonListener(this));

        this.buttonName = buttonName;

        this.setOpaque(false);
    }

    public KanButton(String buttonName) {
        this("", buttonName);
    }

    public boolean setMouseStatement(boolean statement) {
        return mouseStatement = statement;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (mouseStatement) {
            float opacite = 0.2f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setColor(Color.GRAY);
            g2d.fillRoundRect(5, 5, 185, 85, 10, 10);

            opacite = 1f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(5, 5, 185, 85, 10, 10);

            g2d.setColor(Color.BLACK);
            this.setFont(this.getFont().deriveFont(45f));
            g2d.drawString(buttonName, 50, 60);
        } else {
            float opacite = 0.2f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillRoundRect(5, 5, 185, 85, 10, 10);

            opacite = 1f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.BLACK);
            g2d.drawRoundRect(5, 5, 185, 85, 10, 10);

            g2d.setColor(Color.BLACK);
            this.setFont(this.getFont().deriveFont(45f));
            g2d.drawString(buttonName, 50, 60);
        }
    }
}
