package screen;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Deck {
    public int x;
    public int y;
    public String img;
    private BufferedImage png;
    public static ArrayList<Deck> deck = new ArrayList<Deck>();

    public Deck(int x, int y, String img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public void drawdeck(Graphics2D gd) {
        try {
            png = ImageIO.read(new File(
                    "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\Basic Java plant vs Zombie\\image\\deck.png"));
        } catch (IOException e) {
        }
        gd.drawImage(png, x, y, GameMap.Tile_Size, GameMap.Tile_Size, null);
    }
}
