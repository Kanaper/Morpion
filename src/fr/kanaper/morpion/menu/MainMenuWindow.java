package fr.kanaper.morpion.menu;

import javax.swing.JFrame;

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
        this.getContentPane().setBackground(new Color(200, 200, 200));

        MainMenuTitle title = new MainMenuTitle();
        this.add(title);

        MainMenuButton button = new MainMenuButton(this);
        button.setBounds(100, 300, WIDTH - 200, HEIGHT - 400);
        this.add(button);
    }
}
