package entity.Projecttail;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import entity.Zombie.Zombie;
import screen.GameMap;
import screen.update.CustomListener;

public class Bullet implements CustomListener {
    private int x;
    private int y;
    private int damage;
    public boolean hit = false;
    public String img;
    private BufferedImage imageBullet;
    // private int timer = 0;
    public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public Bullet(int x, int y, int damage) {
        this.x = x;
        this.y = y;
        this.damage = damage;
        // loadImagePlant();
    }

    // udh tabrakan apa belum
    public void check_hit(Zombie zombie) {

        if (x <= zombie.getX() && x + 90 >= zombie.getX() && y == zombie.gety()) {
            zombie.takeDamage(damage);
            damage = 0;
            hit = true;
        }

    }

    public void drawBullet(Graphics2D g) {
        try {
            try {
                imageBullet = ImageIO.read(new File(img)); // Adjust
                // this
                // to
                // your
                // image
                // file
                // path
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (imageBullet != null) {
            g.drawImage(imageBullet, x, y, GameMap.Tile_Size, GameMap.Tile_Size, null);
        } else {
            System.err.println("Error: Bullet image is null.");
        }
    }

    // private void loadImagePlant() {
    // try {
    // imageBullet = ImageIO.read(new File(img)); // Adjust
    // // this
    // // to
    // // your
    // // image
    // // file
    // // path
    // } catch (IOException ex) {
    // ex.printStackTrace();
    // }
    // }

    @Override
    public void actionPerformed() {
        // TODO Auto-generated method stub
        // if (timer >= 5) {
        x += 3;
        for (Zombie zombie : Zombie.zombies) {
            check_hit(zombie);

        }
        // timer = 0;
        // } else {
        // timer++;
        // }
    }

}
