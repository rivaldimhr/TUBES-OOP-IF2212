package entity.Zombie;

public class PoleValuting extends Zombie {
    boolean instant_kill = false;

    public PoleValuting(int x, int y) {
        super("Pole Valuting Zombie", 250, false, 100, 1, x, y,
                "image\\Polerun.gif");
        // isi folder fotonya"");
        // TODO Auto-generated constructor stub
    }

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
            if (!instant_kill) {
                instant_kill(target);
                instant_kill = true;
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
}