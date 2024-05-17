package entity.Plant;

import screen.GameMap;
import screen.update.CustomListener;
import entity.Entity;
import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;
import javax.swing.ImageIcon;
import java.awt.Image;

// import screen.MouseHandler;
import java.io.IOException;
import java.util.ArrayList;

//customlistener fungsinya untuk dipannggil sama update 
public class Plant extends Entity implements CustomListener {
    protected int cost;
    protected int cooldown;
    protected int range;
    protected Plant plant;
    boolean is_die = false;
    public Image png;
    protected int x;
    protected int y;
    private String img;
    private int timer = 0;
    public static ArrayList<Plant> plants = new ArrayList<Plant>();

    public Plant(String name, int health, boolean is_aquatic, int attackDamage, int attackSpeed, int cost, int range,
            int cooldown, int x, int y, String img) {
        super(name, health, is_aquatic, attackDamage, attackSpeed);
        this.cost = cost;
        this.cooldown = cooldown;
        this.range = range;
        this.x = x;
        this.y = y;
        this.img = img;
        // setDefaultvalues();

    }

    public void setDefaultvalues() {
        x = 100;
        y = 10;
        attackSpeed = 4;
    }

    public void takedamage(int amount) {
        health -= amount;
        if (health <= 0) {
            die();
        }
    }

    public void attack() {
    }

    public void rangezombie(Zombie zombie) {
        if (y == zombie.gety()) {
            attack();
        }
    }

    public boolean is_die() {
        return is_die;
    }

    public void die() {
        if (this.health == 0) {
            is_die = true;
            System.out.println(this.name + "died.");

        }
    }

    public <png> void drawPlant(Graphics2D gd) {
        try {
            png = new ImageIcon(img).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        gd.drawImage(png, x, y, GameMap.Tile_Size, GameMap.Tile_Size, null);
    }

    public void addPlant(Plant plant) {

        if (this.is_aquatic = true) {
            Plant.plants.add(plant);// menanam tanaman menggunakan dik
        } else {
            System.out.println("tidak dapat menanam di area ini");
        }
    }

    // getter and setter
    public int getCost() {
        return this.cost;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getCooldown() {
        return this.cooldown;
    }

    public int getRange() {
        return this.range;
    }
    // getarea air, darat, safezone, spawn zombie

    @Override
    public void actionPerformed() {

    }

}
