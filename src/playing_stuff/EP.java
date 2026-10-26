package playing_stuff;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EP {
	BufferedImage burger;
	Rectangle bounds;
	
	int x;
	public int y;
	int width;
	int height;
	
	public EP(int x, int y)	{
		loadEP();
		
		this.x=x;
		this.y=y;
		width=40;
		height=40;
		
		initBounds();
	}
	
	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);
	}

	private void loadEP() {
		try {
			burger=ImageIO.read(getClass().getResourceAsStream("/collectables/ep_v1_1.png"));
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
