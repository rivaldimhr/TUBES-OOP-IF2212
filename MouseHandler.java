// package screen;

// // import javax.swing.JFrame;
// import javax.swing.JPanel;

// // import entity.Plant.Plant;

// import java.awt.event.MouseListener;
// import java.awt.event.MouseMotionListener;
// import java.awt.event.MouseEvent;

// public class MouseHandler extends JPanel implements MouseListener,
// MouseMotionListener {

// public boolean upPressed;
// private GameMap gameMap;
// private int lastMouseX, lastMouseY;

// public MouseHandler(GameMap gameMap2) {
// // this.gameMap = gameMap;
// // Add mouse listeners to this panel
// addMouseListener(this);
// addMouseMotionListener(this);
// }

// public int getLastMouseX() {
// return lastMouseX; // Return the last recorded X position of the mouse
// }

// public int getLastMouseY() {
// return lastMouseY; // Return the last recorded Y position of the mouse
// }

// @Override
// public void mousePressed(MouseEvent e) {
// // System.out.println("Mouse pressed at (" + e.getX() + ", " + e.getY() +
// ")");
// upPressed = false;
// // isDragging = true;
// // int tilesize = gameMap.tileSize; // Assuming tileSize is accessible in
// // GameMap
// // // Calculate the offset within the clicked tile
// // dragOffsetX = e.getX() % tilesize;
// // dragOffsetY = e.getY() % tilesize;
// // gameMap.setPlayerPosition(e.getX() - dragOffsetX, e.getY() - dragOffsetY);
// }

// @Override
// public void mouseReleased(MouseEvent e) {
// // System.out.println("Mouse released at (" + e.getX() + ", " + e.getY() +
// ")");
// upPressed = true;

// }

// @Override
// public void mouseEntered(MouseEvent e) {
// System.out.println("Mouse entered the panel");
// }

// @Override
// public void mouseExited(MouseEvent e) {
// System.out.println("Mouse exited the panel");
// }

// @Override
// public void mouseClicked(MouseEvent e) {
// // System.out.println("Mouse clicked at (" + e.getX() + ", " + e.getY() +
// ")");
// }

// @Override
// public void mouseDragged(MouseEvent e) {
// lastMouseX = e.getX();
// lastMouseY = e.getY();
// // System.out.println("Mouse dragged to (" + e.getX() + ", " + e.getY() +
// // ")");
// gameMap.setPlayerPosition(e.getX(), e.getY());

// // gameMap.repaint();
// // if (dragging) {
// // int mouseX = e.getX();
// // int mouseY = e.getY();
// // float xf = 0;
// // float yf = 0;
// // if (shovel) {
// // xf = (mouseX - dragOffsetX) / tilesize;
// // yf = (mouseY - dragOffsetY) / tilesize;
// // } else {
// // Moveplant.X = mouseX - dragOffsetX;
// // Moveplant.Y = mouseY - dragOffsetY;
// // xf = Moveplant.X / tilesize;
// // yf = Moveplant.Y / tilesize;
// // }
// // int xi = Math.round(xf);
// // int yi = Math.round(yf);
// // if (shovel) {
// // deck = new Deck(xi, yi, "res/shovel.jpg");
// // } else {
// // if (xi > 0 && xi < 10) {
// // if (yi > 0 && yi < 7) {
// // Plant plant = Moveplant.plant;
// // deck = new Deck(xi, yi, plant.getPicture());
// // plant.X = xi * tilesize;
// // plant.Y = yi * tilesize;
// // planted = plant;
// // } else {
// // deck = null;
// // planted = null;
// // }
// // } else {
// // deck = null;
// // planted = null;
// // }
// // if (Moveplant.plant.getName() == "Lilypad") {
// // if (xi > 0 && xi < 10) {
// // if (yi > 2 && yi < 5) {
// // Plant plant = Moveplant.plant;
// // deck = new Deck(xi, yi, plant.getPicture());
// // plant.X = xi * tilesize;
// // plant.Y = yi * tilesize;
// // planted = plant;
// // } else {
// // deck = null;
// // planted = null;
// // }
// // } else {
// // deck = null;
// // planted = null;
// // }
// // }
// // }
// // }
// }

// @Override
// public void mouseMoved(MouseEvent e) {
// lastMouseX = e.getX();
// lastMouseY = e.getY();
// }
// // gameMap.repaint();
// // System.out.println("Mouse moved to (" + e.getX() + ", " + e.getY() + ")");
// // }

// // public static void main(String[] args) {
// // JFrame frame = new JFrame("Mouse Handler Example");
// // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// // frame.add(new MouseHandler());
// // frame.setSize(300, 300);
// // frame.setVisible(true);
// // }

// }
