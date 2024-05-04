import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameMap extends JFrame {
    private JLabel[][] grid;
    private Timer spawnTimer, waveTimer;
    private Random random = new Random();
    private ImageIcon backgroundImageIcon;
    private final int ROW_COUNT = 6;
    private final int COL_COUNT = 11;
    private final int TILE_SIZE = 55; // Tile size
    private final int WIDTH = COL_COUNT * TILE_SIZE;
    private final int HEIGHT = ROW_COUNT * TILE_SIZE;

    public GameMap() {
        setTitle("Plants VS Zombies");
        setSize(WIDTH, HEIGHT); // Adjust the size to fit exactly to the grid
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Use BorderLayout to manage layers

        loadBackgroundImage(
                "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\TUBES OOP JAVA\\image\\messageImage_1714536818417.jpg"); // Adjust
                                                                                                                                // path
        initializeGame();
    }

    private void loadBackgroundImage(String path) {
        backgroundImageIcon = new ImageIcon(
                new ImageIcon(path).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
    }

    private void initializeGame() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image first
                g.drawImage(backgroundImageIcon.getImage(), 0, 0, this);
            }
        };
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setLayout(null);
        panel.setOpaque(false);
        add(panel);

        grid = new JLabel[ROW_COUNT][COL_COUNT];
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COL_COUNT; j++) {
                grid[i][j] = new JLabel();
                grid[i][j].setBounds(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(grid[i][j], 0); // Add with index 0 to ensure it's on top
            }
        }

        spawnTimer = new Timer(5000, e -> spawnRandomZombie());
        spawnTimer.start();

        waveTimer = new Timer(30000, e -> createWave());
        waveTimer.start();
    }

    private void spawnRandomZombie() {
        int col = COL_COUNT - 1; // Zombies spawn in the last column
        int row = random.nextInt(ROW_COUNT);
        if (!isSafeZone(row, col)) {
            grid[row][col].setIcon(new ImageIcon(
                    "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\TUBES OOP JAVA\\image\\zombie_football.gif")); // Path
                                                                                                                          // to
                                                                                                                          // your
                                                                                                                          // zombie
                                                                                                                          // icon
        }
    }

    private void createWave() {
        for (int i = 0; i < 5; i++) { // Spawn 5 zombies randomly
            spawnRandomZombie();
        }
    }

    private boolean isSafeZone(int row, int col) {
        // Define safe zones where zombies cannot spawn
        if (col == 0) {
            JOptionPane.showMessageDialog(this, "Game Over! Zombie reached the protected zone.");
            System.exit(0);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameMap().setVisible(true));
    }
}
