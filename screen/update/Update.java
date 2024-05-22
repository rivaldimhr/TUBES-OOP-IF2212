package screen.update;

public class Update implements Runnable {
    Thread gamThread;
    int fps = 60;
    int i = 0;
    private CustomListener listener;
    Listentest listentest = new Listentest();

    public void setCustomListener(CustomListener listener) {
        this.listener = listener;
    }

    public void doSomething() {
        // Trigger the listener's actionPerformed method
        if (listener != null) {
            listener.actionPerformed();
        }
    }

    public void StartUpdate() {
        gamThread = new Thread(this);
        gamThread.start();
    }

    @Override
    public void run() {
        double interval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        Long currettime;
        while (gamThread != null) {
            currettime = System.nanoTime();
            delta += (currettime - lastTime) / interval;
            lastTime = currettime;
            if (delta >= 1) {
                Updategame();
                delta--;
            }

        }
    }

    public void Updategame() {
        Utest.up();
        // Taruh yang mau di update di sini
        this.setCustomListener(listentest);
        this.doSomething();
    }

}
