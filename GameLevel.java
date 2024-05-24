package menu;

import entity.Plant.*;
import java.awt.image.BufferedImage;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.random.RandomGenerator;

import entity.*;
import entity.Zombie.*;
import entity.Projecttail.*;
import update.CustomListener;

public class GameLevel extends JPanel implements Runnable {
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
    private KeyHandler keyH;
    private int Speed = 2;
    private int timer = 0;
    public static int time = 0;
    private CustomListener listener;
    private int fps = 60;
    int playerX = 100;
    int playerY = 100;
    double playerSpeedX;
    double playerSpeedY;
    public BufferedImage background_day;
    public BufferedImage background_night;
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
    private Game game;
    public boolean cek_time = false;
    boolean plantable;
    private boolean is_aquatic;
    private static BufferedImage[] plantCards = new BufferedImage[6];

    public GameLevel(Game game) {
        setLayout(new GridLayout(Row, Col));
        this.game = game;
        this.setPreferredSize(new Dimension(Width, Height));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        loadBackgroundImage();
        gamestate = playstate;
    }

    public static void updatePlantCards() {
        int i = 0;
        for (String name : Inventory2.getSelectedPlants()) {
            plantCards[i] = getImage(name);
            i++;
        }
    }

    private static BufferedImage getImage(String filepath) {
        BufferedImage img = null;

        try {
            InputStream is = new FileInputStream(new File(filepath));
            img = ImageIO.read(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    private void loadBackgroundImage() {
        try {
            this.background_day = ImageIO.read(new File(
                    "image\\IMAGE\\BACKGROUND DAY.png"));
            this.background_night = ImageIO.read(new File("image\\IMAGE\\BACKGROUND NIGHT.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        drawbackground(g);
        drawCards(g);
        sun.drawSun(g);
        sun.drawTime(g);

        for (int i = 0; i < Zombie.zombies.size(); i++) {
            if (Zombie.zombies.get(i) != null) {
                Zombie.zombies.get(i).drawZombie(g);
            }
        }
        for (int i = 0; i < Plant.plants.size(); i++) {
            if (Plant.plants.get(i) != null) {
                Plant.plants.get(i).drawPlant(g);
            }
        }
        for (int i = 0; i < Bullet.bullets.size(); i++) {
            if (Bullet.bullets.get(i) != null) {
                Bullet.bullets.get(i).drawBullet(g);
            }
        }

        drawkursor(g);

    }

    private void drawCards(Graphics g) {
        int xOffset = 50;
        for (int i = 0; i < 6; i++) {
            if (Inventory2.getcooldown(i) <= 0) {
                g.drawImage(plantCards[i], 77 + i * xOffset, 9, 40, 57, null);
            } else {
                Inventory2.substractcooldown(i, Inventory2.getcooldown(i) - 1);
            }
        }
    }

    public void drawbackground(Graphics g) {
        if (background_day != null && background_night != null) {
            Graphics2D g2d = (Graphics2D) g;
            if (time % 200 <= 80) {
                g2d.drawImage(background_day, 0, 0, Width, Height, this);
            } else if (time % 200 > 80 && time % 200 <= 100) {
                float alpha = (time % 200 - 80) / 20f;
                g2d.drawImage(background_day, 0, 0, Width, Height, this);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                g2d.drawImage(background_night, 0, 0, Width, Height, this);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            } else if (time % 200 > 100 && time % 200 <= 180) {
                g2d.drawImage(background_night, 0, 0, Width, Height, this);
            } else if (time % 200 > 180 && time % 200 <= 200) {
                float alpha = (time % 200 - 180) / 20f;
                g2d.drawImage(background_night, 0, 0, Width, Height, this);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                g2d.drawImage(background_day, 0, 0, Width, Height, this);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
            }
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

        for (Zombie z : Zombie.getZombies()) {
            if (z.getX() <= 60) {
                System.exit(0);
            }
        }

        if (time >= 200 && Zombie.getZombies().isEmpty()) {
            System.exit(0);
        }

        keyH = GameScreen.keyH;
        if (cek_time) {
            plantable = true;
            if (selectedY == 180 || selectedY == 240) {
                is_aquatic = true;
            } else {
                is_aquatic = false;
            }

            if (selectedX == 0 || selectedX == 600) {
                plantable = false;
            }
            for (Plant plant : Plant.plants) {
                if (selectedX == plant.getX() && selectedY == plant.getY()) {
                    plantable = false;
                }
                if (plant.getName() == "Lilypad" && selectedX == plant.getX() && selectedY == plant.getY()) {
                    plantable = true;
                    is_aquatic = false;
                } else if (selectedY == 180 || selectedY == 240) {
                    is_aquatic = true;
                }
            }
            if (keyH.numPressed && keyH.numkey == 7) {
                for (Plant plant : Plant.plants) {
                    if (selectedX == plant.getX() && selectedY == plant.getY()) {
                        Plant.plants.remove(plant);
                        for (Plant plant2 : Plant.plants) {
                            if (selectedX == plant.getX() && selectedY == plant.getY()) {
                                Plant.plants.remove(plant2);
                                break;
                            }
                        }
                        break;
                    }
                }
                plantable = true;
            }
            if (keyH.numPressed == true && plantable) {
                keyH.numPressed = false;
                int plantIndex = keyH.numkey;
                if (plantIndex > 0 && plantIndex <= Inventory2.getSelectedPlants().size()) {
                    String namaplant = Inventory2.getSelectedPlants().get(plantIndex - 1);
                    System.out.println(Inventory2.getSelectedPlants().get(plantIndex - 1));
                    switch (namaplant) {
                        case "image/IMAGE/Wall-Nut.png":
                            if (sun.getSun() >= 50 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Wallnut wallnut = new Wallnut(selectedX, selectedY);
                                Plant.plants.add(wallnut);
                                Inventory2.setcooldown(plantIndex - 1, wallnut.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Peashooter.png":
                            if (sun.getSun() >= 100 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Peashooter peashooter = new Peashooter(selectedX, selectedY);
                                Plant.plants.add(peashooter);
                                Inventory2.setcooldown(plantIndex - 1, peashooter.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Sunflower.png":
                            if (sun.getSun() >= 50 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Sunflower sunflower = new Sunflower(selectedX, selectedY);
                                Plant.plants.add(sunflower);
                                Inventory2.setcooldown(plantIndex - 1, sunflower.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Tall-Nut.png":
                            if (sun.getSun() >= 125 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Tallnut tallnut = new Tallnut(selectedX, selectedY);
                                Plant.plants.add(tallnut);
                                Inventory2.setcooldown(plantIndex - 1, tallnut.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Puff-Shroom.png":
                            if (sun.getSun() >= 0 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Puffshroom puffshroom = new Puffshroom(selectedX, selectedY);
                                Plant.plants.add(puffshroom);
                                Inventory2.setcooldown(plantIndex - 1, puffshroom.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Squash.png":
                            if (sun.getSun() >= 50 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Squash squash = new Squash(selectedX, selectedY);
                                Plant.plants.add(squash);
                                Inventory2.setcooldown(plantIndex - 1, squash.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Lily Pad.png":
                            if (sun.getSun() >= 25 && is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Lilypad lilypad = new Lilypad(selectedX, selectedY);
                                Plant.plants.add(lilypad);
                                Inventory2.setcooldown(plantIndex - 1, lilypad.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Repeater.png":
                            if (sun.getSun() >= 200 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Repeater repeater = new Repeater(selectedX, selectedY);
                                Plant.plants.add(repeater);
                                Inventory2.setcooldown(plantIndex - 1, repeater.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Tangle Kelp.png":
                            if (sun.getSun() >= 50 && is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                TangleKelp tanglekelp = new TangleKelp(selectedX, selectedY);
                                Plant.plants.add(tanglekelp);
                                Inventory2.setcooldown(plantIndex - 1, tanglekelp.getCooldown());
                            }
                            break;
                        case "image/IMAGE/Snow Pea.png":
                            if (sun.getSun() >= 175 && !is_aquatic && Inventory2.getcooldown(plantIndex - 1) <= 0) {
                                Snowpea snowpea = new Snowpea(selectedX, selectedY);
                                Plant.plants.add(snowpea);
                                Inventory2.setcooldown(plantIndex - 1, snowpea.getCooldown());
                            }
                            break;

                    }
                }
            }

            // case 7:
            // gameLevel.plants.removeIf(plant -> plant.getX() == selectedX && plant.getY()
            // ==
            // selectedY);
            // break;

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
                // if(time >= 20){
                // System.out.println(time);
                if (Zombie.zombies.size() < 10) {
                    int y = random.nextInt(1, 7);
                    if (y == 3 || y == 4) {
                        int x = random.nextInt(1, 5);
                        switch (x) {
                            case 1:
                                Zombie.zombies.add(new DolphinRider(10 * Tile_Size, y * Tile_Size));
                                break;
                            case 2:
                                Zombie.zombies.add(new DuckyTube(10 * Tile_Size, y * Tile_Size));
                                break;
                            case 3:
                                Zombie.zombies.add(new DuckyTubeConeHead(10 * Tile_Size, y * Tile_Size));
                                break;
                            case 4:
                                Zombie.zombies.add(new Snorkel(10 * Tile_Size, y * Tile_Size));
                                break;
                        }
                    } else {
                        int x = random.nextInt(1, 7);
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
                            case 4:
                                Zombie.zombies.add(new BucketHead(10 * Tile_Size, y * Tile_Size));
                                break;
                            case 5:
                                Zombie.zombies.add(new PoleValuting(10 * Tile_Size, y * Tile_Size));
                                break;
                            case 6:
                                Zombie.zombies.add(new Newspaper(10 * Tile_Size, y * Tile_Size));
                                break;
                        }
                    }
                }
                // }
                timer = 0;
            } else {
                timer++;
            }

            if (time % 200 <= 100) {
                sun.autoSun();
            }

            if (keyH.upPressed) {
                // System.out.println("UP");
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
    }

    public void drawGameOver(Graphics2D gd) {
        try {
            GameOver = ImageIO.read(new File(
                    "image\\cursor.png"));
        } catch (Exception e) {
        }

        gd.drawImage(GameOver, GameLevel.Tile_Size, GameLevel.Tile_Size, null);
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
        // int x = 1;
        // for (int i = 0; i < Inventory2.getSelectedPlants().size(); i++) {
        // if (Inventory2.getcooldown(i) <= 0) {
        // new Deck(x * Tile_Size, 0,
        // Inventory2.getSelectedPlants().get(i)).drawdeck(g2);
        // }
        // x++;
        // }
        sun.drawSun(g2);
        drawkursor(g2);

    }

    public void drawkursor(Graphics g) {
        // private void drawPlayer(Graphics2D g) {
        // g.fillRect(playerX, playerY, Tile_Size, Tile_Size);
        // }
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(
                    "image\\cursor.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        g.drawImage(img, tileX, tileY, Tile_Size, Tile_Size, null);
    }
}
