package com.stephenmcmullin.ocja.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import javax.swing.*;

@SuppressWarnings("serial")
public class AdvancedScreen extends JLabel {
	@SuppressWarnings("unused")
	private JButton advBack;
	@SuppressWarnings("unused")
	private NoiseMachineMain nmm;
	//	static int duration = 1;
	static JSlider slider;
	static boolean infinite;
	static boolean random;
	static boolean keyChange;
	static int newKey;
	final JLabel aKey;
	final JLabel bKey;
	final JLabel cKey;
	final JLabel dKey;
	final JLabel eKey;
	final JLabel fKey;
	final JLabel gKey;
	final JCheckBox chckbxInfiniteLoop;
	final JLabel advReset;
	boolean cKeyIsSelected;
	/**
	 * @wbp.nonvisual location=51,249
	 */
	/**
	 * Create the panel.
	 */
	public AdvancedScreen(final NoiseMachineMain nmm) {
		setBounds(new Rectangle(0, 0, 800, 500));

		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setBackground(Color.WHITE);
		this.setLayout(null);
		this.nmm = nmm;
		ImageIcon imi = nmm.createImageIcon("Gradient.jpg");
		this.setIcon(imi);

		//Create slider to set number of loops played
		slider = new JSlider();
		slider.setForeground(Color.WHITE);
		slider.setBackground(Color.WHITE);
		slider.setOpaque(false);
		slider.setSnapToTicks(true);
		slider.setValueIsAdjusting(true);
		slider.setBorder(null);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setValue(1);
		slider.setBounds(135, 100, 500, 50);
		add(slider);		

		JLabel durationLabel = new JLabel("Duration");
		durationLabel.setForeground(UIManager.getColor("CheckBox.background"));
		durationLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		durationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		durationLabel.setBounds(15, 30, 100, 50);
		add(durationLabel);

		String labelText = "<html><body><center>Set Duration<br>(No. of Loops)</center></body></html>";
		JLabel lblSetDuration = new JLabel(labelText);
		lblSetDuration.setForeground(UIManager.getColor("CheckBox.background"));
		lblSetDuration.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSetDuration.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetDuration.setBounds(15, 100, 100, 50);
		add(lblSetDuration);

		//Set ability to transpose midi sounds from one key to another
		JLabel transposeLabel = new JLabel("Transpose");
		transposeLabel.setForeground(UIManager.getColor("CheckBox.background"));
		transposeLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		transposeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transposeLabel.setBounds(15, 180, 100, 50);
		add(transposeLabel);

		JLabel chooseKey = new JLabel("Change playback key");
		chooseKey.setForeground(UIManager.getColor("CheckBox.background"));
		chooseKey.setFont(new Font("Verdana", Font.BOLD, 12));
		chooseKey.setHorizontalAlignment(SwingConstants.CENTER);
		chooseKey.setBounds(300, 210, 200, 50);
		add(chooseKey);

		aKey = new JLabel("A");
		aKey.setForeground(UIManager.getColor("CheckBox.background"));
		aKey.setFont(new Font("Verdana", Font.BOLD, 23));
		aKey.setHorizontalAlignment(SwingConstants.CENTER);
		aKey.setBorder(new LineBorder((Color.gray), 1, true));
		aKey.setBounds(20, 270, 100, 50);
		aKey.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseEntered(MouseEvent e) {
				if(keyChange == false){
					aKey.setForeground(new Color(245,245,245));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(keyChange == false){
					aKey.setForeground(new Color(220,220,220));
				}
			}
			public void mouseClicked(MouseEvent e){
				newKey = 9;
				changeKeyColor(newKey);
			}
		});
		add(aKey);

		bKey = new JLabel("B");
		bKey.setForeground(UIManager.getColor("CheckBox.background"));
		bKey.setFont(new Font("Verdana", Font.BOLD, 23));
		bKey.setHorizontalAlignment(SwingConstants.CENTER);
		bKey.setBorder(new LineBorder((Color.gray), 1, true));
		bKey.setBounds(130, 270, 100, 50);
		bKey.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(keyChange == false){
					bKey.setForeground(new Color(245,245,245));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(keyChange == false){
					bKey.setForeground(new Color(220,220,220));
				}
			}
			public void mouseClicked(MouseEvent e){
				newKey = 11;
				changeKeyColor(newKey);
			}
		});
		add(bKey);

		cKey = new JLabel("C");
		cKey.setForeground(UIManager.getColor("CheckBox.background"));
		cKey.setFont(new Font("Verdana", Font.BOLD, 23));
		cKey.setHorizontalAlignment(SwingConstants.CENTER);
		cKey.setBorder(new LineBorder((UIManager.getColor("CheckBox.background")), 3, true));
		cKey.setBounds(240, 270, 100, 50);
		cKey.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(keyChange == false){
					cKey.setForeground(new Color(245,245,245));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(keyChange == false){
					cKey.setForeground(new Color(220,220,220));
				}
			}
			public void mouseClicked(MouseEvent e){
				
				newKey = 0;
				changeKeyColor(newKey);
			}
		});
		add(cKey);

		dKey = new JLabel("D");
		dKey.setForeground(UIManager.getColor("CheckBox.background"));
		dKey.setFont(new Font("Verdana", Font.BOLD, 23));
		dKey.setHorizontalAlignment(SwingConstants.CENTER);
		dKey.setBorder(new LineBorder((Color.gray), 1, true));
		dKey.setBounds(350, 270, 100, 50);
		dKey.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(keyChange == false){
					dKey.setForeground(new Color(245,245,245));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(keyChange == false){
					dKey.setForeground(new Color(220,220,220));
				}
			}
			public void mouseClicked(MouseEvent e){
				newKey = 2;
				changeKeyColor(newKey);
			}
		});
		add(dKey);

		eKey = new JLabel("E");
		eKey.setForeground(UIManager.getColor("CheckBox.background"));
		eKey.setFont(new Font("Verdana", Font.BOLD, 23));
		eKey.setHorizontalAlignment(SwingConstants.CENTER);
		eKey.setBorder(new LineBorder((Color.gray), 1, true));
		eKey.setBounds(460, 270, 100, 50);
		eKey.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(keyChange == false){
					eKey.setForeground(new Color(245,245,245));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(keyChange == false){
					eKey.setForeground(new Color(220,220,220));
				}
			}
			public void mouseClicked(MouseEvent e){
				newKey = 4;
				changeKeyColor(newKey);
			}
		});
		add(eKey);

		fKey = new JLabel("F");
		fKey.setForeground(UIManager.getColor("CheckBox.background"));
		fKey.setFont(new Font("Verdana", Font.BOLD, 23));
		fKey.setHorizontalAlignment(SwingConstants.CENTER);
		fKey.setBorder(new LineBorder((Color.gray), 1, true));
		fKey.setBounds(570, 270, 100, 50);
		fKey.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(keyChange == false){
					fKey.setForeground(new Color(245,245,245));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(keyChange == false){
					fKey.setForeground(new Color(220,220,220));
				}
			}
			public void mouseClicked(MouseEvent e){
				newKey = 5;
				changeKeyColor(newKey);
			}
		});
		add(fKey);

		gKey = new JLabel("G");
		gKey.setForeground(UIManager.getColor("CheckBox.background"));
		gKey.setFont(new Font("Verdana", Font.BOLD, 23));
		gKey.setHorizontalAlignment(SwingConstants.CENTER);
		gKey.setBorder(new LineBorder((Color.gray), 1, true));
		gKey.setBounds(680, 270, 100, 50);
		gKey.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				if(keyChange == false){
					gKey.setForeground(new Color(245,245,245));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(keyChange == false){
					gKey.setForeground(new Color(220,220,220));
				}
			}
			public void mouseClicked(MouseEvent e){
				newKey = 7;
				changeKeyColor(newKey);
			}
		});
		add(gKey);

		//Return to options screen
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
				Sound.duration = slider.getValue();
				nmm.switchScreen(5);
			}
		});
		advBack.setBounds(450, 390, 90, 40);
		add(advBack);

		//Reset all values on Advanced Screen to default
		advReset = new JLabel("RESET");
		advReset.setOpaque(false);
		advReset.setBorder(null);
		advReset.setLocation(new Point(0, 200));
		advReset.setForeground(new Color(220,220,220));
		advReset.setFont(new Font("Verdana", Font.BOLD, 25));
		advReset.setBackground(new Color(0,0,0,0));
		advReset.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				advReset.setForeground(new Color(245,245,245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				advReset.setForeground(new Color(220,220,220));
			}
			public void mouseClicked(MouseEvent e){
				resetAll();
			}
		});
		advReset.setBounds(275, 390, 90, 40);
		add(advReset);

		//Checkbox to set loop to play continuously when selected
		chckbxInfiniteLoop = new JCheckBox("Infinite Loop");
		chckbxInfiniteLoop.setForeground(UIManager.getColor("CheckBox.background"));
		chckbxInfiniteLoop.setBackground(new Color(0,0,0, 0));
		chckbxInfiniteLoop.setOpaque(false);
		chckbxInfiniteLoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxInfiniteLoop.isSelected()){
					infinite = true;
					slider.setEnabled(false);
				}else{
					infinite = false;
					slider.setEnabled(true);
				}
			}
		});
		chckbxInfiniteLoop.setBorder(null);
		chckbxInfiniteLoop.setToolTipText("Check to set an infinite loop");
		chckbxInfiniteLoop.setFont(new Font("Verdana", Font.BOLD, 12));
		chckbxInfiniteLoop.setBounds(655, 100, 120, 50);
		add(chckbxInfiniteLoop);

		JPanel border = new JPanel();
		border.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 1, true));
		border.setBounds(10, 70, 780, 110);
		border.setOpaque(false);
		add(border);

		JPanel border2 = new JPanel();
		border2.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 1, true));
		border2.setBounds(10, 220, 780, 110);
		border2.setOpaque(false);
		add(border2);
	}

	//Change the colour of the key buttons when selected/deselected
	public void changeKeyColor(int key){
		keyChange = true;
		switch(key){
		case 0: {
			keyChange = false;
			keysGray();
			cKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
			break;
		}
		case 2: {
			keysGray();
			dKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
			break;
		}
		case 4: {
			keysGray();
			eKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
			break;
		}
		case 5: {
			keysGray();
			fKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
			break;
		}
		case 7: {
			keysGray();
			gKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
			break;
		}
		case 9: {
			keysGray();
			aKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
			break;
		}
		case 11: {
			keysGray();
			bKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
			break;
		}

		}


	}
	public void resetAll(){
		keysGray();
		cKey.setBorder(new LineBorder(UIManager.getColor("CheckBox.background"), 3, true));
		keyChange = false;
		Sound.duration = 1;
		slider.setValue(1);
		infinite = false;
		if(chckbxInfiniteLoop.isSelected())
			chckbxInfiniteLoop.doClick();

	}
	public void keysGray(){
		aKey.setBorder(new LineBorder((Color.gray), 1, true));
		bKey.setBorder(new LineBorder((Color.gray), 1, true));
		cKey.setBorder(new LineBorder((Color.gray), 1, true));
		dKey.setBorder(new LineBorder((Color.gray), 1, true));
		eKey.setBorder(new LineBorder((Color.gray), 1, true));
		fKey.setBorder(new LineBorder((Color.gray), 1, true));
		gKey.setBorder(new LineBorder((Color.gray), 1, true));
	}
}
