import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Menu implements ScreenMethod {

    private Game game;
	

	private MyButton bPlaying, bPlantsList, bZombiesList, bQuit, bHelp, bGameOver, bWin;

	public Menu(Game game) {
		this.game = game;

		initButtons();
	}

	private void initButtons() {

		int w = 115;
		int h = 40;
		int yOffset = 100;

		bPlaying = new MyButton("Play", 270, 303, w, h);
		bPlantsList = new MyButton("Plants List", 175, 141 + yOffset, w, h);
        bZombiesList = new MyButton("Zombies List", 363, 40 + yOffset * 2, w, h);
		bQuit = new MyButton("Quit", 363, 360, w, h);
        bHelp = new MyButton("Help", 175, 360, w, h);
		bGameOver = new MyButton("GO", 0, 0, w, h);
		bWin = new MyButton("Win", 0, 500, w, h);

	}

	@Override
	public void render(Graphics g) {
       
        drawButtons(g);
        drawBackground(g);
		

	}

	private void drawBackground(Graphics g) {
        BufferedImage img = getImage("MENU");

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
		bPlaying.draw(g);
		bPlantsList.draw(g);
        bZombiesList.draw(g);
		bQuit.draw(g);
        bHelp.draw(g);
        bGameOver.draw(g);
		bWin.draw(g);

	}

	@Override
	public void mouseClicked(int x, int y) {

		if (bPlaying.getBounds().contains(x, y)) {
			game.setStates(States.INVENTORY2);
        } else if (bPlantsList.getBounds().contains(x, y)) {
			game.setStates(States.PLANTSLIST);
        } else if (bQuit.getBounds().contains(x, y)) {
			System.exit(0);
        } else if (bZombiesList.getBounds().contains(x, y)) {
            game.setStates(States.ZOMBIESLIST);
        } else if (bHelp.getBounds().contains(x, y)) {
            game.setStates(States.HELP);
		} else if (bGameOver.getBounds().contains(x, y)) {
            game.setStates(States.GAMEOVER);
		} else if (bWin.getBounds().contains(x, y)) {
            game.setStates(States.WIN);
        }
	}

	@Override
	public void mouseMoved(int x, int y) {
		bPlaying.setMouseOver(false);
		bPlantsList.setMouseOver(false);
        bZombiesList.setMouseOver(false);
		bQuit.setMouseOver(false);
		bHelp.setMouseOver(false);
		bGameOver.setMouseOver(false);
		bWin.setMouseOver(false);

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
		} else if (bGameOver.getBounds().contains(x, y)) {
			bGameOver.setMouseOver(true);
		} else if (bWin.getBounds().contains(x, y)) {
			bWin.setMouseOver(true);
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
		} else if (bGameOver.getBounds().contains(x, y)) {
			bGameOver.setMousePressed(true);
		} else if (bWin.getBounds().contains(x, y)) {
			bWin.setMousePressed(true);
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
		bGameOver.resetBooleans();
		bWin.resetBooleans();
	}

}