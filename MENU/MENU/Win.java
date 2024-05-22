import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Win implements ScreenMethod {
    private Game game;

	private MyButton  b1, b2;

	public Win(Game game) {
		this.game = game;

		initButtons();

	}

	private void initButtons() {

		int w = 127;
		int h = 45;
		int x = 194;
		int y = 327;
		int xOffset = w + 65;
		// int yOffset = h + 25;

		b1 = new MyButton("1", x, y, w, h);
		b2 = new MyButton("2", x + xOffset - 33, y, w, h);
	}

	@Override
	public void render(Graphics g) {
		drawBackground(g);
		drawButtons(g);
	}

	private void drawBackground(Graphics g) {
        BufferedImage img = getImage("GAME OVER");

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
			game.setStates(States.PLAY);
        } else if (b2.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
	}

	@Override
	public void mouseMoved(int x, int y) {
		b1.setMouseOver(false);
		b2.setMouseOver(false);

		if (b1.getBounds().contains(x, y)) {
			b1.setMouseOver(true);
		}
		if (b2.getBounds().contains(x, y)) {
			b2.setMouseOver(true);
		}

	}

	@Override
	public void mousePressed(int x, int y) {

		if (b1.getBounds().contains(x, y)) {
			b1.setMousePressed(true);
		}
		if (b2.getBounds().contains(x, y)) {
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