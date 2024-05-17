import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Help implements ScreenMethod {

    private Game game;

	private MyButton  b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;

	public Help(Game game) {
		this.game = game;

		initButtons();
	}

	private void initButtons() {

		int w = 154;
		int h = 200;
		int x = 97;
		int y = 182;
		int xOffset = w + 75;
		int yOffset = h + 75;

		b1 = new MyButton("Quit", x, y, w, h);
	}

	@Override
	public void render(Graphics g) {
        drawBackground(g);
		drawButtons(g);

	}

	private void drawBackground(Graphics g) {
        BufferedImage img = null;
		InputStream is = getClass().getResourceAsStream("7.png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

        g.drawImage(img, 0, 0, null);

    }

    private void drawButtons(Graphics g) {

		b1.draw(g);

	}

	@Override
	public void mouseClicked(int x, int y) {
        if (b1.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
    }


	@Override
	public void mouseMoved(int x, int y) {
		b1.setMouseOver(false);

		if (b1.getBounds().contains(x, y)) {
			b1.setMouseOver(true);
		}
	}

	@Override
	public void mousePressed(int x, int y) {

		if (b1.getBounds().contains(x, y)) {
			b1.setMousePressed(true);
		}
	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}

	private void resetButtons() {
		b1.resetBooleans();
	}

}