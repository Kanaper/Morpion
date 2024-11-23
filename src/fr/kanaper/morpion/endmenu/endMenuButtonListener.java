package fr.kanaper.morpion.endmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.kanaper.morpion.enums.KanButtonType;
import fr.kanaper.morpion.jeu.Game;

/**
 * classe endMenuButtonListener
 * 
 * @version 1.0
 * @author Kanaper
 */
public class endMenuButtonListener implements ActionListener {

    private KanButtonType type;
    private Game gameWindow;

    public endMenuButtonListener(KanButtonType type, Game gameWindow) {
        this.type = type;
        this.gameWindow = gameWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.type) {
            case RESTART:
                new Game().setVisible(true);
                this.gameWindow.dispose();
                break;
            case QUIT:
                System.exit(0);
                break;
            default:
                break;
        }
    }

}
