package main;

import javax.swing.*;

import gameStates.Gameover;
import gameStates.Menu;
import gameStates.Pause;
import gameStates.Playing;
import gameStates.Settings;
import gameStates.Shop;

public class Game extends JFrame implements Runnable{
	Thread gameThread;
	
	Menu menu;
	Playing playing;
	Pause pause;
	Gameover gameover;
	Shop shop;
	Settings settings;
	
	public int WINDOW_WIDTH=500;
	public static int WINDOW_HEIGHT=600;
	
	GameScene gs = new GameScene(this);
	public Game() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.add(gs);
		this.pack();
		
		initClasses();
		
		this.setVisible(true);
	}
	
	private void initClasses() {
		menu = new Menu(this);
		playing = new Playing(this);
		pause = new Pause(this);
		gameover = new Gameover(this);
		shop = new Shop(this);
		settings = new Settings(this);
	}
	
	public void start() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double space = 1000000000 / 60;
		long lastTime = System.nanoTime();
		long now;
		long timer = 0;
		double delta=0;
		
		int counter = 0;
		
		while(gameThread != null) {
			
			now = System.nanoTime();
			
			delta += (now-lastTime)/space;
			timer += (now-lastTime);
			lastTime = now;
			
			
			if(delta >= 1) {
				repaint();
				gs.update();
				delta--;
				counter++;
			}
			
			if(timer >= 1000000000) {
//				System.out.println("FPS: " + counter);
				timer=0;
				counter=0;
			}
		}
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Playing getPlaying() {
		return playing;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}
	
	public Pause getPause() {
		return pause;
	}
	
	public void setPause(Pause pause) {
		this.pause = pause;
	}
	
	public Gameover getGameover() {
		return gameover;
	}
	
	public void setGameover(Gameover gameover) {
		this.gameover = gameover;
	}

	public Shop getShop() {
		// TODO Auto-generated method stub
		return shop;
	}
	
	public Settings getSettings() {
		return settings;
	}
}
