package gameStates;

import java.awt.Graphics2D;
import java.util.Random;

import extra.Audios;
import extra.MyButton;
import main.Game;
import main.GameStates;

public class Menu {
	private Game game;
	
	private static MyButton start;

	private static MyButton shop;
	
	private static MyButton quit;
	
	private static MyButton moneyCheat;
	
	private static MyButton settings;
	
	static Audios audio = new Audios();
	static Random random = new Random();
	
	public Menu(Game game) {
		this.game = game;
		
		start=new MyButton(200, 200, 100, 100, "start");
		shop=new MyButton(200, 310, 100, 100, "schopp");
		quit=new MyButton(game.WINDOW_WIDTH-110, game.WINDOW_HEIGHT-110, 100, 100, "quit");
		moneyCheat=new MyButton(200, 420, 100, 100, "+100");
		settings=new MyButton(300, 200, 100, 100, "settings");

	}

	public void update() {
		
	}

	public void draw(Graphics2D g2) {
		start.draw(g2);
		quit.draw(g2);
		shop.draw(g2);
		moneyCheat.draw(g2);
		settings.draw(g2);
		int w = g2.getFontMetrics().stringWidth("drachnebaggs: "+Playing.münzen);
		g2.drawString("drachnebaggs: "+Playing.münzen, game.WINDOW_WIDTH-w-10, 30);
		int w2 = g2.getFontMetrics().stringWidth("multi: x"+Playing.münzenMultiplikator);
		g2.drawString("multi: x"+Playing.münzenMultiplikator, game.WINDOW_WIDTH-w2-10, 60);
		int w3= g2.getFontMetrics().stringWidth("Smaragde: "+Playing.smaragdz);
		g2.drawString("Smaragde: "+Playing.smaragdz, game.WINDOW_WIDTH-w3-10, 90);
	}

	public static void mousePressed(int x, int y) {
		if(start.getBounds().contains(x, y)) {
			Playing.resetAll();
			GameStates.gameState.setGameState(GameStates.PLAYING);
			int r = random.nextInt(3);
			if(r ==1) {
				audio.play("meddlloide");
			}
			else {
				audio.play("servus");
			}
			
		}
		if(quit.getBounds().contains(x, y)){
			System.exit(0);
		}
		if(shop.getBounds().contains(x, y)) {
			GameStates.gameState.setGameState(GameStates.SHOP);
		}
		if(moneyCheat.getBounds().contains(x, y)) {
			Playing.münzen+=100;
		}
		if(settings.getBounds().contains(x, y)) {
			GameStates.gameState.setGameState(GameStates.SETTINGS);
		}
		
	}

	public static void mouseMoved(int x, int y) {
		mM(x, y, start);
		mM(x, y, quit);
		mM(x, y, shop);
		mM(x, y, moneyCheat);
		mM(x, y, settings);
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
