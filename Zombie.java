import javax.swing.*;
import java.awt.*;

public class Zombie extends JPanel {
    protected String name;
    protected int health;
    protected int attackDamage;
    protected double attackSpeed;
    protected boolean is_Aquatic;
    protected double speed;
    protected ImageIcon imageIcon;
    long slowingExpirationTime = 0;
    long lastAttackTime = System.currentTimeMillis();

    public Zombie(String name, int health, int attackDamage, double attackSpeed, boolean is_Aquatic, double speed,
            String imagePath) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.is_Aquatic = is_Aquatic;
        this.speed = speed;
        this.imageIcon = new ImageIcon(imagePath);
        setPreferredSize(new Dimension(100, 100));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        imageIcon.paintIcon(this, g, 0, 0);
    }

    public void attack(Plant plant) {
        if (plant != null) {
            plant.takeDamage(attackDamage);
            // System.out.println(name + " menyerang " + plant.getName() + " dengan damage "
            // + attackDamage);
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        // System.out.println(name + " menerima damage, sisa darah: " + health);
        if (health <= 0) {
            die();
        }
    }

    // Placeholder for moving the zombie
    public void move() {
        Point pos = getLocation();
        pos.x -= (int) speed;
        setLocation(pos);
        repaint();
    }

    public void update(Plant plant) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAttackTime >= attackSpeed * 1000) {
            attack(plant); // Perlu objek plant untuk menyerang
            lastAttackTime = currentTime;
        }
    }

    public void slow(double effect, int duration) {
        speed *= effect;
        slowingExpirationTime = System.currentTimeMillis() + duration;
        System.out.println(name + " diperlambat.");
    }

    public boolean isSlowed() {
        return System.currentTimeMillis() < slowingExpirationTime;
    }

    public void die() {
        System.out.println(this.name + " has died.");
        DeadActor.handleDeath(this);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    // public boolean isAquatic() {
    // return is_aquatic;
    // }
    public boolean isAquatic() {
        return is_Aquatic;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
