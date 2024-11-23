package fr.kanaper.morpion.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.AlphaComposite;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.kanaper.morpion.enums.KanButtonType;

/**
 * Classe permettant de créer un bouton
 * 
 * @version 1.0
 * @author Kanaper
 */
public class KanButton extends JButton {

    private String buttonName;
    private boolean mouseIn = false;

    private int width;
    private int height;
    private int scale;

    /**
     * Constructeur de la classe KanButton
     * 
     * @param buttonName nom du bouton
     * @param type       type du bouton
     * @param window     fenêtre actuelle
     */
    public KanButton(String buttonName, KanButtonType type, JFrame window) {
        super("");
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addMouseListener(new KanButtonMouseListener(this));

        this.buttonName = buttonName;

        this.setOpaque(false);
    }

    public void setScale() {
        if (this.width <= 100) {
            this.scale = 3;
        } else {
            this.scale = this.buttonName.length() * 2;
        }
    }

    public void setWidth(int width) {
        this.width = width;
        setScale();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * sert à indiquer la largeur du bouton
     * 
     * @return largeur du bouton
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * sert à indiquer la hauteur du bouton
     * 
     * @return hauteur du bouton
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * sert à indiquer si la souris est sur le bouton
     * 
     * @param mouseIn true si la souris est sur le bouton, false sinon
     */
    public void setMouseIn(boolean mouseIn) {
        this.mouseIn = mouseIn;
    }

    /**
     * revoie si la souris est sur le bouton
     * 
     * @return true si la souris est sur le bouton, false sinon
     */
    public boolean getMouseIn() {
        return this.mouseIn;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getMouseIn()) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f));
        } else {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
        }

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRoundRect(0, 0, this.width, this.height, 10, 10);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawRoundRect(1, 1, this.width - 3, this.height - 3, 10, 10);

        g2d.setFont(g2d.getFont().deriveFont((float) this.height / 3));
        g2d.drawString(this.buttonName, this.width / 2 - (this.scale * this.buttonName.length()),
                this.height / 2 + this.scale);

    }
}
