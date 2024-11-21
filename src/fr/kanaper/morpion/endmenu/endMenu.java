package fr.kanaper.morpion.endmenu;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import fr.kanaper.morpion.component.KanButton;
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

        if (player == null) {
            JLabel title = new JLabel("Égalité !");
            title.setBounds(25, 20, 350, 30);
            title.setHorizontalAlignment(JLabel.CENTER);
            title.setFont(title.getFont().deriveFont(20.0f));
            this.add(title);

            KanButton restartButton = new KanButton("Rejouer", 80, 40);
            restartButton.setBounds(75, 60, 100, 50);
            this.add(restartButton);

            KanButton quitButton = new KanButton("Quitter", 80, 40);
            quitButton.setBounds(200, 60, 100, 50);
            this.add(quitButton);
        } else {
            JLabel title = new JLabel("Le joueur " + player.getPlayerType().toString() + " a gagné !");
            title.setBounds(25, 20, 350, 30);
            title.setHorizontalAlignment(JLabel.CENTER);
            title.setFont(title.getFont().deriveFont(20.0f));
            this.add(title);

            KanButton restartButton = new KanButton("Rejouer", 80, 40);
            restartButton.setBounds(75, 60, 100, 50);
            this.add(restartButton);

            KanButton quitButton = new KanButton("Quitter", 80, 40);
            quitButton.setBounds(200, 60, 100, 50);
            this.add(quitButton);
        }

        this.setVisible(true);
    }

}
