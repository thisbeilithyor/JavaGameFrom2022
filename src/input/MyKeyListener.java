package input;

import java.awt.*;
import java.awt.event.*;

import main.GameScene;
import main.GameStates;
import gameStates.Menu;
import gameStates.Playing;

public class MyKeyListener implements KeyListener{
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(GameStates.gameState) {
		case MENU:
			break;
		case PLAYING:
			Playing.keyPressed(e.getKeyCode());
			
			break;
		case PAUSE:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
