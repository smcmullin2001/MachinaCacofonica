package com.stephenmcmullin.ocja.project;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import jm.util.Play;
import jm.JMC;


public class NoiseMachineMain implements JMC{
	static MainFrame mf;
	static Options opt;
	static MainScreen ms;
	static AdvancedScreen adv;
	static HelpScreen help;
	static int inst = 98;
	static boolean isPlaying;
	static boolean isFilePlaying;
	private Clip clip;

	public static void main(String[] args) {
		NoiseMachineMain nmm = new NoiseMachineMain();
		ms = new MainScreen(nmm);
		opt = new Options(nmm, ms);
		mf = new MainFrame(opt);
		adv = new AdvancedScreen(nmm);
		help = new HelpScreen(nmm);
	}

	//Method to switch back and forth between screens	
	public void switchScreen(int j){

		switch(j){
		case 1: {
			mf.remove(ms);
			mf.setContentPane(opt);
			mf.validate();
			break;
		}
		case 2:{
			mf.remove(opt);
			mf.setContentPane(ms);
			mf.validate();
			break;
		}
		case 3:{
			mf.remove(opt);
			mf.setContentPane(adv);
			mf.validate();
			break;
		}
		case 4:{
			mf.remove(opt);
			mf.setContentPane(help);
			mf.validate();
			break;
		}
		case 5:{
			mf.remove(adv);
			mf.setContentPane(opt);
			mf.validate();
			break;
		}
		case 6:{
			mf.remove(help);
			mf.setContentPane(opt);
			mf.validate();
			break;
		}
		}
	}

	//Method to change image on main screen
	public void switchScreenImage(int i) throws IOException{

		switch(i){
		case 1 : {
			Image img = ImageIO.read(getClass().getResource("moon.jpg"));
			ms.setIcon(new ImageIcon(img));
			break;
		}
		case 2: {
			Image img = ImageIO.read(getClass().getResource("RainForest.jpg"));
			ms.setIcon(new ImageIcon(img));
			break;
		}
		case 3: {
			Image img = ImageIO.read(getClass().getResource("waves.jpg"));
			ms.setIcon(new ImageIcon(img));
			break;
		}
		case 91: {
			Image img = ImageIO.read(getClass().getResource("back.jpg"));
			ms.setIcon(new ImageIcon(img));
			break;
		}
		case 99: {
			Image img = ImageIO.read(getClass().getResource("atmosphere.jpg"));
			ms.setIcon(new ImageIcon(img));
			break;
		}
		case 101: {
			Image img = ImageIO.read(getClass().getResource("goblin.jpg"));
			ms.setIcon(new ImageIcon(img));
			break;
		}
		case 102: {
			Image img = ImageIO.read(getClass().getResource("drops.jpg"));
			ms.setIcon(new ImageIcon(img));
			break;
		}
		default: {
			ImageIcon imi = createImageIcon("Fractal2.jpg");
			ms.setIcon(imi);
			break;
		}
		}
	}

	//method to set background images
	public ImageIcon createImageIcon(String image){
		java.net.URL imgURL = getClass().getResource(image);

		if(imgURL != null){
			return new ImageIcon(imgURL);
		}else{
			return null;
		}
	}
	
	//Method to play .wav file of generate and play midi
	public void playMusic(String str) throws IOException{
		SwingWorker<Void, Void> worker = new SwingWorker<Void,Void>(){
			@SuppressWarnings("static-access")
			protected Void doInBackground() throws Exception{
				//Play music
				if(!isFilePlaying && !isPlaying){

					//Play file
					if(!Options.midiSelected){
						try{
							if(isPlaying) Play.closeAll();
							isFilePlaying = true;
							switchScreenImage(Options.drone);
							AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResource(Options.whichDrone));
							clip = AudioSystem.getClip();
							clip.open(audioIn);
							System.out.println(Sound.duration + "");
							if(AdvancedScreen.infinite){
								//Infinite loop	
								clip.start();
								clip.loop(clip.LOOP_CONTINUOUSLY);
							}else{
								clip.start();
								clip.loop(Sound.duration - 1);
							}
							if(clip.isRunning()) isFilePlaying = false;
						}catch(Exception except){}
						//Play midi
					}else if(!Options.fileSelected){

						if(isFilePlaying) clip.stop();
						isPlaying = true;
						switchScreenImage(inst);

						try{
							//Write sound to file - unimplemented
//							Write.midi(new Sound().setSound(inst), "Sound.mid");
//							float[] data = Read.audio("Sound.mid");
//							Write.audio(data, "Sound.wav");
							Play.midi(new Sound().setSound(inst), false);					
						}catch(NullPointerException npe){
							System.out.println("Wah!");
						}
					}
				}
				return null;
			}
		};
		worker.execute();
	}
	//Method to stop playback
	public void stopMusic(){
		if(isFilePlaying)
			//Stop playing
			clip.stop();
		if(isPlaying)
			//Stop midi
			Play.closeAll();
		switchScreen(1);
	}
}
