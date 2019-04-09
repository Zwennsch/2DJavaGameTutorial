package com.svenjava.game;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	private static int width, height;
	private Thread thread;
	private boolean running = false;
	private BufferedImage bufferedImage;
	private Graphics2D g;
	
	public GamePanel(int width, int height) {
		GamePanel.width = width;
		GamePanel.height = height;
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
	}
	@Override
	public void addNotify() {
		
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this, "GameThread");
			thread.start();
		}
	}

	@Override
	public void run() {
		init();
		
		while(running) {
			update();
			render();
			draw();
		}
	}
	public void draw() {
	}
	public void render() {
	}
	int x = 0;
	public void update() {
		x++;
		System.out.println(x);
	}
	private void init() {
		running = true;
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) bufferedImage.getGraphics();
	}
	
}
