package main;

import javax.swing.*;

import extra.ammo;
import gameStates.Playing;
import gameStates.Settings;
import gameStates.Shop;

import java.awt.*;
import java.awt.event.MouseListener;

import input.*;
import savings.Loadings;

public class GameScene extends JPanel{
	private Game game;
	private Dimension size;

	
	private MyKeyListener kl;
	private MyMouseListener ml;
	
	private int atomYN, akYN, ak2YN, schrotYN, pumpYN, soundOnYN;
	
	public GameScene(Game game) {
		this.game = game;
		
		this.setBackground(Color.white);
		
		initSize();
		initClasses();
		Loadings.loadEverything();
	}
	private void initClasses() {
		requestFocus();
		setFocusable(true);
		
		kl = new MyKeyListener();
		ml = new MyMouseListener();
		addMouseListener(ml);
		addMouseMotionListener(ml);
		addKeyListener(kl);
	}
	private void initSize() {
		size = new Dimension(game.WINDOW_WIDTH, game.WINDOW_HEIGHT);
		this.setMinimumSize(size);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
	}

	public void update() {
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().update();
			break;
		case PLAYING:
			game.getPlaying().update();
			break;
		case PAUSE:
			game.getPause().update();
			break;
		case GAMEOVER:
			game.getGameover().update();
			break;
		case SHOP:
			game.getShop().update();
			break;
		case SETTINGS:
			game.getSettings().update();
			break;
		}
//		Loadings.saveMünzen(Playing.münzen);
//		Loadings.saveMünzenMultiplikator(Playing.münzenMultiplikator);
		
		atomYN = yn(Shop.atomFreigekauft);
		akYN = yn(Shop.akFreigekauft);
		ak2YN = yn(Shop.ak2Freigekauft);
		schrotYN = yn(Shop.schrotFreigekauft);
		pumpYN = yn(Shop.pumpFreigekauft);
		
		if(Settings.soundOn) {
			soundOnYN = 2;
		}
		else {
			soundOnYN = 3;
		}
		
//		System.out.println(ammo.choice);
		Loadings.saveEverything(Playing.münzen, Playing.münzenMultiplikator, atomYN, 
				ammo.choice+1, Playing.smaragdz, akYN, ak2YN, schrotYN, pumpYN, soundOnYN);
	}
	
	private int yn(boolean freigekauft) {
		int YN;
		if(freigekauft==true) {
			YN=2;
		}
		else {
			YN=1;
		}
		return YN;
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
		
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().draw(g2);
			break;
		case PLAYING:
			game.getPlaying().draw(g2);
			break;
		case PAUSE:
			game.getPause().draw(g2);
			break;
		case GAMEOVER:
			game.getGameover().draw(g2);
			break;
		case SHOP:
			game.getShop().draw(g2);
			break;
		case SETTINGS:
			game.getSettings().draw(g2);
			break;
		}
	}
	
	
}
