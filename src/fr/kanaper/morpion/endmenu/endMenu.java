package fr.kanaper.morpion.endmenu;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import fr.kanaper.morpion.component.KanButton;
import fr.kanaper.morpion.enums.KanButtonType;
import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.jeu.Player;

/**
 * Classe permettant de créer un menu de fin de partie
 * 
 * @version 1.0
 * @author Kanaper
 */
public class endMenu extends JDialog {

    private final int WIDTH = 600;
    private final int HEIGHT = 300;

    /**
     * Constructeur de la classe endMenu
     * 
     * @param gameWindow fenêtre de jeu
     * @param player     joueur gagnant
     */
    public endMenu(Game gameWindow, Player player) {
        super(gameWindow, "Fin de partie", true);

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        JLabel title;

        if (player == null) {
            title = new JLabel("Égalité !");
        } else {
            title = new JLabel("Les " + player.toString() + " ont gagné !");
        }

        title.setBounds(50, 20, 500, this.HEIGHT / 4);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(43f));
        System.out.println(title.getFont().getSize());
        this.add(title);

        KanButton restartButton = new KanButton("Rejouer", KanButtonType.RESTART, gameWindow);
        restartButton.setWidth(200);
        restartButton.setHeight(100);
        restartButton.setBounds(this.WIDTH / 2 - (restartButton.getWidth() + 50), this.HEIGHT / 2,
                restartButton.getWidth(),
                restartButton.getHeight());
        restartButton.addActionListener(new endMenuButtonListener(KanButtonType.RESTART, gameWindow));
        this.add(restartButton);

        KanButton quitButton = new KanButton("Quitter", KanButtonType.QUIT, gameWindow);
        quitButton.setWidth(200);
        quitButton.setHeight(100);
        quitButton.setBounds(this.WIDTH / 2 + 50, this.HEIGHT / 2, quitButton.getWidth(), quitButton.getHeight());
        quitButton.addActionListener(new endMenuButtonListener(KanButtonType.QUIT, gameWindow));
        this.add(quitButton);

        this.setVisible(true);
    }

}
