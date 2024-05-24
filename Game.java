package menu;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

	public GameScreen gameScreen;
	private Thread gameThread;
	private States states;
	public static boolean live = true;

	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;

	// Classes
	private Render render;
	private Menu menu;
	private PlantsList plantsList;
	private ZombiesList zombiesList;
	private Help help;
	private Play play;
	private GameOver gameOver;
	private Win win;
	private Inventory2 inventory2;
	private GameLevel gameLevel;

	public Game() {
		initClasses();
		states = States.MENU;

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setResizable(false);
		add(gameScreen);
		pack();
		setVisible(true);
	}

	private void initClasses() {
		render = new Render(this);
		gameScreen = new GameScreen(this);
		menu = new Menu(this);
		plantsList = new PlantsList(this);
		zombiesList = new ZombiesList(this);
		help = new Help(this);
		play = new Play(this);
		gameOver = new GameOver(this);
		win = new Win(this);
		inventory2 = new Inventory2(this);
		gameLevel = new GameLevel(this);
	}

	public synchronized void start() {
		live = true;
		gameThread = new Thread(this);
		gameThread.start();
	}

	public synchronized void stop(Thread gameThread) {
		if (gameThread != null && gameThread.isAlive()) {
			try {
				gameThread.join(); // Waits for the thread to die
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void restart() {
		stop(gameThread); // Stop the current thread if it's running
		gameThread = new Thread(this);
		gameThread.start();
	}

	private void updateGame() {
		gameLevel.update();
		// System.out.println("Game Updated!");
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.gameScreen.initInputs();
		game.start();
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();

		int frames = 0;
		int updates = 0;

		long now;

		while (live) {
			now = System.nanoTime();

			// Render
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
			}

			// Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}

			if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}

		}
	}

	// Getters and setters
	public Render getRender() {
		return render;
	}

	public Menu getMenu() {
		return menu;
	}

	public PlantsList getPlantsList() {
		return plantsList;
	}

	public ZombiesList getZombiesList() {
		return zombiesList;
	}

	public Help getHelp() {
		return help;
	}

	public Play getPlay() {
		return play;
	}

	public GameOver getGameOver() {
		return gameOver;
	}

	public Win getWin() {
		return win;
	}

	public States getStates() {
		return states;
	}

	public Inventory2 getInventory2() {
		return inventory2;
	}

	public GameLevel getGameLevel() {
		if (!gameLevel.cek_time) {
			gameLevel.cek_time = true;
		}
		return gameLevel;
	}

	public void setStates(States states) {
		this.states = states;
	}
}
