Jimport java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Inventory2 implements ScreenMethod {
    private BufferedImage[] images = new BufferedImage[10];
    private String[] imageFiles = {
            "IMAGE/Peashooter.png",
            "IMAGE/Tall-Nut.png",
            "IMAGE/Puff-Shroom.png",
            "IMAGE/Squash.png",
            "IMAGE/Lily Pad.png",
            "IMAGE/Repeater.png",
            "IMAGE/Tangle Kelp.png",
            "IMAGE/Snow Pea.png",
            "IMAGE/Wall-Nut.png",
            "IMAGE/Sunflower.png"
    };
    private int[] imagePositions = new int[10];
    private ArrayList<Integer> deck = new ArrayList<>();
    public static List<String> selectedPlants = new ArrayList<>(); // ArrayList untuk menyimpan nama tanaman yang dipilih
    private BufferedImage BackgroundInventory; // Gambar untuk background
    private MyButton startButton;
    private MyButton clearButton;
    private Game game;

    public Inventory2(Game game) {
        this.game = game;
        
        startButton = new MyButton("Start", 570, 10, 80, 30);
        clearButton = new MyButton("Clear Deck", 570, 50, 80, 30);
        
        loadImages();
        calculateImagePositions();
    }

    private void loadImages() {
        try {
            BackgroundInventory = ImageIO.read(new File("IMAGE/INVENTORY (7).png")); // Muat gambar untuk background
            for (int i = 0; i < imageFiles.length; i++) {
                images[i] = ImageIO.read(new File(imageFiles[i]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calculateImagePositions() {
        int index = 0;
        for (int y = 2; y <= 3; y++) {
            for (int x = 1; x < 6; x++) {
                imagePositions[index++] = x * 90 + y * 90 * 1000; // y * 1000 to separate x and y values
            }
        }
    }

    private String getPlantName(String filePath) {
        // Mendapatkan nama file tanpa ekstensi dan path
        String fileName = new File(filePath).getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1) {
            fileName = fileName.substring(0, dotIndex);
        }
        return fileName;
    }

    private void addToSelectedPlants(String filePath) {
        selectedPlants.add(filePath);
    }

    private void removeFromSelectedPlants(String filePath) {
        selectedPlants.remove(filePath);
    }

    private void displaySelectedPlants() {
        System.out.println("Selected Plants:");
        for (String plant : selectedPlants) {
            System.out.println(plant);
        }
    }

    private void handleClick(int x, int y) {
        for (int i = 0; i < imagePositions.length; i++) {
            int imgX = imagePositions[i] % 1000;
            int imgY = imagePositions[i] / 1000;
            System.out.println(imgX);
            System.out.println(imgY);
            if (x >= imgX && x <= imgX + 90 && y >= imgY && y <= imgY + 90) {
                String plantName = imageFiles[i]; // Nama file gambar tanaman
                if (deck.contains(i)) {
                    deck.remove(Integer.valueOf(i));
                    removeFromSelectedPlants(plantName);
                    JOptionPane.showMessageDialog(null, "" + getPlantName(plantName) + " dihapus dari deck");
                    System.out.println(getPlantName(plantName) + " removed from deck");
                    
                } else if (deck.size() < 6) {
                    deck.add(i);
                    addToSelectedPlants(plantName);
                    System.out.println(getPlantName(plantName) + " added to deck");
                } else {
                    
                }
                
                displaySelectedPlants();
                break;
            }
        }
    }
    
    private void clearDeck() {
        deck.clear();
        selectedPlants.clear();
        JOptionPane.showMessageDialog(null, "Semua tanaman dihapus dari deck");
        System.out.println("Deck cleared");
    }

    @Override
    public void render(Graphics g) {
        // Draw buttons
        startButton.draw(g);
        clearButton.draw(g);

        // Draw background
        g.drawImage(BackgroundInventory, 0, 0, 60 * 11, 60 * 7 , null);
        
        // Draw inventory images
        int index = 0;
        for (int i = 0; i < 5; i++) {
            index++;
            for (int j = 0; j < 2; j++) {
                int indexReal = index + (5 * j);
                int x = 90;
                int y = 160;
                int xOffset = 85;
                int yOffset = 95;
                g.drawImage(images[indexReal - 1], x + xOffset * i, y + yOffset * j, 80, 90, null);
            }
        }
        
        // Draw deck images in the first column, rows 0 to 5
        for (int i = 0; i < deck.size(); i++) {
            int x = i * 90;
            g.drawImage(images[deck.get(i)], x, 0, 90, 90, null);
        }
        
    }

    public void mouseClicked(int x, int y) {
        handleClick(x, y);
        System.out.println(x);
        System.out.println(y);
        if (startButton.getBounds().contains(x, y)) {
            if (deck.size() < 6) {
                JOptionPane.showMessageDialog(null, "Deck belum lengkap, harus memilih 6 tanaman!");
            } else if (deck.size() == 6) {
               game.setStates(States.PLAYING);
            }
        }
        if (clearButton.getBounds().contains(x, y)) {
            clearDeck();
        }
        
        for (String string : selectedPlants) {
            System.out.println(string);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        startButton.setMouseOver(startButton.getBounds().contains(x, y));
        clearButton.setMouseOver(clearButton.getBounds().contains(x, y));
    }

    @Override
    public void mousePressed(int x, int y) {
        startButton.setMousePressed(startButton.getBounds().contains(x, y));
        clearButton.setMousePressed(clearButton.getBounds().contains(x, y));
    }

    @Override
    public void mouseReleased(int x, int y) {
        startButton.setMousePressed(false);
        clearButton.setMousePressed(false);
    }

}