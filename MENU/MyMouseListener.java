import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MyMouseListener implements MouseListener, MouseMotionListener {

	private Game game;

	public MyMouseListener(Game game) {
		this.game = game;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		game.getMenu().mouseMoved(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
            if (game.getStates() == States.MENU)
			    game.getMenu().mouseClicked(e.getX(), e.getY());
            else if (game.getStates() == States.PLANTSLIST)
                game.getPlantsList().mouseClicked(e.getX(), e.getY());
            else if (game.getStates() == States.ZOMBIESLIST)
                game.getZombiesList().mouseClicked(e.getX(), e.getY());
            else if (game.getStates() == States.HELP)
                game.getHelp().mouseClicked(e.getX(), e.getY());
            else if (game.getStates() == States.PLAY)
                game.getPlay().mouseClicked(e.getX(), e.getY());
 
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
