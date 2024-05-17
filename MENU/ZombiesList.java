import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class ZombiesList implements ScreenMethod {

    private Game game;

	private MyButton  b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;

	public ZombiesList(Game game) {
		this.game = game;

		initButtons();
	}

	private void initButtons() {

		int w = 207;
		int h = 200;
		int x = 90;
		int y = 177;
		int xOffset = w + 21;
		int yOffset = h + 66;

		b1 = new MyButton("Quit", x, y, w, h);
		b2 = new MyButton("Quit", x + xOffset, y, w, h);
		b3 = new MyButton("Quit", x + 2 * xOffset, y, w, h);
		b4 = new MyButton("Quit", x + 3 * xOffset, y, w, h);
		b5 = new MyButton("Quit", x + 4 * xOffset, y, w, h);
		b6 = new MyButton("Quit", x, y + yOffset, w, h);
		b7 = new MyButton("Quit", x + xOffset, y + yOffset, w, h);
		b8 = new MyButton("Quit", x + 2 * xOffset, y + yOffset, w, h);
		b9 = new MyButton("Quit", x + 3 * xOffset, y + yOffset, w, h);
		b10 = new MyButton("Quit", x + 4 * xOffset, y + yOffset, w, h);
		b11 = new MyButton("Quit",1090, 17, 137, 50);
	}

	@Override
	public void render(Graphics g) {
        drawBackground(g);
		drawButtons(g);

	}

	private void drawBackground(Graphics g) {
        BufferedImage img = null;
		InputStream is = getClass().getResourceAsStream("design pvz (9).png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

        g.drawImage(img, 0, 0, null);

    }

    private void drawButtons(Graphics g) {

		b1.draw(g);
		b2.draw(g);
		b3.draw(g);
		b4.draw(g);
		b5.draw(g);
		b6.draw(g);
		b7.draw(g);
		b8.draw(g);
		b9.draw(g);
		b10.draw(g);
		b11.draw(g);

	}

	@Override
	public void mouseClicked(int x, int y) {
        if (b1.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b2.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b3.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b4.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b5.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b6.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b7.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b8.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b9.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b10.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
        if (b11.getBounds().contains(x, y)) {
			game.setStates(States.MENU);
        }
	}

	@Override
	public void mouseMoved(int x, int y) {
		b1.setMouseOver(false);
		b2.setMouseOver(false);
		b3.setMouseOver(false);
		b4.setMouseOver(false);
		b5.setMouseOver(false);
		b6.setMouseOver(false);
		b7.setMouseOver(false);
		b8.setMouseOver(false);
		b9.setMouseOver(false);
		b10.setMouseOver(false);

		if (b1.getBounds().contains(x, y)) {
			b1.setMouseOver(true);
		}
		if (b2.getBounds().contains(x, y)) {
			b2.setMouseOver(true);
		}
		if (b3.getBounds().contains(x, y)) {
			b3.setMouseOver(true);
		}
		if (b4.getBounds().contains(x, y)) {
			b4.setMouseOver(true);
		}
		if (b5.getBounds().contains(x, y)) {
			b5.setMouseOver(true);
		}
		if (b6.getBounds().contains(x, y)) {
			b6.setMouseOver(true);
		}
		if (b7.getBounds().contains(x, y)) {
			b7.setMouseOver(true);
		}
		if (b8.getBounds().contains(x, y)) {
			b8.setMouseOver(true);
		}
		if (b9.getBounds().contains(x, y)) {
			b9.setMouseOver(true);
		}
		if (b10.getBounds().contains(x, y)) {
			b10.setMouseOver(true);
		}
		if (b11.getBounds().contains(x, y)) {
			b11.setMouseOver(true);
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
		if (b3.getBounds().contains(x, y)) {
			b3.setMousePressed(true);
		}
		if (b4.getBounds().contains(x, y)) {
			b4.setMousePressed(true);
		}
		if (b5.getBounds().contains(x, y)) {
			b5.setMousePressed(true);
		}
		if (b6.getBounds().contains(x, y)) {
			b6.setMousePressed(true);
		}
		if (b7.getBounds().contains(x, y)) {
			b7.setMousePressed(true);
		}
		if (b8.getBounds().contains(x, y)) {
			b8.setMousePressed(true);
		}
		if (b9.getBounds().contains(x, y)) {
			b9.setMousePressed(true);
		}
		if (b10.getBounds().contains(x, y)) {
			b10.setMousePressed(true);
		}
		if (b11.getBounds().contains(x, y)) {
			b11.setMousePressed(true);
		}

	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}

	private void resetButtons() {
		b1.resetBooleans();
		b2.resetBooleans();
		b3.resetBooleans();
		b4.resetBooleans();
		b5.resetBooleans();
		b6.resetBooleans();
		b7.resetBooleans();
		b8.resetBooleans();
		b9.resetBooleans();
		b10.resetBooleans();
		b11.resetBooleans();
	}

}