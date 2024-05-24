package update;

public class Listentest implements CustomListener {

    private int time = 0;

    @Override
    public void actionPerformed() {
        if (time > 60) {
            System.out.println("1 detik");
            time = 0;
        } else {
            time++;
        }
    }
}