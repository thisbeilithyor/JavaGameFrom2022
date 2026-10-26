package extra;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import gameStates.Settings;

public class Audios {
	
//	File file;
//	AudioInputStream audioStream;
//	Clip clip;
	
	public Audios() {
		
		
	}
	
	public void play(String audio) {
		if(Settings.soundOn) {
			try {
				
//				InputStream audioSrc = getClass().getResourceAsStream("res/sounds/"+audio+".wav");
//				InputStream bufferedIn = new BufferedInputStream(audioSrc);
//				AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
//				
//				
//				AudioFormat af = audioStream.getFormat();
//				
//				Clip clip = (Clip) AudioSystem.getLine(info);
//	            clip.open(af, audio, 0, size);
//	            clip.start();
	            
//	            File file = new File(audio);
//	    		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
//	    		Clip clip = AudioSystem.getClip();
//	    		clip.open(audioStream);
////				
//				
////				URL url = getClass().getResource("res/sounds/"+audio+".wav");
				File file = new File("res/sounds/"+audio+".wav");
//				System.out.println(url);
				
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
				
				
				
//				InputStream audioSrc = getClass().getResourceAsStream("resources/test.wav");
//				InputStream bufferedIn = new BufferedInputStream(audioSrc);
//				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
//
//	            AudioFormat af     = audioInputStream.getFormat();
//	            int size      = (int) (af.getFrameSize() * audioInputStream.getFrameLength());
//	            byte[] audio1 = new byte[size];
//	            DataLine.Info info      = new DataLine.Info(Clip.class, af, size);
//	            audioInputStream.read(audio1, 0, size);
//	           
//	            Clip clip = (Clip) AudioSystem.getLine(info);
//	            clip.open(af, audio1, 0, size);
//	            clip.start();
				
			} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	private void loadIt(String audio) {
//		
//	}
}
