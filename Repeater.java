package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Projecttail.Peabullet;
import entity.Zombie.Zombie;

public class Repeater extends Plant {
    private int timer;
    private int timer2;
    private Boolean shot1 = false;
    private boolean shot2 = false;

    public Repeater(int x, int y) {
        super("Repeater", 100, false, 25, 4, 200, -1, 10, x, y,
                "image\\repeater.gif");
    }

    public void attack() {
        spawnBullet();
    }

    private void spawnBullet() {
        Bullet bullet = new Peabullet(x, y, attackDamage);
        Bullet.bullets.add(bullet);
    }

    @Override
    public void actionPerformed() {
        Boolean shoutable = true;
        if (timer >= 60 && !shot1) {
            for (Zombie zombie : Zombie.zombies) {
                if (zombie.gety() == y) {
                    if (shoutable) {
                        attack();
                        shoutable = false;
                        shot1 = true;
                    }
                }
            }
        } else {
            timer++;
        }
        if (timer2 >= 70 && !shot2) {
            for (Zombie zombie : Zombie.zombies) {
                if (zombie.gety() == y) {
                    if (shoutable) {
                        attack();
                        shoutable = false;
                        shot2 = true;
                    }
                }
            }
        } else {
            timer2++;
        }
        if (shot1 && shot2) {
            timer = 0;
            timer2 = 0;
            shot1 = false;
            shot2 = false;
        }
    }
}
