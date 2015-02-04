package com.stephenmcmullin.ocja.project;


import java.awt.event.*;

import javax.swing.*;

import jm.JMC;

import java.awt.*;

@SuppressWarnings("serial")
public class Options extends JLabel implements JMC{
	NoiseMachineMain nmm;
	@SuppressWarnings("unused")
	private MainScreen ms;
	private ReflectButton button1;
	private ReflectButton button2;
	private ReflectButton button3;
	private ReflectButton button4;
	private ReflectButton button5;
	private ReflectButton button6;
	private ReflectButton button7;
	private JLabel adv;
	static int inst;
	static boolean midiSelected = true;
	static boolean fileSelected;
	static boolean hasMouse;
	static int drone;
	static String whichDrone;

	/**
	 * Create the panel.
	 */
	public Options(final NoiseMachineMain nmm, final MainScreen ms) {
		setVerticalAlignment(SwingConstants.TOP);
		setBounds(new Rectangle(0, 0, 800, 500));
		this.nmm = nmm;
		this.ms = ms;
		this.setBackground(Color.BLACK);
		this.setBorder(null);
		this.setLayout(null);
		ImageIcon imi = nmm.createImageIcon("Gradient.jpg");
		this.setIcon(imi);

		/* Create buttons for Options Screen
		They're ordered this way because they overlap
		and this is the only order in which they'll function properly.
		*/
		button3 = new ReflectButton("Round3.png");
		button3.setToolTipText("Wave Sounds");
		button3.setBorder(null);
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NoiseMachineMain.isFilePlaying = false;
				NoiseMachineMain.isPlaying = false;
				drone = 3;
				whichDrone = "Ocean.wav";
				midiSelected = false;
				fileSelected = true;
				try{
					nmm.switchScreen(2);
					nmm.playMusic("Blah");
					nmm.switchScreenImage(3);
				}catch(Exception ex){}

			}
		});
		button3.setBounds(20, 240, 160, 320);
		button3.setForeground(new Color(0,10,0));
		button3.setBackground(new Color(0,0,0,0));
		button3.setOpaque(false);		
		button3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(button3);
		
		button1 = new ReflectButton("Round1.png");
		button1.setToolTipText("Echo Drops");
		button1.setBorder(null);
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				NoiseMachineMain.isPlaying = false;
				NoiseMachineMain.isFilePlaying = false;
				midiSelected = true;
				fileSelected = false;
				NoiseMachineMain.inst = DROPS;
				try {
					nmm.playMusic("Blah");
					nmm.switchScreen(2);
					nmm.switchScreenImage(102);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button1.setBounds(20, 20, 160, 320);
		button1.setForeground(new Color(0,0,0,0));
		button1.setBackground(new Color(0,0,0,0));
		button1.setOpaque(false);
		button1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		this.add(button1);
		
		button2 = new ReflectButton("Round2.png");
		button2.setToolTipText("Atmospheric Synth");
		button2.setBorder(null);
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NoiseMachineMain.isFilePlaying = false;
				NoiseMachineMain.isPlaying = false;
				drone = 1;
				whichDrone = "Small Space.au";
				midiSelected = false;
				fileSelected = true;
				try{
					nmm.switchScreen(2);
					nmm.playMusic("Blah");
					nmm.switchScreenImage(99);
				}catch(Exception ex){}
				
			}
		});
		button2.setBounds(220, 240, 160, 320);
		button2.setForeground(new Color(0,10,0));
		button2.setBackground(new Color(0,0,0,0));
		button2.setOpaque(false);
		button2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(button2);
		
		button6 = new ReflectButton("Round6.png");
		button6.setToolTipText("Drone");
		button6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NoiseMachineMain.isPlaying = false;
				NoiseMachineMain.isFilePlaying = false;
				midiSelected = true;
				fileSelected = false;
				NoiseMachineMain.inst = VOX;
				try {
					nmm.playMusic("Blah");
					nmm.switchScreenImage(1);
					nmm.switchScreen(2);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

		});
		button6.setForeground(Color.WHITE);
		button6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		button6.setBorder(null);
		button6.setBackground(new Color(0,0,0,0));
		button6.setOpaque(false);
		button6.setBounds(220, 20, 160, 320);
		add(button6);
		
		button7 = new ReflectButton("RoundForest.png");
		button7.setToolTipText("Forest Sounds");
		button7.setOpaque(false);
		button7.setForeground(new Color(0, 10, 0));
		button7.setFont(new Font("Times New Roman", Font.BOLD, 30));
		button7.setBorder(null);
		button7.setBackground(Color.BLACK);
		button7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NoiseMachineMain.isFilePlaying = false;
				NoiseMachineMain.isPlaying = false;
				drone = 2;
				whichDrone = "NatureSounds.wav";
				midiSelected = false;
				fileSelected = true;
				try{
					nmm.switchScreen(2);
					nmm.playMusic("Blah");
					nmm.switchScreenImage(2);
				}catch(Exception ex){}
			}
		});
		button7.setBounds(420, 240, 160, 320);
		this.add(button7);
		
		button5 = new ReflectButton("Round7.png");
		button5.setBorder(null);
		button5.setToolTipText("Crystal Drops");
		button5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				NoiseMachineMain.isPlaying = false;
				NoiseMachineMain.isFilePlaying = false;
				midiSelected = true;
				fileSelected = false;
				NoiseMachineMain.inst = SPACE_VOICE;
				try {
					nmm.switchScreen(2);
					nmm.playMusic("Blah");
					nmm.switchScreenImage(91);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button5.setBounds(420, 20, 160, 320);
		button5.setForeground(Color.WHITE);
		button5.setBackground(new Color(0,0,0,0));
		button5.setOpaque(false);
		button5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(button5);

		//Create Advanced Options button on Options screen
				//Using HTML to add multiple lines of text
				String buttonText = "<html><body><center>Advanced<br>Options</center></body></html>";
				adv = new JLabel(buttonText);
				adv.setOpaque(false);
				adv.setHorizontalTextPosition(SwingConstants.CENTER);
				adv.setForeground(new Color(220, 220, 220));
				adv.setBorder(null);
				adv.setToolTipText("Press for Advanced Options");
				adv.setFont(new Font("Verdana", Font.BOLD, 25));
				adv.setBackground(new Color(100, 149, 0, 0));
				adv.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						adv.setForeground(new Color(255,255,255));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						adv.setForeground(new Color(220, 220, 220));
					}
					public void mouseClicked(MouseEvent e){
						nmm.switchScreen(3);
						adv.setForeground(new Color(220, 220, 220));
					}
				});
				adv.setBounds(630, 250, 160, 70);
				this.add(adv);

		
		button4 = new ReflectButton("Round4.png");
		button4.setToolTipText("Goblin Synth");
		button4.setBorder(null);
		button4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NoiseMachineMain.isPlaying = false;
				NoiseMachineMain.isFilePlaying = false;
				midiSelected = true;
				fileSelected = false;
				NoiseMachineMain.inst = GOBLIN;
				try {
					nmm.switchScreen(2);
					nmm.playMusic("Blah");
					nmm.switchScreenImage(101);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button4.setBounds(620, 20, 160, 320);
		button4.setForeground(new Color(0,10,0));
		button4.setBackground(new Color(0,0,0,0));
		button4.setOpaque(false);
		button4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		add(button4);
		
		//create Help button for Options Screen
		String helpText = "<html><body><center>Help</center></body></html>";
		final JLabel btnHelp = new JLabel(helpText);
		btnHelp.setOpaque(false);
		btnHelp.setForeground(new Color(220, 220, 220));
		btnHelp.setBorder(null);
		btnHelp.setToolTipText("Press for Tutorial");
		btnHelp.setToolTipText("Press for Tutorial");
		btnHelp.setFont(new Font("Verdana", Font.BOLD, 30));
		btnHelp.setBackground(new Color(165, 42, 42, 0));
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHelp.setForeground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHelp.setForeground(new Color(220, 220, 220));
			}
			public void mouseClicked(MouseEvent e){
				nmm.switchScreen(4);
				btnHelp.setForeground(new Color(220, 220, 220));
			}
		});
		btnHelp.setBounds(660, 330, 160, 70);
		add(btnHelp);

	}
}
