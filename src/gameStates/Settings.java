package gameStates;

import java.awt.Graphics2D;

import extra.MyButton;
import main.Game;
import main.GameStates;

public class Settings {
	
	static MyButton soundOnOff;
	static MyButton menu;
	
	public static boolean soundOn = true;
	
	public Settings(Game game) {
		soundOnOff=new MyButton(100, 100, 100, 100, "Sound: on");
		menu=new MyButton(200, 100, 100, 100, "menu");
	}

	public void update() {
		if(soundOn) {
			soundOnOff.text = "Sound: on";
		}
		else {
			soundOnOff.text= "Sound: off";
		}		
	}

	public void draw(Graphics2D g2) {
		soundOnOff.draw(g2);
		menu.draw(g2);
	}

	public static void mousePressed(int x, int y) {
		if(soundOnOff.getBounds().contains(x, y)) {
			if(soundOn) {
				soundOn = false;
				
			}
			else {
				soundOn = true;
			}
		}
		if(menu.getBounds().contains(x, y)) {
			GameStates.gameState.setGameState(GameStates.MENU);
		}
		
	}	
}