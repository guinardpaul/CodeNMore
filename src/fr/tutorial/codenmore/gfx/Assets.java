package fr.tutorial.codenmore.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int WIDTH = 16;
	private static final int HEIGHT = 16;

	public static BufferedImage player;
	public static BufferedImage grass;
	public static BufferedImage water;
	public static BufferedImage rock;
	public static BufferedImage dirt;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));

		player = sheet.crop(0, HEIGHT * 8, WIDTH * 2, HEIGHT * 2);

		dirt = sheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
		water = sheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
		rock = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		grass = sheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
	}

}
