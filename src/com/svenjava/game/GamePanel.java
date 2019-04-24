package com.svenjava.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
		Graphics g2 = this.getGraphics();
		g2.drawImage(bufferedImage,0,0,  width, height, null);
		g2.dispose();
	}
	public void render() {
		if (g != null) {
			g.setColor(new Color(66, 150, 244));
			g.fillRect(0, 0, width, height);
		}
	}
	
	public void update() {
		
	}
	private void init() {
		running = true;
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) bufferedImage.getGraphics();
	}
	
}
