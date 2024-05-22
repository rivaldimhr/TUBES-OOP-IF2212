import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Play implements ScreenMethod {

    private Game game;

	private MyButton  b1, b2;

	public Play(Game game) {
		this.game = game;

		initButtons();
	}

	private void initButtons() {

		int w = 75;
		int h = 27;
		int x = 570;
		int y = 9;

		b1 = new MyButton("Start", x, y, w, h);
		b2 = new MyButton("Clear", x, 45, w, h);
	}

	@Override
	public void render(Graphics g) {
		drawBackground(g);
		drawButtons(g);

	}

	private void drawBackground(Graphics g) {
        BufferedImage img = getImage("INVENTORY");

        g.drawImage(img, 0, 0, null);
    }

	private BufferedImage getImage(String index) {
		BufferedImage img = null;
		InputStream is = getClass().getResourceAsStream("/IMAGE/" + index + ".png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

    private void drawButtons(Graphics g) {

		b1.draw(g);
		b2.draw(g);
	}

	@Override
	public void mouseClicked(int x, int y) {
        if (b1.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        } else if (b2.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
		}
    }


	@Override
	public void mouseMoved(int x, int y) {
		b1.setMouseOver(false);

		if (b1.getBounds().contains(x, y)) {
			b1.setMouseOver(true);
		} else if (b2.getBounds().contains(x, y)) {
			b2.setMouseOver(true);
		}
	}

	@Override
	public void mousePressed(int x, int y) {

		if (b1.getBounds().contains(x, y)) {
			b1.setMousePressed(true);
		} else if (b2.getBounds().contains(x, y)) {
			b2.setMousePressed(true);
		}
	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}

	private void resetButtons() {
		b1.resetBooleans();
		b2.resetBooleans();
	}

}