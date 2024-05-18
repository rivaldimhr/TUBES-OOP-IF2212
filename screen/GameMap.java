package screen;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.random.RandomGenerator;
import entity.Plant.Plant;
import entity.Projecttail.Bullet;
import entity.Zombie.DolphinRider;
import entity.Zombie.Zombie;
import entity.Zombie.Zombiefootball;
import entity.Zombie.ConeHeadZombie;
import entity.Zombie.NormalZombie;
import screen.update.CustomListener;

public class GameMap extends JPanel implements Runnable {
    // Gamme State
    public int gamestate;
    public final int playstate = 1;
    public final int pausestate = 2;
    public final int win = 3;
    public final int lose = 4;
    public final int plantlis = 5;
    public final int zombielist = 6;
    public final int help = 7;

    public static Zombie[] zombies;
    public static final int Tile_Size = 60;
    public static final int Col = 11;
    public static final int Row = 7;
    public static final int Width = Tile_Size * Col;
    public static final int Height = Tile_Size * Row;
    private KeyHandler keyH = new KeyHandler(this);
    private int Speed = 2;
    private int timer = 0;
    private int time = 0;
    private CustomListener listener;
    private int fps = 60;
    int playerX = 100;
    int playerY = 100;
    double playerSpeedX;
    double playerSpeedY;
    public BufferedImage background;
    private Thread gameThread;
    int x;
    RandomGenerator random = new Random();
    int tileX = 0;
    int tileY = Tile_Size;
    int selectedX, selectedY;
    public Image GameOver;
    public String imageGameover;
    public Sun sun = new Sun();

    public GameMap() {
        setLayout(new GridLayout(Row, Col));
        this.setPreferredSize(new Dimension(Width, Height));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        loadBackgroundImage();
        gamestate = playstate;
    }

    private void loadBackgroundImage() {
        try {
            this.background = ImageIO.read(new File(
                    "image\\background_day.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawbackground(Graphics2D g) {
        if (background != null) {
            g.drawImage(background, 0, 0, Width, Height, this);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, Width, Height);
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setPlayerPosition(int x, int y) {
        this.playerX = (x / Tile_Size) * Tile_Size;
        this.playerY = (y / Tile_Size) * Tile_Size;
        repaint();
    }

    @Override
    public void run() {

        double interval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currettime;
        while (gameThread != null) {
            currettime = System.nanoTime();
            delta += (currettime - lastTime) / interval;
            lastTime = currettime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        // if (keyH.numPressed == true){
        // keyH.numPressed = false;
        // int plantIndex = keyH.numKey;
        // switch (plantIndex) {
        // case 1:
        // PlantSpawner.spawn(new Cactus(selectedX, selectedY));
        // break;
        // case 2:
        // PlantSpawner.spawn(new IceShroom(selectedX, selectedY));
        // break;
        // case 3:
        // PlantSpawner.spawn(new Jalapeno(selectedX, selectedY));
        // break;
        // case 4:
        // PlantSpawner.spawn(new Lilypad(selectedX, selectedY));
        // break;
        // case 5:
        // PlantSpawner.spawn(new PeaShooter(selectedX, selectedY));
        // break;
        // case 6:
        // PlantSpawner.spawn(new SnowPea(selectedX, selectedY));
        // break;
        // case 7:
        // GameMap.plants.removeIf(plant -> plant.getX() == selectedX && plant.getY() ==
        // selectedY);
        // break;
        // }

        if (time >= 200) {
            if (Zombie.zombies.size() <= 0) {
                gamestate = win;
            } else {
                gamestate = lose;

            }
        } else {
            for (Zombie zombie : Zombie.zombies) {
                if (zombie.getX() == 0) {
                    gamestate = lose;

                    break;
                }
            }
        }

        if (timer >= 60) {
            time++;
            System.out.println(time);
            if (Zombie.zombies.size() < 10) {
                int y = random.nextInt(1, 7);
                if (y == 3 || y == 4) {
                    int x = random.nextInt(1, 2);
                    switch (x) {
                        case 1:
                            Zombie.zombies.add(new DolphinRider(10 * Tile_Size, y * Tile_Size));
                            break;
                    }
                } else {
                    int x = random.nextInt(1, 4);
                    switch (x) {
                        case 1:
                            Zombie.zombies.add(new Zombiefootball(10 * Tile_Size, y * Tile_Size));
                            break;
                        case 2:
                            Zombie.zombies.add(new ConeHeadZombie(10 * Tile_Size, y * Tile_Size));
                            break;
                        case 3:
                            Zombie.zombies.add(new NormalZombie(10 * Tile_Size, y * Tile_Size));
                            break;
                    }
                }
            }
            timer = 0;
        } else {
            timer++;
        }

        if (time%200<=100) {
            sun.autoSun();
        }

        if (keyH.upPressed) {
            keyH.upPressed = false;
            if (tileY == Tile_Size) {
                tileY = (Row - 1) * Tile_Size;
            } else {
                tileY -= Tile_Size;
            }
        } else if (keyH.downPressed) {
            keyH.downPressed = false;
            if (tileY == (Row - 1) * Tile_Size) {
                tileY = Tile_Size;
            } else {
                tileY += Tile_Size;
            }
        } else if (keyH.leftPressed) {
            keyH.leftPressed = false;
            if (tileX == 0) {
                tileX = (Col - 1) * Tile_Size;
            } else {
                tileX -= Tile_Size;
            }
        } else if (keyH.rightPressed) {
            keyH.rightPressed = false;
            if (tileX == (Col - 1) * Tile_Size) {
                tileX = 0;
            } else {
                tileX += Tile_Size;
            }
        } else if (keyH.enterPressed) {
            keyH.enterPressed = false;
            selectedX = tileX;
            selectedY = tileY;
            System.out.println("X:" + selectedX + "Y:" + selectedY);
        }

        Iterator<Bullet> bulletIterator = Bullet.bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            this.listener = bullet;
            listener.actionPerformed();
            if (bullet.hit) {
                bulletIterator.remove();
            }
        }
        Iterator<Zombie> zombieIterator = Zombie.zombies.iterator();
        while (zombieIterator.hasNext()) {
            Zombie zombie = zombieIterator.next();
            this.listener = zombie;
            listener.actionPerformed();
            if (zombie.getis_die()) {
                zombieIterator.remove();
            }
        }
        Iterator<Plant> plantIterator = Plant.plants.iterator();
        while (plantIterator.hasNext()) {
            Plant plant = plantIterator.next();
            this.listener = plant;
            listener.actionPerformed();
            if (plant.is_die()) {
                plantIterator.remove();
            }
        }
    }

    public void drawGameOver(Graphics2D gd) {
        try {
            GameOver = ImageIO.read(new File(
                    "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\TUBES OOP JAVA\\image\\cursor.png"));
        } catch (Exception e) {
        }

        gd.drawImage(GameOver, GameMap.Tile_Size, GameMap.Tile_Size, null);
    }

    private void stopPlayerMovement() {
        playerSpeedX = 0;
        playerSpeedY = 0;
    }

    // private void movePlayerTowards(int lastMouseX, int lastMouseY) {
    // playerX += (lastMouseX - playerX) * 0.1;
    // playerY += (lastMouseY - playerY) * 0.1;
    // }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawbackground(g2);
        // drawPlayer(g2);
        // for (Bullet bullet : Bullet.bullets) {
        // bullet.drawBullet(g2);
        // }
        // for (Plant plant : Plant.plants) {
        // plant.drawPlant(g2);
        // }
        // for (Zombie zombie : Zombie.zombies) {
        // zombie.drawZombie(g2);
        // }
        for (int i = 0; i < Zombie.zombies.size(); i++) {
            if (Zombie.zombies.get(i) != null) {
                Zombie.zombies.get(i).drawZombie(g2);
            }
        }
        for (int i = 0; i < Plant.plants.size(); i++) {
            if (Plant.plants.get(i) != null) {
                Plant.plants.get(i).drawPlant(g2);
            }
        }
        for (int i = 0; i < Bullet.bullets.size(); i++) {
            if (Bullet.bullets.get(i) != null) {
                Bullet.bullets.get(i).drawBullet(g2);
            }
        }
        sun.drawSun(g2);
        drawkursor(g2);
    }

    public void drawkursor(Graphics2D gd) {
        // private void drawPlayer(Graphics2D g) {
        // g.fillRect(playerX, playerY, Tile_Size, Tile_Size);
        // }
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(
                    "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\TUBES OOP JAVA\\image\\cursor.png"));
        } catch (Exception e) {
        }

        gd.drawImage(img, tileX, tileY, Tile_Size, Tile_Size, null);
    }
}
