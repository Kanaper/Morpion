package fr.kanaper.morpion.menu;

import javax.swing.JFrame;

import javax.swing.border.Border;
import javax.swing.BorderFactory;

import java.awt.Color;

public class MainMenuWindow extends JFrame {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 800;

    public MainMenuWindow() {
        this.setTitle("Main Menu");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        Border lineborder = BorderFactory.createLineBorder(Color.black, 1);

        MainMenuTitle title = new MainMenuTitle();
        // title.setBounds(0, 50, WIDTH, 150);
        title.setBorder(lineborder);
        this.add(title);

        MainMenuButton button = new MainMenuButton();
        button.setBounds(100, 300, WIDTH - 200, HEIGHT - 400);
        button.setBorder(lineborder);
        this.add(button);

        this.setVisible(true);
    }
}
