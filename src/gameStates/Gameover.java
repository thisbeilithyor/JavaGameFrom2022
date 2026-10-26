package gameStates;

import java.awt.*;

import extra.MyButton;
import main.Game;
import main.GameStates;

public class Gameover {
	Game game;
	static MyButton ok, newGame;
	public Gameover(Game game) {
		this.game = game;
		ok = new MyButton(game.WINDOW_WIDTH/2-50, 300, 100, 100, "ok");
		newGame = new MyButton(game.WINDOW_WIDTH/2-50, 400, 100, 100, "new game");
	}
	
	public void draw(Graphics2D g2) {
		int w = g2.getFontMetrics().stringWidth("Schanze gestürzt");
		g2.setFont(new Font("Arial", 20, 30));
		g2.drawString("Schanze gestürzt", game.WINDOW_WIDTH/2 - w/2 - 65, 150);
		g2.setFont(new Font("Arial", 20, 20));
		int w2 = g2.getFontMetrics().stringWidth("vernichdede Haider: "+Playing.vernichteteHaider);
		g2.drawString("vernichdede Haider: "+Playing.vernichteteHaider, game.WINDOW_WIDTH/2-w2/2, 200);
		ok.draw(g2);
		newGame.draw(g2);
		
		int w3 = g2.getFontMetrics().stringWidth("münzne: "+Playing.münzen);
		g2.drawString("münzne: "+Playing.münzen, game.WINDOW_WIDTH/2-w3/2, 240);
	}
	
	public void update() {
		
	}

	public static void mousePressed(int x, int y) {
		if(ok.getBounds().contains(x, y)) {
			Playing.resetAll();
			GameStates.gameState.setGameState(GameStates.MENU);
		}
		if(newGame.getBounds().contains(x, y)) {
			Playing.resetAll();
			Playing.cleanSwitch();
			GameStates.gameState.setGameState(GameStates.PLAYING);
		}
	}

	public static void mouseOver(int x, int y) {
		mM(x, y, ok);
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

