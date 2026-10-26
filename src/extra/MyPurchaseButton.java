package extra;

import java.awt.*;

public class MyPurchaseButton extends MyButton{
	

	public String costs, text;
	private int x, y, widht, height;
	

	public MyPurchaseButton(int x, int y, int widht, int height, String text, String costs) {
		super(x, y, widht, height, text);
		
		this.x=x;
		this.y=y;
		this.widht=widht;
		this.height=height;
		this.text=text;
		this.costs=costs;
	}

	@Override
	public void draw(Graphics2D g2) {
		super.draw(g2);
		int w = g2.getFontMetrics().stringWidth(costs);
		int h = g2.getFontMetrics().getHeight();
		g2.setFont(new Font("Arial", 15, 15));
		g2.drawString(costs, x - w/2+widht/2, y+h/2+(height/3)*2);
	}
	
}
