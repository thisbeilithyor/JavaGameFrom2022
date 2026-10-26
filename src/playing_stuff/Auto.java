package playing_stuff;

import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;

public class Auto {
	
	BufferedImage audiA3;
	
	private int x;

	public int y;

	private int width = 100;

	private int height = 175;
	
	Rectangle bounds;
	
	public Auto(int x, int y){
		try {
			audiA3 = ImageIO.read(getClass().getResourceAsStream("/ults/audiA3_v1_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.x = x;
		this.y = y;
		bounds = new Rectangle(x, y, width, height);
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	public void setBounds(Rectangle newBounds) {
		this.bounds = newBounds;
	}
	
	public void update() {
		y-=3;
		setBounds(new Rectangle(x, y, width, height));
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(audiA3, x, y, width, height, null);
//		g2.draw(bounds);
	}
}
