package fr.tutorial.codenmore;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import fr.tutorial.codenmore.display.Display;

public class Game implements Runnable {

	private Display display;
	public int width;
	public int height;
	public String title;

	private Thread thread;
	private boolean running = false;

	private BufferStrategy bs;
	private Graphics g;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	private void init() {
		display = new Display(title, width, height);

	}

	private void tick() {
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		// Draw here
		// g.setColor(Color.PINK);
		g.fillRect(0, 0, width, height);
		// End drawing
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();

		while (running) {
			tick();
			render();
		}

		stop();
	}

	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this, "Game Thread");
		thread.start(); // Call run override method
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
