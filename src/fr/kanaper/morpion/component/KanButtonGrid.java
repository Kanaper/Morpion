package fr.kanaper.morpion.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.AlphaComposite;

import javax.swing.JButton;

import fr.kanaper.morpion.jeu.Grid;

public class KanButtonGrid extends JButton {

    private static final int CASEWIDTH = Grid.GRIDWIDTH / 3;
    private static final int CASEHEIGHT = Grid.GRIDHEIGHT / 3;
    private int xStart;
    private int yStart;
    private boolean mouseStatement = false;
    private boolean filled = false;
    private boolean player = true;
    private boolean mouseClicked = false;

    public KanButtonGrid(int xStart, int yStart) {
        this.setBounds(xStart, yStart, CASEWIDTH, CASEHEIGHT);

        this.xStart = xStart;
        this.yStart = yStart;

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);

        this.addMouseListener(new KanButtonGridListener(this));

    }

    public void setMouseStatement(boolean statement) {
        this.mouseStatement = statement;
    }

    public boolean getMouseStatement() {
        return this.mouseStatement;
    }

    public boolean getFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean getPlayer() {
        return this.player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public boolean getMouseClicked() {
        return this.mouseClicked;
    }

    public void setMouseClicked(boolean mouseClicked) {
        this.mouseClicked = mouseClicked;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(5));

        if (getMouseStatement() == true && getFilled() == false) {
            float opacite = 0.2f;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacite));
            g2d.setColor(Color.GRAY);
            g2d.fillRect(0, 0, CASEWIDTH, CASEHEIGHT);

            g2d.setColor(Color.BLACK);
            g2d.drawRect(0, 0, CASEWIDTH, CASEHEIGHT);
        }

        if (getMouseClicked() == true && getMouseStatement() == true && getFilled() == false) {
            if (getPlayer() == true) {
                g2d.setColor(Color.RED);
                g2d.drawLine(0, 0, CASEWIDTH, CASEHEIGHT);
                g2d.drawLine(CASEWIDTH, 0, 0, CASEHEIGHT);
                this.setFilled(true);
            } else {
                g2d.setColor(Color.BLUE);
                g2d.drawOval(0, 0, CASEWIDTH, CASEHEIGHT);
                this.setFilled(true);
            }
        }

    }
}