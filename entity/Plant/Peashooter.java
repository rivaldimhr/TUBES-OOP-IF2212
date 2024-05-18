package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Projecttail.Peabullet;
import entity.Zombie.Zombie;

public class Peashooter extends Plant {
    private int timer;

    public Peashooter(int x, int y) {
        super("Peashooter", 100, false, 25, 2, 100, -1, 10, x, y,
                "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\TUBES OOP JAVA\\image\\pea_shooter.gif");
    }

    public void attack() {
        spawnpeashooter();
    }

    private void spawnpeashooter() {
        Bullet bullet = new Peabullet(x, y, attackDamage);
        Bullet.bullets.add(bullet);
    }

    @Override
    public void actionPerformed() {
        Boolean shoutable = true;
        if (timer >= 60) {
            for (Zombie zombie : Zombie.zombies) {
                if (zombie.gety() == y) {
                    if (shoutable) {
                        attack();
                        shoutable = false;
                        timer = 0;
                    }

                }
            }
        } else {
            timer++;
        }
    }
}
