package extra;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ammo {
	private int x;
	public int y;
	
	int width=10, height=25;
	
	private Rectangle bounds;
	
	public static int choice;
	
	public int damage;
	
	private BufferedImage rocket, atom, ak, ak2, schrot, pump;
	
	public ammo(int x, int y) {
		this.x = x;
		this.y = y;
		
		initBounds();
		initAmmoImg();
	}
	
	private void initAmmoImg() {
		try {
			rocket=ImageIO.read(getClass().getResourceAsStream("/extra/rocket_v1_1.png"));
			atom=ImageIO.read(getClass().getResourceAsStream("/extra/rocket_atom_v1_1.png"));
			ak=ImageIO.read(getClass().getResourceAsStream("/extra/rocket_ak_v1_1.png"));
			ak2=ImageIO.read(getClass().getResourceAsStream("/extra/rocket_ak_v1_2.png"));
			schrot=ImageIO.read(getClass().getResourceAsStream("/extra/rocket_strahl_v1_1.png"));
			pump = ImageIO.read(getClass().getResourceAsStream("/extra/rocket_pump_v1_1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initBounds() {
		bounds = new Rectangle(x, y, width, height);
	}

	public void draw(Graphics2D g2) {
		if(choice==1) {
			g2.drawImage(rocket, x, y, width, height,null);
		}
		else if(choice==2) {
			g2.drawImage(atom, x, y, width, height, null);
		}
		else if(choice==3) {
			g2.drawImage(ak, x, y, width, height, null);
		}
		else if(choice==4) {
			g2.drawImage(ak2, x, y, width, height, null);
		}
		else if(choice==5) {
			g2.drawImage(schrot, x, y, width, height, null);
		}
		else if(choice==6) {
			g2.drawImage(pump, x, y, width, height, null);
		}
//		g2.fillPolygon(new int[] {x+5, x, x+10}, new int[] {y-15, y, y}, 3);
//		g2.draw(bounds);
	}
	public void update() {
		y-=3;
		setBounds(new Rectangle(x, y, width, height));
		if(choice==1) {
			damage=10;
		}
		else if(choice==2) {
			damage=30;
		}
		else if(choice==3) {
			damage=5;
			y-=3;
		}
		else if(choice==4) {
			damage=10;
			y-=3;
		}
		else if(choice==5) {
			damage=20;
			y-=2;
		}
		else if(choice==6) {
			damage=40;
			y-=5;
		}
		setDamage(damage);
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
			this.damage=damage;
	}
}
