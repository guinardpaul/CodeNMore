package fr.tutorial.codenmore;

import fr.tutorial.codenmore.gfx.GameCamera;
import fr.tutorial.codenmore.input.KeyManager;
import fr.tutorial.codenmore.input.MouseManager;
import fr.tutorial.codenmore.world.World;

public class Handler {

	private Game game;
	private World world;

	public Handler(Game game) {
		this.game = game;
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
