package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Tallnut extends Plant {
    private int timer;

    public Tallnut(int x, int y) {
        super("Tall-nut", 2000, false, 0, 0, 125, 0, 20, x, y,
                "image\\TallNut1.gif");
    }

    public void attack() {
        // spawnBullet();
    }

    // private void spawnBullet() {
    // Bullet bullet = new Bullet(x, y, attackDamage);
    // Bullet.bullets.add(bullet);
    // }

    @Override
    public void actionPerformed() {

    }
}
