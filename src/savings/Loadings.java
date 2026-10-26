package savings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import extra.ammo;
import gameStates.Playing;
import gameStates.Settings;
import gameStates.Shop;

public class Loadings {
	
	static BufferedWriter bw;
	BufferedReader br;
	
	public Loadings() {
		
	}
	
//	public void loadGeschwindigkeit() {
//		try {
//			FileInputStream fis = new FileInputStream("Geschwindigkeit.txt");
//			InputStreamReader isr = new InputStreamReader(fis);
//			br=new BufferedReader(isr);
//			Playing.drachenlordSpeed = br.read();
//			System.out.println(Playing.drachenlordSpeed);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public int loadMünzen() {
//		int aa = 0;
//		try {
//			FileInputStream fis = new FileInputStream("Münznesaving.txt");
//			InputStreamReader isr = new InputStreamReader(fis);
//			br=new BufferedReader(isr);
//			aa = br.read();
//			br.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return aa;
//	}
//
//	public static void saveMünzen(int münzen) {
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter("Münznesaving.txt", false));
//			bw.write(münzen);
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}
//
//	public int loadMünzenMultiplikator() {
//		int a = 2;
//		
//		FileInputStream fis;
//		try {
//			fis = new FileInputStream("Münzenmultiplikatorsaving.txt");
//			InputStreamReader isr = new InputStreamReader(fis);
//			br = new BufferedReader(isr);
//			a=br.read();
////			System.out.println(a);
//			br.close();
////			System.out.println("has loaded");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		System.out.println("Loaded: "+a);
//		return a;
//	}
//	public static void saveMünzenMultiplikator(int muliplikatorwert) {
////		System.out.println(muliplikatorwert);
//		try {
//			BufferedWriter bw = new BufferedWriter(new FileWriter("Münzenmultiplikatorsaving.txt", false));
//			bw.write(muliplikatorwert);
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}
//
//	public int loadEP() {
//		int a = 0;
//		FileInputStream fis;
//		try {
//			fis = new FileInputStream("EPsaving.txt");
//			InputStreamReader isr = new InputStreamReader(fis);
//			br = new BufferedReader(isr);
//			try {
//				a=br.read();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				br.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return a;
//	}
//
//	public void saveEP(int ep) {
//		BufferedWriter bw;
//		try {
//			bw = new BufferedWriter(new FileWriter("EPsaving.txt", false));
//			bw.write(ep);
//			bw.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static void saveEverything(int coins, int multiplikator, int atomYN, int weaponEquiped, int smaragdz, int akYN, int ak2YN,
										int schrotYN, int pumpYN, int soundOnYN) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("Saving.txt", false));
			bw.write(coins+"\n");
			bw.write(multiplikator+"\n");
			bw.write(atomYN+"\n");
			bw.write(weaponEquiped+"\n");
			bw.write(smaragdz+"\n");
			bw.write(akYN+"\n");
			bw.write(ak2YN+"\n");
			bw.write(schrotYN+"\n");
			bw.write(pumpYN+"\n");
			bw.write(soundOnYN);
			bw.close();
//			System.out.println(coins);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadEverything() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("Saving.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String linie = null;
//			do {
				linie=br.readLine();
				int a = Integer.parseInt(linie);
				Playing.münzen = a;
				System.out.println(a);
				
				linie=br.readLine();
				int b = Integer.parseInt(linie);
				Playing.münzenMultiplikator=b;
				
				linie=br.readLine();
				int c = Integer.parseInt(linie);
				if(c==2) {
					Shop.atomFreigekauft=true;
				}
				if(c==1) {
					Shop.atomFreigekauft=false;
				}
				
				linie=br.readLine();
				int ddd = Integer.parseInt(linie);
				chooseAmmo(ddd);
				
				linie=br.readLine();
				int e = Integer.parseInt(linie);
				Playing.smaragdz=e;
				
				linie=br.readLine();
				int f = Integer.parseInt(linie);
				if(f==2) {
					Shop.akFreigekauft=true;
				}
				if(f==1) {
					Shop.akFreigekauft=false;
				}
				
				linie=br.readLine();
				int g = Integer.parseInt(linie);
				if(g==2) {
					Shop.ak2Freigekauft=true;
				}
				if(g==1) {
					Shop.ak2Freigekauft=false;
				}
				
				linie=br.readLine();
				int h = Integer.parseInt(linie);
				if(h==2) {
					Shop.schrotFreigekauft=true;
				}
				if(h==1) {
					Shop.schrotFreigekauft=false;
				}
				
				linie=br.readLine();
				int i = Integer.parseInt(linie);
				if(i==2) {
					Shop.pumpFreigekauft=true;
				}
				if(i==1) {
					Shop.pumpFreigekauft=false;
				}
				
//				linie=br.readLine();
//				int k = Integer.parseInt(linie);
//				if(k==2) {
//					Settings.soundOn=true;
//				}
//				if(k==3) {
//					Settings.soundOn=false;
//				}
				
//			}while(!(linie==null));
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void chooseAmmo(int ddd) {
		if(ddd>1) {
			ammo.choice=ddd-1;
		}
		else if(ddd==1) {
			ammo.choice=1;
		}
	}
}
