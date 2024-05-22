import java.awt.Graphics;


public class Render {

	private Game game;

	public Render(Game game) {
		this.game = game;

	}

	public void render(Graphics g) {
        if (game.getStates() == States.MENU)
		    game.getMenu().render(g);
        else if (game.getStates() == States.PLANTSLIST)
            game.getPlantsList().render(g);
        else if (game.getStates() == States.ZOMBIESLIST)
            game.getZombiesList().render(g);
        else if (game.getStates() == States.HELP)
            game.getHelp().render(g);
        else if (game.getStates() == States.PLAY)
            game.getPlay().render(g);
        else if (game.getStates() == States.GAMEOVER)
            game.getGameOver().render(g);
        else if (game.getStates() == States.WIN)
            game.getWin().render(g);
        else if (game.getStates() == States.INVENTORY2)
            game.getInventory2().render(g);

	}

}

