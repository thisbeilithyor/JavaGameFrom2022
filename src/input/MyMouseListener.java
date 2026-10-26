package input;

import java.awt.event.*;

import javax.swing.event.MouseInputListener;

import gameStates.Gameover;
import gameStates.Menu;
import gameStates.Pause;
import gameStates.Playing;
import gameStates.Settings;
import gameStates.Shop;
import main.Game;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseInputListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		switch(GameStates.gameState) {
		case PLAYING:
			Playing.mousePressed(x, y);
			break;
		case MENU:
			Menu.mousePressed(x, y);
			break;
		case PAUSE:
			Pause.mousePressed(x, y);
			break;
		case GAMEOVER:
			Gameover.mousePressed(x, y);
			break;
		case SHOP:
			Shop.mousePressed(x, y);
			break;
		case SETTINGS:
			Settings.mousePressed(x, y);
			break;
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		switch(GameStates.gameState) {
		case PLAYING:
			Playing.mouseMoved(x, y);
			break;
		case MENU:
			Menu.mouseMoved(x, y);
			break;
		case PAUSE:
			Pause.mouseOver(x, y);
			break;
		case GAMEOVER:
			Gameover.mouseOver(x, y);
			break;
		case SHOP:
			Shop.mouseOver(x, y);
			break;
		}
	}

}
