package fr.tutorial.codenmore.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int WIDTH = 16;
	private static final int HEIGHT = 16;

	public static BufferedImage grass;
	public static BufferedImage water;
	public static BufferedImage rock;
	public static BufferedImage dirt;
	public static BufferedImage tree;
	public static BufferedImage player_standing_still;
	public static BufferedImage[] player_down, player_up, player_left, player_right;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));

		player_down = new BufferedImage[4];
		player_down[0] = sheet.crop(0, HEIGHT * 8, WIDTH * 2, HEIGHT * 2);
		player_down[1] = sheet.crop(0, HEIGHT * 10, WIDTH * 2, HEIGHT * 2);
		player_down[2] = sheet.crop(0, HEIGHT * 12, WIDTH * 2, HEIGHT * 2);
		player_down[3] = sheet.crop(0, HEIGHT * 14, WIDTH * 2, HEIGHT * 2);

		player_up = new BufferedImage[4];
		player_up[0] = sheet.crop(WIDTH * 4, HEIGHT * 8, WIDTH * 2, HEIGHT * 2);
		player_up[1] = sheet.crop(WIDTH * 4, HEIGHT * 10, WIDTH * 2, HEIGHT * 2);
		player_up[2] = sheet.crop(WIDTH * 4, HEIGHT * 12, WIDTH * 2, HEIGHT * 2);
		player_up[3] = sheet.crop(WIDTH * 4, HEIGHT * 14, WIDTH * 2, HEIGHT * 2);

		player_left = new BufferedImage[4];
		player_left[0] = sheet.crop(WIDTH * 2, HEIGHT * 8, WIDTH * 2, HEIGHT * 2);
		player_left[1] = sheet.crop(WIDTH * 2, HEIGHT * 10, WIDTH * 2, HEIGHT * 2);
		player_left[2] = sheet.crop(WIDTH * 2, HEIGHT * 12, WIDTH * 2, HEIGHT * 2);
		player_left[3] = sheet.crop(WIDTH * 2, HEIGHT * 14, WIDTH * 2, HEIGHT * 2);

		player_right = new BufferedImage[4];
		player_right[0] = sheet.crop(WIDTH * 6, HEIGHT * 8, WIDTH * 2, HEIGHT * 2);
		player_right[1] = sheet.crop(WIDTH * 6, HEIGHT * 10, WIDTH * 2, HEIGHT * 2);
		player_right[2] = sheet.crop(WIDTH * 6, HEIGHT * 12, WIDTH * 2, HEIGHT * 2);
		player_right[3] = sheet.crop(WIDTH * 6, HEIGHT * 14, WIDTH * 2, HEIGHT * 2);

		player_standing_still = sheet.crop(0, HEIGHT * 8, WIDTH * 2, HEIGHT * 2);

		dirt = sheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
		water = sheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
		rock = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		grass = sheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
		tree = sheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
	}

}
