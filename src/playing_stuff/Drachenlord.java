package playing_stuff;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;

import main.Game;

public class Drachenlord {
	private Game game;
	private int x;
	private int y, width, height;	
	
	private BufferedImage drachenlord;
	
	private Rectangle bounds;
	
	
	public Drachenlord(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		
//		x=100;
//		y=100;
		width = 120;
		height = 100;
		
		loadDrachenlord();
		
		initBounds();
	}
	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);
	}
	private void loadDrachenlord() {
		try {
			drachenlord = ImageIO.read(getClass().getResourceAsStream("/drachenlord/drachenlord_v2_2.png"));
		} catch (IOException e) {}}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(drachenlord, x, y-105, width, height, null);
		
//		g2.draw(bounds);
	}
	
	public void update() {
		setBounds(new Rectangle(x, y-105, width, height));
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x2) {
		this.x = x2;
	}
	public void setY(int y2) {
		this.y = y2;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
}
