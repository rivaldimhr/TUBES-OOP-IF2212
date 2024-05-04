public class SnowPea extends Plant {
    public static final double SLOWING_EFFECT = 0.5; // Mengurangi kecepatan sebesar 50%
    public static final int SLOW_DURATION = 3000; // Durasi pelambatan adalah 3000 ms (3 detik)

    public SnowPea() {
        super("Snow Pea", 175, 100, 25, 4, -1, 10);
    }

    // Metode untuk menyerang zombie
    public void attack(Zombie zombie) {
        if (zombie != null) {
            zombie.takeDamage(getAttackDamage());
            applySlowingEffect(zombie);
            System.out.println(getName() + " menyerang dan melambatkan " + zombie.getName());
        }
    }

    // Metode untuk menerapkan efek pelambatan
    private void applySlowingEffect(Zombie zombie) {
        // Efek tidak dapat ditumpuk, periksa apakah zombie sudah diperlambat
        if (!zombie.isSlowed()) {
            zombie.slow(SLOWING_EFFECT, SLOW_DURATION);
        }
    }
}
