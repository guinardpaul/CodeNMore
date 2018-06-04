package fr.tutorial.codenmore.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int WIDTH = 16;
	private static final int HEIGHT = 16;

	public static Font font28;

	public static BufferedImage grass;
	public static BufferedImage water;
	public static BufferedImage rock;
	public static BufferedImage rock_item;
	public static BufferedImage dirt;
	public static BufferedImage tree;
	public static BufferedImage wood;
	public static BufferedImage wall;
	public static BufferedImage player_standing_still;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage inventoryScreen;
	public static BufferedImage factory;

	public static BufferedImage[] start_button;

	public static void init() {
		font28 = FontLoader.loadFont("/fonts/slkscr.ttf", 28);

		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("/textures/menusheet.png"));

		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");

		start_button = new BufferedImage[2];
		start_button[0] = menu.crop(380, 0, 417 - 380, 36);
		start_button[1] = menu.crop(380, 36, 417 - 380, 73 - 36);

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

		factory = sheet.crop(WIDTH * 3, 0, WIDTH, HEIGHT);

		dirt = sheet.crop(0, HEIGHT * 2, WIDTH, HEIGHT);
		water = sheet.crop(WIDTH * 2, HEIGHT * 2, WIDTH, HEIGHT);
		wall = sheet.crop(0, HEIGHT, WIDTH, HEIGHT);
		rock = sheet.crop(WIDTH * 2, HEIGHT * 3, WIDTH, HEIGHT);
		rock_item = sheet.crop(WIDTH * 3, HEIGHT * 3, WIDTH, HEIGHT);
		grass = sheet.crop(WIDTH, HEIGHT * 2, WIDTH, HEIGHT);
		tree = sheet.crop(0, HEIGHT * 3, WIDTH, HEIGHT);
		wood = sheet.crop(WIDTH, HEIGHT * 3, WIDTH, HEIGHT);
	}

}
