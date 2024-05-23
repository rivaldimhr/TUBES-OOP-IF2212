package entity.Plant;

import entity.Projecttail.Bullet;
import entity.Zombie.Zombie;

public class Squash extends Plant {
    private int timer;
    private boolean instant_kill = false;
    private String move;
    private boolean first = true;
    private final int RANGE = 120; // Range within which Squash can kill zombies
    private boolean instantKill = false;

    public Squash(int x, int y) {
        super("Squash", 100, false, 5000, 0, 50, 1, 20, x, y,
                "image\\Squash.gif");
    }

    @Override
    public void actionPerformed() {
        hitzombie();
    }

    // private void move() {
    //     if (moveRight) {
    //         if (x != 120) {
    //             x++; // Move to the right
    //         }
    //     } else {
    //         x--; // Move to the left
    //     }
    // }
    
    public void instant_kill(Zombie zombie) {
        zombie.setHealth(0);
    }

    public void hitzombie() {
        for (Zombie zombie : Zombie.zombies) {
            if (x - zombie.getX() <= RANGE && y == zombie.gety() && (move=="back" || first)) {
                zombie.takeDamage(zombie.getHealt()); // Instant kill
                instantKill = true;
                move="back";
                first = false;
            } else if (zombie.getX() - x <= RANGE && y == zombie.gety() && (move=="front" || first)) {
                zombie.takeDamage(zombie.getHealt()); // Instant kill
                instantKill = true;
                move="front";
                first = false;
            }
        }
        if (instantKill) {
            this.setHealth(0);; // Squash dies after killing zombies
        }
    }
}
