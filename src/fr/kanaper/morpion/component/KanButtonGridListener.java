package fr.kanaper.morpion.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KanButtonGridListener implements MouseListener {

    private KanButtonGrid button;

    public KanButtonGridListener(KanButtonGrid button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.button.setMouseClicked(true);
        this.button.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.button.setMouseStatement(true);
        this.button.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.button.setMouseStatement(false);
        this.button.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}
