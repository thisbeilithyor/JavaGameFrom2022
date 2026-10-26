package playing_stuff;

import java.awt.image.*;
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Game;

public class Animations {
	
	Game game;
	
	private int x, y, width, height;
	
	BufferedImage blood1, blood2, blood3, blood4, blood5;
	public int bloodCounter=0, bloodSpace=10;
	
//	BufferedImage hit1;
//	public int hitCounter=0, hitSpace=5;
	
	public Animations(Game game, int x, int y, int width, int height)	{
		this.game = game;
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		
		loadBloodAnimation();
//		loadHitAnimation();
	}

//	private void loadHitAnimation() {
//		try {
//			hit1 = ImageIO.read(getClass().getResourceAsStream("/animations/hit_v1_1.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	private void loadBloodAnimation() {
		try {
			blood1=ImageIO.read(getClass().getResourceAsStream("/animations/blood_v1_1.png"));
			blood2=ImageIO.read(getClass().getResourceAsStream("/animations/blood_v1_2.png"));
			blood3=ImageIO.read(getClass().getResourceAsStream("/animations/blood_v1_3.png"));
			blood4=ImageIO.read(getClass().getResourceAsStream("/animations/blood_v1_4.png"));
			blood5=ImageIO.read(getClass().getResourceAsStream("/animations/blood_v1_5.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void playBloodAnimations(Graphics2D g2) {
		if(bloodCounter<bloodSpace) {
			g2.drawImage(blood1, x, y, width, height, null);
		}else if(bloodCounter<bloodSpace*2) {
			g2.drawImage(blood2, x, y, width, height, null);
		}else if(bloodCounter<bloodSpace*3) {
			g2.drawImage(blood3, x, y, width, height, null);
		}else if(bloodCounter<bloodSpace*4) {
			g2.drawImage(blood4, x, y, width, height, null);
		}else if(bloodCounter<bloodSpace*5) {
			g2.drawImage(blood5, x, y, width, height, null);
		}
		bloodCounter++;
	}
	
//	public void playHitAnimation(Graphics2D g2) {
//		if(hitCounter<hitSpace) {
//			g2.drawImage(hit1, x, y, width, height, null);
//		}
//	}
}
