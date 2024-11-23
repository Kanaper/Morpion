package fr.kanaper.morpion.mainmenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fr.kanaper.morpion.enums.KanButtonType;
import fr.kanaper.morpion.jeu.Game;

/**
 * Classe listener pour les boutons du menu principal
 * 
 * @version 1.0
 * @author Kanaper
 */
public class MainMenuButtonPanelListener implements ActionListener {

    private KanButtonType type;
    private MainMenuWindow menuWindow;

    /**
     * Constructeur de la classe MainMenuButtonListener
     * 
     * @param type       type du bouton
     * @param menuWindow fenêtre actuelle
     */
    public MainMenuButtonPanelListener(KanButtonType type, MainMenuWindow menuWindow) {
        this.type = type;
        this.menuWindow = menuWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.type) {
            case PLAY:
                new Game().setVisible(true);
                this.menuWindow.dispose();
                break;
            case QUIT:
                System.exit(0);
                break;

            default:
                throw new IllegalArgumentException("Invalid button type");
        }
    }
}
