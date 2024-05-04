public class Sunflower extends Plant {
    private static final int SUN_PRODUCTION_AMOUNT = 25; // Jumlah sun yang dihasilkan
    private static final int SUN_PRODUCTION_INTERVAL = 10; // Interval dalam detik
    private long lastProductionTime;

    // Constructor untuk Sunflower
    public Sunflower() {
        super("Sunflower", 50, 100, 0, 0, 0, 10);
        this.lastProductionTime = System.currentTimeMillis();
    }

    // Metode untuk menghasilkan sun
    public void produceSun() {
        System.out.println(getName() + " menghasilkan " + SUN_PRODUCTION_AMOUNT + " sun.");
        // Kode tambahan untuk menambah sun ke total resources pemain
    }

    // Ini adalah contoh method yang bisa dipanggil secara berkala untuk produksi

    // sun
    public void update() {
        long currentTime = System.currentTimeMillis();
        // Periksa apakah sudah waktunya untuk produksi sun
        if ((currentTime - lastProductionTime) / 1000 >= SUN_PRODUCTION_INTERVAL) {
            produceSun();
            lastProductionTime = currentTime; // Atur ulang waktu produksi terakhir
        }

    }

}
