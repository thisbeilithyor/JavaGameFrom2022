package gameStates;

import extra.MyButton;
import main.Game;
import main.GameStates;

import java.awt.*;

public class Pause {
	private Game game;
	
	private static MyButton ahead;
	private static MyButton quit;
	private static MyButton newGame;
	
	public Pause(Game game) {
		this.game = game;
		
		ahead = new MyButton(100, 100, 100, 100, "ahead");
		quit = new MyButton(200, 100, 100, 100, "quit");
		newGame = new MyButton(100, 200, 100, 100, "newGame");
	}
	
	public void draw(Graphics2D g2) {
		ahead.draw(g2);
		quit.draw(g2);
		newGame.draw(g2);
		g2.drawString("Münzne: "+Playing.münzen, 150, 400);
		g2.drawString("vernichdede Haider: "+Playing.vernichteteHaider, 150, 450);
	}

	public static void mousePressed(int x, int y) {
		if(ahead.getBounds().contains(x, y)) {
			Playing.cleanSwitch();
			
			GameStates.gameState.setGameState(GameStates.PLAYING);
		}
		if(quit.getBounds().contains(x, y)) {
//			Playing.resetAll();
			GameStates.gameState.setGameState(GameStates.GAMEOVER);
		}
		if(newGame.getBounds().contains(x, y)) {
			Playing.resetAll();
//			Playing.cleanSwitch();
			GameStates.gameState.setGameState(GameStates.PLAYING);
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public static void mouseOver(int x, int y) {
		mM(x, y, ahead);
		mM(x, y, quit);
		mM(x, y, newGame);
	}
	
	private static void mM(int x, int y, MyButton myButton) {
		if(myButton.getBounds().contains(x, y)) {
			myButton.setMouseOver(true);
		}
		else {
			myButton.setMouseOver(false);
		}
	}
}
