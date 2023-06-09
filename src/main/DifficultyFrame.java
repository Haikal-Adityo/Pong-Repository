package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DifficultyFrame extends JFrame {
    static final int screenWidth = 1000;
    static final int screenHeight = (int)(screenWidth * (0.5555));
    static final Dimension screenSize = new Dimension(screenWidth,screenHeight);
    public static GameFrame gameFrame;
    public static JFrame frame;
    SoundEffect soundEffect = new SoundEffect();

    public int easy = 1;
    public int medium = 2;
    public int hard = 3;

    public DifficultyFrame(){

        Color grey = new Color(17, 17, 17);

        frame = new JFrame();
        frame.setTitle("PONG");
        frame.setSize(screenSize);
        frame.setBackground(grey);

        JPanel gameMenu = new JPanel();
        gameMenu.setLayout(new BorderLayout());
        gameMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
        gameMenu.setBackground(grey);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(3, 1, 10, 20));
        btnPanel.setBackground(grey);

        JLabel difficultyTitle = new JLabel("DIFFICULTY", SwingConstants.CENTER);
        difficultyTitle.setForeground(Color.white);
        difficultyTitle.setFont(new Font( Main.pixelType.getName(), Font.BOLD, 100));

        JButton easyButton = new JButton("EASY");
        easyButton.setFont(new Font(Main.pixelType.getName(), Font.BOLD, Main.isFullScreen ? 30 : 25));
        easyButton.setBackground(grey);
        easyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        easyButton.setForeground(Color.WHITE);
        easyButton.setFocusable(false);
        easyButton.setPreferredSize(new Dimension(200, 50));
        easyButton.addActionListener(actionEvent -> {

            playSE(3);

            frame.dispose();

            GamePanel.gameDifficulty = easy; // 1

            System.out.println("Difficulty: " + GamePanel.gameDifficulty);
            gameFrame = new GameFrame();

            if (Main.isFullScreen) {
                gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }

        });

        JButton mediumButton = new JButton("MEDIUM");
        mediumButton.setFont(new Font(Main.pixelType.getName(), Font.BOLD, Main.isFullScreen ? 30 : 25));
        mediumButton.setPreferredSize(new Dimension(200, 50));
        mediumButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mediumButton.setBackground(grey);
        mediumButton.setForeground(Color.WHITE);
        mediumButton.setFocusable(false);
        mediumButton.addActionListener(actionEvent -> {

            playSE(3);

            frame.dispose();
            GamePanel.gameDifficulty = medium; // 2

            System.out.println("Difficulty: " + GamePanel.gameDifficulty);
            gameFrame = new GameFrame();

            if (Main.isFullScreen) {
                gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        JButton hardButton = new JButton("HARD");
        hardButton.setFont(new Font(Main.pixelType.getName(), Font.BOLD, Main.isFullScreen ? 30 : 25));
        hardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hardButton.setBackground(grey);
        hardButton.setPreferredSize(new Dimension(200, 50));
        hardButton.setForeground(Color.WHITE);
        hardButton.setFocusable(false);
        hardButton.addActionListener(actionEvent -> {

            playSE(3);

            frame.dispose();
            GamePanel.gameDifficulty = hard; // 3

            System.out.println("Difficulty: " + GamePanel.gameDifficulty);
            gameFrame = new GameFrame();

            if (Main.isFullScreen) {
                gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        btnPanel.add(easyButton);
        btnPanel.add(mediumButton);
        btnPanel.add(hardButton);

        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 45, 5));
        layout.setBackground(grey);

        JPanel labelLayout = new JPanel(new GridBagLayout());
        labelLayout.setBorder(new EmptyBorder(60, 5, 15, 5));
        labelLayout.setBackground(grey);

        labelLayout.add(difficultyTitle);
        layout.add(btnPanel);

        gameMenu.add(labelLayout, BorderLayout.NORTH);
        gameMenu.add(layout, BorderLayout.CENTER);

        if (Main.isFullScreen) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        frame.add(gameMenu);
//        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void playSE(int i) {

        soundEffect.setFile(i);
        soundEffect.play();
    }

}