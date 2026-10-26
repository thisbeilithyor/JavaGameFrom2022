package gameStates;

import java.awt.*;

import extra.Audios;
import extra.MyButton;
import extra.MyPurchaseButton;
import extra.ammo;
import main.Game;
import main.GameStates;
import savings.Loadings;

public class Shop {
	
	static MyPurchaseButton multiplikatorUp;
	static MyButton menu;
	
	static MyPurchaseButton rocket;
	public static MyPurchaseButton atom;
	public static MyPurchaseButton ak, ak2;
	public static MyPurchaseButton schrot, pump;
	
	public static boolean atomFreigekauft = false, akFreigekauft = false, ak2Freigekauft = false;
	public static boolean schrotFreigekauft = false;
	public static boolean pumpFreigekauft = false;
	public static boolean rocketFreigkauft = true;
	
	static Audios audio = new Audios();
	
	static Loadings loadings = new Loadings();
	
	public Shop(Game game) {
		multiplikatorUp = new MyPurchaseButton(100, 100, 100 , 100, "CoinMulti", "10 s");
		menu = new MyButton(400, 500, 50, 40, "menu");
		rocket = new MyPurchaseButton(100, 220, 100, 100, "rocket", "owning");
		atom = new MyPurchaseButton(100, 340, 100, 100, "atom", "25000");
		ak=new MyPurchaseButton(220, 220, 100, 100, "ak", "100");
		ak2=new MyPurchaseButton(340, 220, 100, 100, "ak2", "250");
		schrot=new MyPurchaseButton(220, 340, 100, 100, "schrot", "400");
		pump=new MyPurchaseButton(340, 340, 100, 100, "pump", "1000");
	}
	
	public void draw(Graphics2D g2) {
//		g2.drawRect(100, 100, 100, 100);
		g2.drawString("Münzne: "+Playing.münzen, 400, 15);
		g2.drawString("Smaragde: "+Playing.smaragdz, 400, 30);
		
		g2.drawString("Münzenmultiplikator", 100, 80);
		g2.drawString("x "+Playing.münzenMultiplikator,100, 95);
		
		
		
		multiplikatorUp.draw(g2);
		
		menu.draw(g2);
		
		rocket.draw(g2);
		atom.draw(g2);
		ak.draw(g2);
		ak2.draw(g2);
		schrot.draw(g2);
		pump.draw(g2);
	}
	
	public void update() {
		rocket.active = false;
		atom.active=false;
		ak.active=false;
		ak2.active=false;
		schrot.active=false;
		pump.active=false;
		if(ammo.choice==1) {
			rocket.active = true;
		}
		else if(ammo.choice==2) {
			atom.active = true;
		}
		else if(ammo.choice==3) {
			ak.active=true;
		}
		else if(ammo.choice==4) {
			ak2.active=true;
		}
		else if(ammo.choice==5) {
			schrot.active=true;
		}
		else if(ammo.choice==6) {
			pump.active=true;
		}
		
		if(atomFreigekauft) {
			atom.costs="owning";
		}
		if(akFreigekauft) {
			ak.costs="owning";
		}
		if(ak2Freigekauft) {
			ak2.costs="owning";
		}
		if(schrotFreigekauft) {
			schrot.costs="owning";
		}
		if(pumpFreigekauft) {
			pump.costs="owning";
		}
	}

	public static void mousePressed(int x, int y) {
		if(multiplikatorUp.getBounds().contains(x, y)) {
			if(Playing.smaragdz>=10) {
				Playing.münzenMultiplikator++;
				Playing.smaragdz-=10;
			}
			else {
				System.out.println("geringverdiener");
			}
		}
		if(menu.getBounds().contains(x, y)) {
			GameStates.gameState.setGameState(GameStates.MENU);
		}
		
		rocketFreigkauft = waffenWechsel(x, y, rocket, rocketFreigkauft, 0, 1);
		atomFreigekauft = waffenWechsel(x, y, atom, atomFreigekauft, 25000, 2);
		akFreigekauft = waffenWechsel(x, y, ak, akFreigekauft, 100, 3);
		ak2Freigekauft = waffenWechsel(x, y, ak2, ak2Freigekauft, 250, 4);
		schrotFreigekauft = waffenWechsel(x, y, schrot, schrotFreigekauft, 400, 5);
		pumpFreigekauft = waffenWechsel(x, y, pump, pumpFreigekauft, 1000, 6);
	}

	public static void mouseOver(int x, int y) {
		mM(x, y, menu);
		mM(x, y, rocket);
		mM(x, y, atom);
		mM(x, y, multiplikatorUp);
		mM(x, y, ak);
		mM(x, y, ak2);
		mM(x, y, schrot);
		mM(x, y, pump);
	}

	private static void mM(int x, int y, MyButton myButton) {
		if(myButton.getBounds().contains(x, y)) {
			myButton.setMouseOver(true);
		}
		else {
			myButton.setMouseOver(false);
		}
	}
	
	private static boolean waffenWechsel(int x, int y, MyPurchaseButton button, boolean freigekauft, int betrag, int choice){
		if(button.getBounds().contains(x, y) && freigekauft == true) {
			ammo.choice=choice;
			audio.play("freundlich");
		}
		else if(button.getBounds().contains(x,y) && freigekauft == false){
			if(Playing.münzen>=betrag) {
				Playing.münzen-=betrag;
				freigekauft=true;
				ammo.choice=choice;
				System.out.println(choice+" freigekauft");
			}
			else {
				System.out.println("zu wenig göld");
			}
		}
		return freigekauft;
	}
}