package com.stephenmcmullin.ocja.project;

import java.awt.event.MouseAdapter;
import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")

//Create main screen
public class MainScreen extends JLabel{
	@SuppressWarnings("unused")
	private NoiseMachineMain nmm;

	public MainScreen(final NoiseMachineMain nmm){
		this.nmm = nmm;

		this.setBorder(null);
		this.setLayout(null);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nmm.stopMusic();
			}
		});
		setBounds(new Rectangle(0, 0, 800, 650));

	}	
}
