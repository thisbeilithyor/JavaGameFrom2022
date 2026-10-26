package extra;

import java.awt.*;

public class MyButton {
	private int x, y, widht, height;
	public String text;
	
	public Color color = Color.white;
	
	
	
	private boolean mouseOver;
	
	
	//only for shop
	public boolean active = false;
	
	private Rectangle bounds;
	public MyButton(int x, int y, int widht, int height, String text) {
		this.x=x;
		this.y=y;
		this.widht=widht;
		this.height=height;
		this.text=text;
		
		initBounds();
	}
	private void initBounds() {
		bounds = new Rectangle(x, y, widht, height);
	}
	public void draw(Graphics2D g2) {
		if(mouseOver) {
			g2.setColor(Color.orange);
		}
		else if(active) {
			g2.setColor(Color.green);
		}
		else {
			g2.setColor(color);
		}
		g2.fillRect(x, y, widht, height);
		
		g2.setColor(Color.black);
		g2.drawRect(x, y, widht, height);
		
		g2.setFont(new Font("Arial", 20, 20));
		int w = g2.getFontMetrics().stringWidth(text);
		int h = g2.getFontMetrics().getHeight();
		g2.drawString(text, x - w/2+widht/2, y+h/2+height/2);
	}
	
	public void setMouseOver(boolean mouseOver) {
		this.mouseOver=mouseOver;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
}
