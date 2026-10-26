package playing_stuff;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Game;

public class x2 {
	
	Game game;
	
	BufferedImage x2img;
	
	public int x, y, width, height;
	
	private Rectangle bounds;
	
	public x2(Game game, int x, int y) {
		this.game = game;
		this.x = x;
		this.y = y;
		width=30;
		height=30;
		loadImage();
		
		initBounds();
	}
	
	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);
	}

	private void loadImage() {
		try {
			x2img = ImageIO.read(getClass().getResourceAsStream("/collectables/x2_v1_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void draw(Graphics2D g2) {
		g2.drawImage(x2img, x, y, width, height, null);
//		g2.draw(bounds);
	}
	public void update() {
		y+=2;
		setBounds(new Rectangle(x, y, width, height));
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
}
