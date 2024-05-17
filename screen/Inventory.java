package screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inventory extends JPanel {
    private BufferedImage[] images = new BufferedImage[10];
    private String[] imageFiles = {
            "peashooter.png",
            "kentang_gede.png",
            "mushroom.png",
            "squash.png",
            "lilipad.png",
            "double_peashooter.png",
            "tangle_kelp.png"
    };
    private int[] imagePositions = new int[10];
    private ArrayList<Integer> deck = new ArrayList<>();
    private List<String> selectedPlants = new ArrayList<>(); // ArrayList untuk menyimpan nama tanaman yang dipilih
    private BufferedImage startButtonImage;

    public Inventory() {
        this.setPreferredSize(new Dimension(60 * 11, 60 * 8));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
        this.setBackground(Color.white);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                handleClick(e.getX(), e.getY());
                if (x >= 510 && x <= 590 && y >= 10 && y <= 40) {
                    buttonClicked();
                }
            }
        });

        loadImages();
        calculateImagePositions();
    }

    private void loadImages() {
        try {
            startButtonImage = ImageIO.read(new File("C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\Basic Java plant vs Zombie\\image\\tombolStart.png"));
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
            for (int x = 0; x < 5; x++) {
                imagePositions[index++] = x * 90 + y * 90 * 1000; // y * 1000 to separate x and y values
            }
        }
    }

    private void addToSelectedPlants(String plantName) {
        selectedPlants.add(plantName);
    }

    private void removeFromSelectedPlants(String plantName) {
        selectedPlants.remove(plantName);
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
            if (x >= imgX && x <= imgX + 90 && y >= imgY && y <= imgY + 90) {
                String plantName = imageFiles[i]; // Nama file gambar tanaman
                if (deck.contains(i)) {
                    deck.remove(Integer.valueOf(i));
                    removeFromSelectedPlants(plantName);
                    System.out.println(plantName + " removed from deck");
                    JOptionPane.showMessageDialog(this, plantName + " removed from deck");
                } else if (deck.size() < 6) {
                    deck.add(i);
                    addToSelectedPlants(plantName);
                    System.out.println(plantName + " added to deck");
                    JOptionPane.showMessageDialog(this, plantName + " added to deck");
                } else {
                    JOptionPane.showMessageDialog(this, "Deck is full. Cannot add more than 6 items.");
                }
                repaint();
                displaySelectedPlants();
                break;
            }
        }
    }

    private void buttonClicked() {
        System.out.println("Main ni bos");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw inventory images
        for (int i = 0; i < images.length; i++) {
            int x = imagePositions[i] % 1000;
            int y = imagePositions[i] / 1000;
            g.drawImage(images[i], x, y, 90, 90, null);
        }
        // Draw deck images in the first column, rows 0 to 5
        for (int i = 0; i < deck.size(); i++) {
            int x = i * 90;
            g.drawImage(images[deck.get(i)], x, 0, 90, 90, null);
        }

        g.drawImage(startButtonImage, 570, 10, 80, 30, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventory");
        Inventory inventory = new Inventory();
        frame.add(inventory);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}