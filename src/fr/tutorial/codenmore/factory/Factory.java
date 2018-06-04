package fr.tutorial.codenmore.factory;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.gfx.Assets;

public class Factory {

	public static final int FACTORY_WIDTH = 32, FACTORY_HEIGHT = 32;

	private Handler handler;
	private BufferedImage texture;
	private int x, y;

	public Factory(Handler handler, int x, int y) {
		this.handler = handler;
		this.texture = Assets.factory;
		this.x = x;
		this.y = y;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(texture, x, y, FACTORY_WIDTH, FACTORY_HEIGHT, null);
	}

}
