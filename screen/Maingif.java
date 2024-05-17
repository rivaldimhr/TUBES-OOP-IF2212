package screen;

import javax.swing.*;

import java.awt.BorderLayout;

public class Maingif {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GIF Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        ImageIcon gifIcon = new ImageIcon(
                "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\Basic Java plant vs Zombie\\image\\zombie_football.gif ");
        JLabel gifLabel = new JLabel(gifIcon);
        panel.add(gifLabel, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
