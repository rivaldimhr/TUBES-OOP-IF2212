import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class PlantsList implements ScreenMethod {

    private Game game;

	private MyButton  b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
	private BufferedImage[] plantDesc = new BufferedImage[10];
	private BufferedImage selectedPlant = null;

	public PlantsList(Game game) {
		this.game = game;

		initPlantDesc();
		initButtons();

	}

	private void initPlantDesc() {
		plantDesc[0] = getImage("9");
		plantDesc[1] =  getImage("10");

	}

	private void initButtons() {

		int w = 100;
		int h = 130;
		int x = 82;
		int y = 114;
		int xOffset = w + 60;
		int yOffset = h + 65;

		b1 = new MyButton("Quit", x, y, w, h);
		b2 = new MyButton("Quit", x + xOffset - 11, y, w, h);
		b3 = new MyButton("Quit", x + 2 * xOffset - 22, y, w, h);
		b4 = new MyButton("Quit", x + 3 * xOffset - 35, y, w, h);
		b5 = new MyButton("Quit", x + 4 * xOffset - 46, y, w, h);
		b6 = new MyButton("Quit", x, y + yOffset - 17, w, h);
		b7 = new MyButton("Quit", x + xOffset - 11, y + yOffset - 17, w, h);
		b8 = new MyButton("Quit", x + 2 * xOffset - 22, y + yOffset - 17, w, h);
		b9 = new MyButton("Quit", x + 3 * xOffset - 33, y + yOffset - 17, w, h);
		b10 = new MyButton("Quit", x + 4 * xOffset - 43, y + yOffset - 17, w, h);
		b11 = new MyButton("Quit",1090, 17, 137, 50);
	}

	@Override
	public void render(Graphics g) {
		drawButtons(g);
        drawBackground(g);
		
		drawPlantDesc(g);

	}

	private void drawPlantDesc(Graphics g) {
		g.drawImage(selectedPlant, 0, 0, null);
	}

	private void drawBackground(Graphics g) {
        BufferedImage img = getImage("9");

        g.drawImage(img, 0, 0, null);

    }

	private BufferedImage getImage(String index) {
		BufferedImage img = null;
		InputStream is = getClass().getResourceAsStream(index + ".png");

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
			selectedPlant = plantDesc[0];
        }
        if (b2.getBounds().contains(x, y)) {
			selectedPlant = plantDesc[1];
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