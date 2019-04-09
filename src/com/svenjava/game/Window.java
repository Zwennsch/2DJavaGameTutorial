package com.svenjava.game;

import javax.swing.JFrame;

public class Window extends JFrame{
	
	private final int width = 1000;
	private final int height = width * 9 /16;
	
	public Window() {
		setTitle("TestWIndowTitle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new GamePanel(width, height));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
