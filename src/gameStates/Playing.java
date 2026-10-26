package gameStates;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import java.awt.image.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import main.Game;
import main.GameStates;
import playing_stuff.Animations;
import playing_stuff.Auto;
import playing_stuff.Burger;
import playing_stuff.Coin;
import playing_stuff.Drachenlord;
import playing_stuff.EP;
import playing_stuff.Haider;
import playing_stuff.Schanze;
import playing_stuff.Smaragd;
import playing_stuff.x2;
import savings.Loadings;
import extra.*;

import java.awt.*;

public class Playing {
	
	private Game game;
	private ammo ammo;
	public static int x;
	public static int y;
	public static int xx;
	public static int yy;
	
	private static Timer timer2;
	
	private static ArrayList<ammo> kugeln = new ArrayList<>();
	private static ArrayList<Haider> haider = new ArrayList<>();
	private static ArrayList<playing_stuff.x2> x2 = new ArrayList<>();
	private static ArrayList<Animations> bloodAnimations = new ArrayList<>();
	private static ArrayList<Burger> burgers = new ArrayList<>();
	private static ArrayList<Coin> coins = new ArrayList<>();
	private static ArrayList<Smaragd> smaragds = new ArrayList<>();
	private static ArrayList<Auto> autos = new ArrayList();
	//	private static ArrayList<Animations> hitAnimations = new ArrayList<>();
	
	private Drachenlord drachenlord;
	
	private long now, nowII;
	private static long lastTime = System.nanoTime(), lastTimeII = System.nanoTime();
	private static double space = 1000000000 / 2, spaceII = 1000000000 * 2;
	private double delta, deltaII;
	
	private Random random;
	
	private static Schanze schanze;
	
	static int vernichteteHaider = 0;
	public static double drachenlordSpeed = 3.0;
	
	static int shotsLvl=1;
	
	public static int münzen;
	public static int münzenMultiplikator = 1;
	public static int smaragdz;
	public int score = 0;
	
	long gameTime;
	static long start= System.nanoTime();
	static long nowIII;
	private int absoluSpace = 1;
	
	private static MyButton autoUlt ;
	
	static Thread autoThread;
	
	private Loadings loadings = new Loadings();
	
	private static boolean autoUltReady = true;
	private static boolean autoTimerOn = false;
	
	private long autoNow;
	private static long autoLastTime = System.nanoTime();
	private static double autoSpace = 1000000000 / 0.05;
	private double autoDelta;
	
	private static String autoBtnTxt = "A3";
	
	static Audios audio = new Audios();
	
	public Playing(Game game) {
		this.game = game;
		
		timer2 = new Timer();
		random = new Random();
		schanze = new Schanze(game);
		
		y = game.WINDOW_HEIGHT;
		x = game.WINDOW_WIDTH/2;
		yy = game.WINDOW_HEIGHT;
		xx = game.WINDOW_WIDTH/2;
		
//		münzen = loadings.loadMünzen();
//		münzenMultiplikator = loadings.loadMünzenMultiplikator();
//		ep = loadings.loadEP();
		
		autoUlt = new MyButton(350, 550, 60, 40, autoBtnTxt);
		
		drachenlord = new Drachenlord(game, x, y);
		
//		autoUlt.color = Color.green;
	}


	public void update() {
		//kugeln schießen
		now = System.nanoTime();
		if(extra.ammo.choice==3 || extra.ammo.choice==4) {
			space=1000000000/4;
		}
		else if(extra.ammo.choice==6) {
			space=1000000000;
		}
		else {
			space=1000000000/2;
		}
		delta+=(now-lastTime)/space;
		lastTime = now;
		if(delta >= 1) {
			spawnOne(x+15, y-100);
			spawnOne(x+95, y-100);
			delta--;
		}
		
		//haider spawnen
		nowIII =System.nanoTime();
		
		gameTime = nowIII-start;
		
		nowII = System.nanoTime();
		deltaII+=(nowII-lastTimeII)/spaceII;
		lastTimeII = nowII;
		if(deltaII >= absoluSpace) {
			//nach ca. 33 sek spawnt lvl 1+2 haider
			if(gameTime<1000000000 / 0.03) {
//						6516607500
				haider.add(new Haider(game, 1));
				System.out.println("Typ 1");
			}
			else if(gameTime<1000000000 / 0.016){
				System.out.println("Typ 2");
				int v = random.nextInt(3);
				if(v<=1) {
					haider.add(new Haider(game, 1));
				}
				else if(v<=2) {
					haider.add(new Haider(game, 2));
				}
			}
			else if(gameTime<1000000000 / 0.011) {
				System.out.println("Typ 3");
				haider.add(new Haider(game, 2));
			}
			else {
				System.out.println("Typ 4");
				int v = random.nextInt(3);
				if(v<=1) {
//					spaceII=1000000000*2;
					haider.add(new Haider(game, 2));
				}
				else if(v<=2) {
//					spaceII=1000000000*4;
					lastTimeII=System.nanoTime();
					haider.add(new Haider(game, 3));
				}
			}
			deltaII--;
		}
		
		//kugeln nach oben bewegen und über bildschirm entfernen
		for(int i=0; i<kugeln.size(); i++) {
			kugeln.get(i).update();
			if(kugeln.get(i).y <=-5) {
				kugeln.remove(i);
			}
		}
		
		//drachenlord bewegen
		drachenlord.setX(x);
		drachenlord.setY(y);
		drachenlord.update();
		
		//haiders bewegen und über bildschirm entfernen
		for(int i=0; i<haider.size(); i++) {
			haider.get(i).update();
			if(haider.get(i).y >= 800) {
				haider.remove(i);
			}
		}
		
		//trefferüberprüfung
		for(int i=0; i<haider.size(); i++) {
			for(int j=0; j<kugeln.size(); j++) {
				if(kugeln.get(j).getBounds().intersects(haider.get(i).getBounds())) {
					haider.get(i).HP-=kugeln.get(j).getDamage();
					kugeln.remove(j);
					if(haider.get(i).HP<0) {
						haiderTod(i);
						int r = random.nextInt(5);
						if(r==2) {
							audio.play("kill");
						}
						else if(r==3) {
							audio.play("kill");
						}
						else if(r==4) {
							audio.play("ausdiemaus");
						}
					}
					break;
				}
			}
		}
		
		//animationen nach abspielen wieder entfernen
		for(int i=0; i<bloodAnimations.size(); i++) {
			if(bloodAnimations.get(i).bloodCounter>80) {
				bloodAnimations.remove(i);
			}
		}
		
		//collectables updaten
		for(int i=0; i<x2.size(); i++) {
			x2.get(i).update();
			if(x2.get(i).y>900) {
				x2.remove(i);
			}
		}
		for(int i=0; i<burgers.size(); i++) {
			burgers.get(i).update();
			if(burgers.get(i).y>900) {
				burgers.remove(i);
			}
		}
		for(int i=0; i<coins.size(); i++) {
			coins.get(i).update();
			if(coins.get(i).y>900) {
				coins.remove(i);
			}
		}
		
		for(int i=0; i<smaragds.size(); i++) {
			smaragds.get(i).update();
			if(smaragds.get(i).y>900) {
				smaragds.remove(i);
			}
		}
		
		//collectables überprüfung
		for(int i=0; i<x2.size(); i++) {
			if(x2.get(i).getBounds().intersects(drachenlord.getBounds())) {
				x2.remove(i);
				if(space>=1000000000/4) {
					space=space/(1.4);
					System.out.println(space);
					
					shotsLvl++;
				}
			}
		}
		for(int i=0; i<burgers.size(); i++) {
			if(burgers.get(i).getBounds().intersects(drachenlord.getBounds())) {
				burgers.remove(i);
				if(schanze.HP<100) {
					schanze.HP+=10;
				}
			}
		}
		for(int i=0; i<coins.size(); i++) {
			if(coins.get(i).getBounds().intersects(drachenlord.getBounds())) {
				coins.remove(i);
				münzen=münzen+(1*münzenMultiplikator);
			}
		}

		for(int i=0; i<smaragds.size(); i++) {
			if(smaragds.get(i).getBounds().intersects(drachenlord.getBounds())) {
				smaragds.remove(i);
				smaragdz++;
				System.out.println(smaragdz);
			}
		}
		
		//schanzenangriff überprüfung
		for(int i=0; i<haider.size();i++) {
			if(haider.get(i).getBounds().intersects(schanze.getBounds())) {
				switch(haider.get(i).lvl) {
				case 1:
					schanze.HP=schanze.HP-10;
					break;
				case 2:
					schanze.HP-=20;
					break;
				case 3:
					schanze.HP-=50;
					break;
				case 4:
					break;
				}
				
				int r = random.nextInt(4);
				if(r==2) {
					audio.play("enemyhit");
				}
				else if(r==3){
					audio.play("enemyhit");
				}
				
				haider.remove(i);
				if(schanze.HP<=0) {
					GameStates.gameState.setGameState(GameStates.GAMEOVER);
					audio.play("gameover");
				}
			}
		}
		
		//Autos updaten
		for(int i=0; i<autos.size(); i++) {
			autos.get(i).update();
			if(autos.get(i).y <= -200) {
				autos.remove(i);
			}
		}
		
		//Autos Trefferüberprüfung mit haidern
		for(int i=0; i<autos.size(); i++) {
			for(int j=0; j<haider.size(); j++) {
				if(autos.get(i).getBounds().contains(haider.get(j).x, haider.get(j).y)) {
					haider.get(j).HP-=100000;
				}
				if(haider.get(j).HP<=0) {
					haiderTod(j);
				}
			}			
		}
		
		//autoUltTimer
		if(autoUltReady == false ) {
			autoNow =System.nanoTime();
			autoDelta+=(autoNow-autoLastTime)/autoSpace;
			if(autoDelta >= 1) {
				autoUltReady = true;
				autoDelta--;
				autoLastTime = System.nanoTime();
			}
			autoLastTime = autoNow;
		}
		if(autoUltReady) {
			autoUlt.text = "A3";
			autoUlt.color = Color.green;
		}
		else {
			autoUlt.text = "load..";
			autoUlt.color = Color.red;
		}
	}

	


	private void haiderTod(int deadHaider) {
		spawnCollectable(haider.get(deadHaider).x, haider.get(deadHaider).y, haider.get(deadHaider).lvl);
		bloodAnimations.add(new Animations(game, haider.get(deadHaider).x, haider.get(deadHaider).y, haider.get(deadHaider).width, haider.get(deadHaider).height));
		switch(haider.get(deadHaider).lvl) {
		case 1:
			score+=10;
			break;
		case 2:
			score+=20;
			break;
		}
		haider.remove(deadHaider);
		vernichteteHaider++;
		
	}


	public void draw(Graphics2D g2) {
		//schanze zeichenen
		schanze.draw(g2);
		
		//animationen zeichnen
		for(int i=0; i<bloodAnimations.size(); i++) {
			bloodAnimations.get(i).playBloodAnimations(g2);
		}
		
		//alle geschosse zeichnen
		for(int i=0; i<kugeln.size(); i++) {
			kugeln.get(i).draw(g2);
		}
				
		//collectables zeichenen
		for(x2 element : x2) {
			element.draw(g2);
		}
		for(Burger element : burgers) {
			element.draw(g2);
		}
		for(Coin element : coins) {
			element.draw(g2);
		}

		for(Smaragd element : smaragds) {
			element.draw(g2);
		}
		
		//haider zeichnen
				for(int i=0; i<haider.size(); i++) {
					haider.get(i).draw(g2);
		}
				
		//AutoUlt zeichnen
		for(int i=0; i<autos.size(); i++) {
			autos.get(i).draw(g2);	
		}
		//drachenlord zeichnen
		drachenlord.draw(g2);
		
		
		
		
		
		//vernichteteHaider anzeige
//		g2.drawString("vernichdede Haider: "+vernichteteHaider, 300, 50);
		
		//Münzenanzeige
		g2.drawString("Münzne: "+münzen, 300, 50);
		
		//EP-Anzeige
		g2.drawString("Smaragde: "+smaragdz, 300, 65);
		
		//HP-Anzeige Schanze zeichenen
		schanze.drawHPAnzeige(g2);
		
		//Punkte zeichnen
		g2.drawString("Score: "+score, 300, 80);
		
		//Schussschnelligkeitslevel zeichnen
		g2.setFont(new Font("Arial", 20, 20));
		g2.drawString("SLvl: "+shotsLvl, 400, 575);
		
		//AutoUltButton
		autoUlt.draw(g2);
		

		
		
	}
	
	private void spawnCollectable(int x, int y, int lvl) {
		switch(lvl) {
		case 1:
			randomCollect(20, x, y);
			break;
		case 2:
			randomCollect(10, x, y);
			break;
		case 3:
			randomCollect(4, x, y);
			break;
		}
	}
	
	private void randomCollect(int i, int x, int y) {
//		int YN=0;
//		while(YN==0) {
//			YN = random.nextInt(i+1);
//		}
//		if(YN==1) {
		int r = random.nextInt(5);
			if(r==1) {
				x2.add(new x2(game, x, y));
			}else if(r==2){
				burgers.add(new Burger(x, y));
			}else if(r==3) {
				coins.add(new Coin(x, y));
			}else if(r==4) {
				smaragds.add(new Smaragd(x, y));
			}
//		}
	}


	private void spawnOne(int x, int y) {
		//spawnt Geschoss
		kugeln.add(new ammo(x, y));
	}
	
	public static void resetAll() {
		y = yy;
		x = xx;
		kugeln = new ArrayList<>();
		haider = new ArrayList<>();
		coins = new ArrayList<>();
		x2 = new ArrayList<>();
		bloodAnimations = new ArrayList<>(); 
		space=1000000000 /2;
		schanze.HP=100;
		vernichteteHaider=0;
		cleanSwitch();
		shotsLvl=1;
		autoUltReady = true;
		autos = new ArrayList<>();
		burgers = new ArrayList<>();
		smaragds  = new ArrayList<>();
	}
	
	public static void cleanSwitch() {
		lastTime=System.nanoTime();
		lastTimeII=System.nanoTime();
		start=System.nanoTime();
		autoLastTime = System.nanoTime();
	}

	public static void keyPressed(int keyCode) {
		if(keyCode == KeyEvent.VK_D) {
			if(Playing.x<=500-100){
				Playing.x+=drachenlordSpeed;
			}
		}
		else if(keyCode == KeyEvent.VK_A) {
			if(Playing.x>0-15) {
				Playing.x-=drachenlordSpeed;
			}
		}
		else if(keyCode == KeyEvent.VK_ESCAPE) {
			GameStates.gameState.setGameState(GameStates.PAUSE);
		}
		else if(keyCode == KeyEvent.VK_SPACE){
			autoUlt();
		}
	}
	
	


	public static void mouseMoved(int x, int y) {
		mM(x, y, autoUlt);
	}

	private static void mM(int x, int y, MyButton myButton) {
		if(myButton.getBounds().contains(x, y)) {
			myButton.setMouseOver(true);
		}
		else {
			myButton.setMouseOver(false);
		}
	}


	public static void mousePressed(int x3, int y2) {
		if(autoUlt.getBounds().contains(x3, y2)) {
			autoUlt();
		}
		
	}
	private static void autoUlt() {
		if(autoUltReady) {
			audio.play("100sachen80");
			for(int i=0; i<5; i++) {
				autos.add(new Auto(i*100, Game.WINDOW_HEIGHT));
			}
			autoUltReady=false;
			autoLastTime = System.nanoTime();
		}
	}	
}
