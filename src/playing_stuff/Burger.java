package playing_stuff;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

public class Burger {
	
	BufferedImage burger;
	Rectangle bounds;
	
	int x;
	public int y;
	int width;
	int height;
	
	public Burger(int x, int y)	{
		loadBurger();
		
		this.x=x;
		this.y=y;
		width=40;
		height=40;
		
		initBounds();
	}
	
	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);
	}

	private void loadBurger() {
		try {
			burger=ImageIO.read(getClass().getResourceAsStream("/collectables/burger_v1_!.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {
		g2.drawImage(burger, x, y, width, height, null);
	}
	
	public void update() {
		y+=2;
		setBounds(new Rectangle(x, y, width, height));
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds=bounds;
	}
}
