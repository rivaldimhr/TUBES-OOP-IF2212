import javax.swing.*;
import java.awt.*;

public class Tes extends JFrame {


    public Tes() {
        setTitle("Plant Vs Zombie");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 9)); // Grid layout of 6 rows and 9 columns

        // Load the image
        ImageIcon imageIcon = new ImageIcon(
                "C:\\Users\\User\\Documents\\bahasa pemrograman\\java\\TUBES OOP JAVA\\image\\messageImage_1714536818417.jpg"); // Adjust
                                                                                                                                // path
                                                                                                                                // to
                                                                                                                                // your
                                                                                                                                // image
                                                                                                                                // location
        Image image = imageIcon.getImage(); // Transform it
        Image newimg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // Scale it to fit the panel
        imageIcon = new ImageIcon(newimg); // Transform it back

        // Initialize each cell of the grid
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 9; col++) {
                JPanel panel = new JPanel(new BorderLayout());
                JLabel label = new JLabel(imageIcon); // Set the image as a background

                // Create a transparent color panel
                JPanel colorPanel = new JPanel();
                colorPanel.setOpaque(true);
                colorPanel.setPreferredSize(new Dimension(50, 50)); // Set the size of the color panel

                // Assign colors with transparency
                if (col == 0) { // Pink zone
                    colorPanel.setBackground(new Color(0, 0, 180, 180)); // Semi-transparent pink
                } else if (col >= 1 && col <= 7) { // Green zone
                    if (row == 2 || row == 3) { // Pool areas on rows 2 and 3
                        colorPanel.setBackground(new Color(0, 0, 0, 180)); // Semi-transparent blue
                    } else {
                        colorPanel.setBackground(new Color(0, 0, 0, 180)); // Semi-transparent green
                    }
                } else if (col == 8) { // Beige zone
                    colorPanel.setBackground(new Color(0, 245, 220, 255)); // Opaque beige
                }

                // Layer the panels
                label.setOpaque(false);
                panel.setOpaque(false);
                panel.add(label, BorderLayout.CENTER);
                panel.add(colorPanel, BorderLayout.CENTER);
                add(panel); // Add the main panel to the JFrame
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Tes gm = new Tes();
            gm.setVisible(true);
        });
    }
}
