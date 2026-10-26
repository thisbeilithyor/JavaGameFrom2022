package playing_stuff;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Smaragd {
	
	private BufferedImage smaragd;
	
	Rectangle bounds;
	
	int x;
	public int y;
	int width;
	int height;
	
	public Smaragd(int x, int y) {
		loadImage();
		this.x=x;
		this.y=y;
		width=40;
		height=40;
		
		initBounds();
	}
	
	private void loadImage() {
		try {
			smaragd = ImageIO.read(getClass().getResourceAsStream("/collectables/smaragd_v1_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	
	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);
	}


	public void draw(Graphics2D g2) {
		g2.drawImage(smaragd, x, y, width, height, null);
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
