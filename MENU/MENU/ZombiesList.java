import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class ZombiesList implements ScreenMethod {

    private Game game;

	private MyButton  b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;
	private BufferedImage[] zombieDesc = new BufferedImage[10];
	private BufferedImage selectedZombie = null;

	public ZombiesList(Game game) {
		this.game = game;

		initZombieDesc();
		initButtons();

	}

	private void initZombieDesc() {
		zombieDesc[0] = getImage("NORMAL");
		zombieDesc[1] =  getImage("DUCKY TUBE-CONE");
		zombieDesc[2] =  getImage("CONEHEAD");
		zombieDesc[3] =  getImage("POLE VAULTING");
		zombieDesc[4] =  getImage("FOOTBALL");
		zombieDesc[5] =  getImage("BUCKETHEAD");
		zombieDesc[6] =  getImage("DUCKY TUBE");
		zombieDesc[7] =  getImage("DOLPHIN RIDER");
		zombieDesc[8] =  getImage("NEWSPAPER");
		zombieDesc[9] =  getImage("SNORKEL");

	}

	private void initButtons() {

		int w = 70;
		int h = 70;
		int x = 46;
		int y = 117;
		int xOffset = w + 60;
		int yOffset = h + 25;

		b1 = new MyButton("1", x, y, w, h);
		b2 = new MyButton("2", x + xOffset - 35, y, w, h);
		b3 = new MyButton("3", x + 2 * xOffset - 69, y, w, h);
		b4 = new MyButton("4", x + 3 * xOffset - 105, y, w, h);
		b5 = new MyButton("5", x + 4 * xOffset - 520, 308, w, h);
		b6 = new MyButton("6", x, y + yOffset, w, h);
		b7 = new MyButton("7", x + xOffset - 34, y + yOffset, w, h);
		b8 = new MyButton("8", x + 2 * xOffset - 68, y + yOffset, w, h);
		b9 = new MyButton("9", x + 3 * xOffset - 105, y + yOffset, w, h);
		b10 = new MyButton("10", x + 4 * xOffset - 425, 212 + yOffset, w, h);
		b11 = new MyButton("11",555, 15, 75, 22);
	}

	@Override
	public void render(Graphics g) {
		drawButtons(g);
		drawBackground(g);
		drawZombieDesc(g);

	}

	private void drawZombieDesc(Graphics g) {
		g.drawImage(selectedZombie, 0, 0, null);
	}

	private void drawBackground(Graphics g) {
        BufferedImage img = getImage("ZOMBIE");

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
			selectedZombie = zombieDesc[0];
        }
        if (b2.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[1];
        }
        if (b3.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[2];
        }
        if (b4.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[3];
        }
        if (b5.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[8];
        }
        if (b6.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[4];
        }
        if (b7.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[5];
        }
        if (b8.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[6];
        }
        if (b9.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[7];
        }
        if (b10.getBounds().contains(x, y)) {
			selectedZombie = zombieDesc[9];
        }
        if (b11.getBounds().contains(x, y)) {
			selectedZombie = null;
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