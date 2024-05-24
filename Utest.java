package update;

public class Utest {
    static int time = 0;

    public static void up() {
        if (time > 120) {
            System.out.println("2 detik");
            time = 0;
        } else {
            time++;
        }
    }
}
