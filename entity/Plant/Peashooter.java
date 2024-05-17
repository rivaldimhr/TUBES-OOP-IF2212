package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Peashooter extends Plant {
    private int timer;

    public Peashooter(int x, int y) {
        super("Peashooter", 100, false, 25, 4, 100, -1, 10, x, y,
                "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\Basic Java plant vs Zombie\\image\\pea_shooter.gif");
    }

    public void attack() {
        spawnBullet();
    }

    private void spawnBullet() {
        Bullet bullet = new Bullet(x, y, attackDamage);
        Bullet.bullets.add(bullet);
    }

    @Override
    public void actionPerformed() {
        for (Zombie zombie : Zombie.zombies) {
            if (zombie.gety() == y) {
                if (timer >= 60) {
                    attack();
                    timer = 0;
                } else {
                    timer++;
                }

            }
        }
    }
}
