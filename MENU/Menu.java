import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Menu implements ScreenMethod {

    private Game game;

	private MyButton bPlaying, bPlantsList, bZombiesList, bQuit, bHelp;

	public Menu(Game game) {
		this.game = game;

		initButtons();
	}

	private void initButtons() {

		int w = 180;
		int h = w / 3;
		int yOffset = 100;

		bPlaying = new MyButton("Play", 550, 497, w, h);
		bPlantsList = new MyButton("Plants List", 391, 295 + yOffset, w, h);
        bZombiesList = new MyButton("Zombies List", 710, 194 + yOffset * 2, w, h);
		bQuit = new MyButton("Quit", 710, 600, w, h);
        bHelp = new MyButton("Help", 400, 600, w, h);

	}

	@Override
	public void render(Graphics g) {
       
        drawBackground(g);
        drawButtons(g);
		

	}

	private void drawBackground(Graphics g) {
        BufferedImage img = null;
		InputStream is = getClass().getResourceAsStream("1.png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

        g.drawImage(img, 0, 0, null);

    }

    private void drawButtons(Graphics g) {
		bPlaying.draw(g);
		bPlantsList.draw(g);
        bZombiesList.draw(g);
		bQuit.draw(g);
        bHelp.draw(g);

	}

	@Override
	public void mouseClicked(int x, int y) {

		if (bPlaying.getBounds().contains(x, y)) {
			System.out.println("Playing clicked!");
        } else if (bPlantsList.getBounds().contains(x, y)) {
			game.setStates(States.PLANTSLIST);
        } else if (bQuit.getBounds().contains(x, y)) {
			System.exit(0);
        } else if (bZombiesList.getBounds().contains(x, y)) {
            game.setStates(States.ZOMBIESLIST);
        }
	}

	@Override
	public void mouseMoved(int x, int y) {
		bPlaying.setMouseOver(false);
		bPlantsList.setMouseOver(false);
        bZombiesList.setMouseOver(false);
		bQuit.setMouseOver(false);
		bHelp.setMouseOver(false);

		if (bPlaying.getBounds().contains(x, y)) {
			bPlaying.setMouseOver(true);
		} else if (bPlantsList.getBounds().contains(x, y)) {
			bPlantsList.setMouseOver(true);
		} else if (bZombiesList.getBounds().contains(x, y)) {
			bZombiesList.setMouseOver(true);
		} else if (bQuit.getBounds().contains(x, y)) {
			bQuit.setMouseOver(true);
		} else if (bHelp.getBounds().contains(x, y)) {
			bHelp.setMouseOver(true);
		}

	}

	@Override
	public void mousePressed(int x, int y) {

		if (bPlaying.getBounds().contains(x, y)) {
			bPlaying.setMousePressed(true);
		} else if (bPlantsList.getBounds().contains(x, y)) {
			bPlantsList.setMousePressed(true);
		} else if (bZombiesList.getBounds().contains(x, y)) {
			bZombiesList.setMousePressed(true);
		} else if (bQuit.getBounds().contains(x, y)) {
			bQuit.setMousePressed(true);
		} else if (bHelp.getBounds().contains(x, y)) {
			bHelp.setMousePressed(true);
		}

	}

	@Override
	public void mouseReleased(int x, int y) {
		resetButtons();
	}

	private void resetButtons() {
		bPlaying.resetBooleans();
		bPlantsList.resetBooleans();
        bZombiesList.resetBooleans();
		bQuit.resetBooleans();
        bHelp.resetBooleans();
	}

}