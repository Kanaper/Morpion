package fr.kanaper.morpion.component;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class KanButtonMouseListener implements MouseListener {

    private KanButton button;

    public KanButtonMouseListener(KanButton button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.button.setMouseIn(true);
        this.button.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.button.setMouseIn(false);
        this.button.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
