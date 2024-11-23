package fr.kanaper.morpion.endmenu;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import fr.kanaper.morpion.component.KanButton;
import fr.kanaper.morpion.enums.KanButtonType;
import fr.kanaper.morpion.jeu.Game;
import fr.kanaper.morpion.jeu.Player;

public class endMenu extends JDialog {

    public endMenu(Game gameWindow, Player player) {
        super(gameWindow, "Fin de partie", true);

        this.setSize(400, 200);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        JLabel title;

        if (player == null) {
            title = new JLabel("Égalité !");
        } else {
            title = new JLabel("Les " + player.getPlayerType().toString() + " ont gagné !");
        }

        title.setBounds(25, 20, 350, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(20.0f));
        this.add(title);

        KanButton restartButton = new KanButton("Rejouer", KanButtonType.RESTART, gameWindow);
        restartButton.setWidth(80);
        restartButton.setHeight(30);
        restartButton.setBounds(75, 60, restartButton.getWidth(), restartButton.getHeight());
        restartButton.addActionListener(new endMenuButtonListener(KanButtonType.RESTART, gameWindow));
        this.add(restartButton);

        KanButton quitButton = new KanButton("Quitter", KanButtonType.QUIT, gameWindow);
        quitButton.setWidth(80);
        quitButton.setHeight(30);
        quitButton.setBounds(200, 60, quitButton.getWidth(), quitButton.getHeight());
        quitButton.addActionListener(new endMenuButtonListener(KanButtonType.QUIT, gameWindow));
        this.add(quitButton);

        this.setVisible(true);
    }

}
