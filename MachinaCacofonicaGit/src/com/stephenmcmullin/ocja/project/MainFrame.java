package com.stephenmcmullin.ocja.project;

import javax.swing.JFrame;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	/**
	 * Create the frame.
	 */
	public MainFrame(Options opt) {
		
		setTitle("Noise Machine");
		getContentPane().setBounds(new Rectangle(0, 0, 800, 450));
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 480);
		setContentPane(opt);
	}

}
