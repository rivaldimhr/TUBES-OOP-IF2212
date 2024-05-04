import java.util.Random;

public class ZombieSpawner {
    private Random random;
    private double spawnProbability = 0.3; // Probabilitas 30% untuk munculnya zombie

    public ZombieSpawner() {
        this.random = new Random();
    }

    // Coba memunculkan zombie. Metode ini dipanggil setiap detik atau pada setiap
    // tick dari game loop
    public Zombie trySpawnZombie() {
        if (random.nextDouble() < spawnProbability) {
            return createRandomZombie();
        }
        return null; // Tidak ada zombie yang muncul kali ini
    }

    // // Membuat zombie secara acak
    // private Zombie createRandomZombie() {
    // // Anggap ada tiga jenis zombie: NormalZombie, FastZombie, and WaterZombie
    // // Setiap zombie memiliki speed yang sama, 5 detik per petak
    // int zombieType = random.nextInt(3); // Menghasilkan angka 0, 1, atau 2 secara
    // acak
    // switch (zombieType) {
    // case 0:
    // return new NormalZombie("Normal Zombie", 125, 100, 1, false, 5);
    // case 1:
    // return new Zombie("Fast Zombie", 100, 120, 0.5, false, 5);
    // case 2:
    // return new Zombie("Water Zombie", 150, 90, 1.5, true, 5);
    // default:
    // return new NormalZombie("Normal Zombie", 125, 100, 1, false, 5);
    // }
    // }
}
