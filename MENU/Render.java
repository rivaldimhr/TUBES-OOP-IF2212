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

	}

}

