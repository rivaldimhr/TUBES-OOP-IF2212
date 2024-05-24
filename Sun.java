package menu;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Sun extends JPanel {
    public static RandomGenerator random = new Random();

    public static int randTimer = random.nextInt(5 * 60, 10 * 60);
    public static int sunTimer = 0;
    public static int totalSun = 50;

    public Sun() {
    }

    protected void drawSun(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Arial", Font.BOLD, 18);
        FontMetrics fm = g.getFontMetrics(font);
        Rectangle rect = new Rectangle(29, 58, 10, 10);
        String text = Integer.toString(totalSun);
        int x = rect.x + (rect.width - fm.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - fm.getHeight()) / 2) + fm.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    protected void drawTime(Graphics g) {
        super.paintComponent(g);
        Font font = new Font("Arial", Font.BOLD, 16);
        FontMetrics fm = g.getFontMetrics(font);
        Rectangle rect = new Rectangle(540, 18, 10, 10);
        String text = Integer.toString(GameLevel.time);
        int x = rect.x + (rect.width - fm.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - fm.getHeight()) / 2) + fm.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }

    // Selalu add sun sebanyak 25
    public void autoSun() {
        sunTimer++;
        if (sunTimer >= randTimer) {
            totalSun += 25;
            sunTimer = 0;
            rerollTimer();
        }
    }

    // Kurangi sun dengan cost
    public void subtractSun(int cost) {
        totalSun -= cost;
    }

    // Kalau perlu tambah sun
    public void addSun(int i) {
        totalSun += i;
    }

    // Return totalSun
    public int getSun() {
        return totalSun;
    }

    public int getRandTimer() {
        return randTimer;
    }

    public int getSunTimer() {
        return randTimer;
    }

    public void rerollTimer() {
        randTimer = random.nextInt(5 * 60, 10 * 60);
    }
}