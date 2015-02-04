package com.stephenmcmullin.ocja.project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class HelpScreen extends JLabel {
	@SuppressWarnings("unused")
	private NoiseMachineMain nmm;
	ImageIcon img;

	
	public HelpScreen(final NoiseMachineMain nmm) {
		setBorder(null);
		setBackground(Color.WHITE);
		this.nmm = nmm;
		this.setLayout(null);
		ImageIcon imi = nmm.createImageIcon("Gradient.jpg");
		this.setIcon(imi);
		
		//Create Back button on Help screen
		final JLabel advBack = new JLabel("BACK");
		advBack.setOpaque(false);
		advBack.setBorder(null);
		advBack.setLocation(new Point(0, 200));
		advBack.setForeground(new Color(220,220,220));
		advBack.setFont(new Font("Verdana", Font.BOLD, 25));
		advBack.setBackground(new Color(0,0,0,0));
		advBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				advBack.setForeground(new Color(245,245,245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				advBack.setForeground(new Color(220,220,220));
			}
			public void mouseClicked(MouseEvent e){
				nmm.switchScreen(6);
			}
		});
		advBack.setBounds(375, 390, 90, 40);
		add(advBack);
		
		//Helpful help haiku
		String helpText =  "<html><body><center>On this page you will<br>"
				+ "Find help eventually.<br>See product backlog. </center></body></html>";
		JLabel tutorial= new JLabel(helpText);
		tutorial.setForeground(UIManager.getColor("CheckBox.background"));
		tutorial.setFont(new Font("Verdana", Font.BOLD, 20));
		tutorial.setHorizontalAlignment(SwingConstants.CENTER);
		tutorial.setHorizontalTextPosition(SwingConstants.CENTER);
		tutorial.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 1, true));
		tutorial.setBackground(Color.WHITE);
		tutorial.setBounds(200,50, 400, 200);
		tutorial.setVisible(true);
		add(tutorial);
	}
}
