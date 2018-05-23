package fr.tutorial.codenmore;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import fr.tutorial.codenmore.display.Display;
import fr.tutorial.codenmore.gfx.Assets;
import fr.tutorial.codenmore.gfx.GameCamera;
import fr.tutorial.codenmore.input.KeyManager;
import fr.tutorial.codenmore.states.GameState;
import fr.tutorial.codenmore.states.MenuState;
import fr.tutorial.codenmore.states.State;

public class Game implements Runnable {

	private Display display;
	private int width;
	private int height;
	public String title;

	private Thread thread;
	private boolean running = false;

	private BufferStrategy bs;
	private Graphics g;

	// States
	private State gameState;
	private State menuState;

	// Input
	private KeyManager keyManager;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();

		gameCamera = new GameCamera(this, 0, 0);
		handler = new Handler(this);

		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}

	private void tick() {
		keyManager.tick();
		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw here
		// g.drawImage(Assets.water, x, 10, null);
		if (State.getState() != null) {
			State.getState().render(g);
		}
		// End drawing
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				System.out.println("Ticks " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
