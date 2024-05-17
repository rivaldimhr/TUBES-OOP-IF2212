package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Puffshroom extends Plant {
    private int timer;

    public Puffshroom(int x, int y) {
        super("Puffshroom", 70, false, 25, 4, 0, 3, 10, x, y,
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
                if (timer >= 120) {
                    attack();
                    timer = 0;
                } else {
                    timer++;
                }

            }
        }
    }
}
