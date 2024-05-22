package entity.Zombie;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import entity.Entity;
import entity.Plant.Plant;
import screen.GameMap;
// import screen.move;
import screen.update.CustomListener;

public class Zombie extends Entity implements CustomListener {
    protected int x;
    public boolean is_slow;
    public int slowTime;
    public Image png;
    private String img;
    protected int y;
    protected Zombie zombie;
    int timer = 0;
    boolean is_die = false;
    boolean moving = true;
    Plant target;
    private Plant plant;
    public static ArrayList<Zombie> zombies = new ArrayList<Zombie>();

    public Zombie(String name, int health, boolean is_aquatic, int attackDamage, double attackSpeed, int x, int y,
            String img) {
        super(name, health, is_aquatic, attackDamage, attackSpeed);
        this.x = x;
        this.y = y;
        this.img = img;

    }

    public boolean getis_die() {
        return is_die;
    }

    public void attack(Plant plant) {
        if (plant != null) {
            plant.takedamage(attackDamage);
        }
    }

    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(health);
        if (health <= 0) {
            die();
        }
    }

    public void instant_kill(Plant plant) {
        plant.setHealth(0);
    }

    public void move() {
        if (moving) {
            x--;
        }
    }

    public int gety() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void drawZombie(Graphics2D gd) {
        try {
            png = new ImageIcon(img).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        gd.drawImage(png, x, y, GameMap.Tile_Size, GameMap.Tile_Size, null);
    }

    public void addZombie() {
        if (this.is_aquatic = true) {
            Zombie.zombies.add(zombie);
        } else {
            System.out.println("tidak dapat spawn zombie");
        }
    }

    public void die() {
        if (this.health == 0) {
            is_die = true;
            System.out.println(this.name + "died.");

        }
    }

    public void hitplant() {
        moving = true;
        for (Plant plant : Plant.plants) {
            if (x >= plant.getX() && x - 90 <= plant.getX() && y == plant.getY()) {
                target = plant;
                moving = false;

            }

        }
        // dipisah ngetakedamage dan ngecek
    }

    // public void cheker() {
    // for (Plant plant : Plant.plants) {
    // target = plant;
    // }
    // }

    // public void hit_damage() {

    // moving = true;
    // if (x >= plant.getX() && x - 90 <= plant.getX() && y == plant.getY()) {
    // moving = false;
    // }
    // }

    @Override
    public void actionPerformed() {

        hitplant();
        if (moving) {
            if (timer >= 1) {
                move();
                timer = 0;
            } else {
                timer++;
            }
        } else {
            if (timer >= 60) {
                target.takedamage(attackDamage);
                timer = 0;
            } else {
                timer++;
            }

        }

    }

}
