package playing_stuff;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Game;

import java.awt.*;

public class Schanze {
	private Game game;
	private BufferedImage schanze;
	private BufferedImage hp100, hp90, hp80, hp70, hp60, hp50, hp40, hp30, hp20, hp10, hp0;
	
	private Rectangle bounds;
	
	public int HP = 100;
	
	private int hpX=10, hpY=575, hpWidth=75, hpHeight=20;
	
	public Schanze(Game game) {
		this.game = game;
		
		loadSchanzeImg();
		loadHPAnzeige();
		
		initBounds();
	}
	
	private void initBounds() {
		bounds = new Rectangle(0, 540, 100*5, 25*4);
	}

	private void loadSchanzeImg() {
		try {
			schanze = ImageIO.read(getClass().getResourceAsStream("/extra/schanze_v1_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadHPAnzeige() {
		try {
			hp100 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_100.png"));
			hp90 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_90.png"));
			hp80 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_80.png"));
			hp70 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_70.png"));
			hp60 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_60.png"));
			hp50 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_50.png"));
			hp40 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_40.png"));
			hp30 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_30.png"));
			hp20 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_20.png"));
			hp10 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_10.png"));
			hp0 = ImageIO.read(getClass().getResourceAsStream("/extra/hp_v1_0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(schanze, 0, 500, 100*5, 25*4,null);
	}
	
	public void drawHPAnzeige(Graphics2D g2) {
		if(HP==100) {
			g2.drawImage(hp100, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==90) {
			g2.drawImage(hp90, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==80) {
			g2.drawImage(hp80, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==70) {
			g2.drawImage(hp70, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==60) {
			g2.drawImage(hp60, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==50) {
			g2.drawImage(hp50, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==40) {
			g2.drawImage(hp40, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==30) {
			g2.drawImage(hp30, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==20) {
			g2.drawImage(hp20, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP==10) {
			g2.drawImage(hp10, hpX, hpY, hpWidth, hpHeight,null);
		}
		else if(HP<=0) {
			g2.drawImage(hp0, hpX, hpY, hpWidth, hpHeight,null);
		}
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
}
