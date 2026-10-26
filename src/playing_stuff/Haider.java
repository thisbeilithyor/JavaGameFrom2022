package playing_stuff;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import java.awt.image.*;
import java.awt.*;

import main.Game;

public class Haider {
	private Game game;
	
	private BufferedImage hp100, hp90, hp80, hp70, hp60, hp50, hp40, hp30, hp20, hp10, hp0;
	private BufferedImage haider1, haider2, haider3;
	private Random random;
	public int x, y, width, height;
	public int HP=100;
	private int hpWidth=100, hpHeight=20;
	public int lvl;
	private Rectangle bounds;
	
	private int tempCounter=0;
	
	public Haider(Game game, int lvl) {
		this.game = game;
		random = new Random();
	
		
		width = getRandomSize();
		height = width;
		x = getRandomX();
		y = -100;
		this.lvl=lvl;
		
		loadHaider();
		loadHPLeiste();
		initBounds();
	}

	private void loadHPLeiste() {
		try {
			hp100=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_100.png"));
			hp90=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_90.png"));
			hp80=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_80.png"));
			hp70=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_70.png"));
			hp60=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_60.png"));
			hp50=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_50.png"));
			hp40=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_40.png"));
			hp30=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_30.png"));
			hp20=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_20.png"));
			hp10=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_10.png"));
			hp0=ImageIO.read(getClass().getResourceAsStream("/extra/haiderHP_v1_0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void initBounds() {
		bounds = new Rectangle(x, y, width, height-height/4);
	}

	private int getRandomSize() {
		int b = ThreadLocalRandom.current().nextInt(50, 120);
		return b;
	}

	private void loadHaider() {
		try {
			haider1= ImageIO.read(getClass().getResourceAsStream("/haider/haider_v2_1.png"));
			haider2=ImageIO.read(getClass().getResourceAsStream("/haider/haider_v2_2.png"));
			haider3=ImageIO.read(getClass().getResourceAsStream("/haider/haider_v2_3.png"));
		} catch (IOException e) {}
		}

	public void update() {
		tempCounter++;
		if(lvl==1) {
			y=y+1;
		}
		else if(lvl==2) {
			y=y+2;
		}
		else if(lvl==3) {
			if(tempCounter%2==1) {
				y=y+1;
			}
		}
		setBounds(new Rectangle(x, y, width, height-height/4));
	}

	private void setBounds(Rectangle rectangle) {
		this.bounds = rectangle;
		
	}

	public void draw(Graphics2D g2) {
		if(lvl==1) {
			g2.drawImage(haider1, x, y, width, height, null);
		}
		else if(lvl==2) {
			g2.drawImage(haider2, x, y, width, height, null);
		}
		else if(lvl==3) {
			g2.drawImage(haider3, x, y, width, height, null);
		}
		
		if(HP==100) {
			g2.drawImage(hp100, x, y, width, height/8,null);
		}
		else if(HP>=90) {
			g2.drawImage(hp90, x, y, width, height/8,null);
		}else if(HP>=80) {
			g2.drawImage(hp80, x, y, width, height/8,null);
		}else if(HP>=70) {
			g2.drawImage(hp70, x, y, width, height/8,null);
		}else if(HP>=60) {
			g2.drawImage(hp60, x, y, width, height/8,null);
		}else if(HP>=50) {
			g2.drawImage(hp50, x, y, width, height/8,null);
		}else if(HP>=40) {
			g2.drawImage(hp40, x, y, width, height/8,null);
		}else if(HP>=30) {
			g2.drawImage(hp30, x, y, width, height/8,null);
		}else if(HP>=20) {
			g2.drawImage(hp20, x, y, width, height/8,null);
		}else if(HP>=10) {
			g2.drawImage(hp10, x, y, width, height/8,null);
		}else if(HP>=0) {
			g2.drawImage(hp0, x, y, width, height/8,null);
		}
		
//		g2.draw(bounds);
	}
	
	private int getRandomX() {
		int a = random.nextInt(500-width);
		return a;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
}
