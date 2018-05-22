package fr.tutorial.codenmore;

public class Launcher {

	private final static int WIDTH = 360;
	private final static int HEIGHT = 640;
	private final static String TITLE = "Title";

	public static void main(String[] args) {
		Game game = new Game(TITLE, HEIGHT, WIDTH);
		game.start();
	}

}
