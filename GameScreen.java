package menu;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameScreen extends JPanel {

	private Game game;
	private Dimension size;

	private MyMouseListener myMouseListener;

	public GameScreen(Game game) {
		this.game = game;

		setPanelSize();

	}

	public static KeyHandler keyH = new KeyHandler();

	public void initInputs() {
		myMouseListener = new MyMouseListener(game);

		addMouseListener(myMouseListener);
		addMouseMotionListener(myMouseListener);
		addKeyListener(keyH);
		requestFocus();
	}

	private void setPanelSize() {
		size = new Dimension(660, 420);

		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.getRender().render(g);

	}

}