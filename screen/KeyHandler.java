package screen;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, numPressed;
    private GameMap gameMap;
    public boolean enterPressed;
    int numkey; // nyimpen nomor yg di teka

    public KeyHandler(GameMap gameMap) {
        this.gameMap = gameMap;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_ENTER:
                enterPressed = true;
                break;
            case KeyEvent.VK_1:
                numPressed = true;
                break;
            case KeyEvent.VK_2:
                numPressed = true;
                break;
            case KeyEvent.VK_3:
                numPressed = true;
                break;
            case KeyEvent.VK_4:
                numPressed = true;
                break;
            case KeyEvent.VK_5:
                numPressed = true;
                break;
            case KeyEvent.VK_6:
                numPressed = true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_ENTER:
                enterPressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
