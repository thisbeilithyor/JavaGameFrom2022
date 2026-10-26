package playing_stuff;

import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;

public class Coin {
	
	BufferedImage coin;
	Rectangle bounds;
	
	private int x;
	public int y;
	private int width;
	private int height;
	
	public Coin(int x, int y) {
		this.x = x;
		this.y = y;
		
		width=40;
		height=40;
		
		initCoin();
		initBounds();
	}

	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);		
	}

	private void initCoin() {
		try {
			coin = ImageIO.read(getClass().getResourceAsStream("/collectables/coin_v1_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(coin, x, y, width, height, null);
	}
	
	public void update() {
		y+=2;
		setBounds(new Rectangle(x, y, width, height));
	}	
	
	private void setBounds(Rectangle rectangle) {
		this.bounds = rectangle;
		
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
