import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

	private GameScreen gameScreen;
	private Thread gameThread;
	private States states;

	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;

	// Classes
	private Render render;
	private Menu menu;
	private PlantsList plantsList;
	private ZombiesList zombiesList;

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

	}

	private void start() {
		gameThread = new Thread(this) {
		};

		gameThread.start();
	}

	private void updateGame() {

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

		while (true) {
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
	public States getStates() {
		return states;
	}

	public void setStates(States states) {
		this.states = states;
	}

}