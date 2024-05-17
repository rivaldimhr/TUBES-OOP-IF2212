import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class PlantGui {
    public static void main(String[] args) {
        // Create a new JFrame (window)
        JFrame frame = new JFrame("Plants List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 820); // Set the size of the window
        frame.setLayout(new BorderLayout());

        // Create a new JPanel to hold the button
        JPanel buttonPanel = new JPanel();

        // Create the "Plants" button
        JButton plantsButton = new JButton("Plants");
        buttonPanel.add(plantsButton);

        // Create a new JPanel to hold the plant images
        JPanel imagePanel = new JPanel();
        imagePanel.setSize(500, 500);
        imagePanel.setLayout(new GridLayout(0, 3)); // Adjust the layout as needed

        // Add the panels to the frame
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(imagePanel), BorderLayout.CENTER);

        // Add an ActionListener to the button
        plantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load and display plant images when the button is clicked
                loadPlantImages(imagePanel);
                System.out.println("TES");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void loadPlantImages(JPanel imagePanel) {
        // Clear the previous images
        imagePanel.removeAll();

        // Define the directory containing plant images
        String imageDir = "design pvz (2).png"; // Change this to your directory
        File dir = new File(imageDir);

        try {
            BufferedImage originalImage = ImageIO.read(dir);
            if (originalImage != null) {
                // Resize the image to fit within the panel size
                Image resizedImage = originalImage.getScaledInstance(890, 500, Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(resizedImage);
                JLabel imageLabel = new JLabel(imageIcon);
                imagePanel.add(imageLabel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }         

        // Refresh the panel to display new images
        imagePanel.revalidate();
        imagePanel.repaint();
    }
}
