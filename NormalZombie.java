import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class NormalZombie extends Zombie {
    private Timer movementTimer;

    public NormalZombie() {
        super("Normal Zombie", 125, 100, 1.0, false, 1.0, "/images/zombie_normal.gif"); // Adjust path as necessary
        initMovement();
    }

    private void initMovement() {
        movementTimer = new Timer((int) (1000 / attackSpeed), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move();
                checkIfOffScreen();
            }
        });
        movementTimer.start();
    }

    private void checkIfOffScreen() {
        if (getLocation().x + getWidth() < 0) {
            movementTimer.stop(); // Stop the timer if the zombie moves off the screen
            die();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Zombie Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        NormalZombie nz = new NormalZombie();
        frame.add(nz);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
