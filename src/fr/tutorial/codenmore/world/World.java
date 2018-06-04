package fr.tutorial.codenmore.world;

import java.awt.Graphics;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.entities.EntityManager;
import fr.tutorial.codenmore.entities.creatures.Player;
import fr.tutorial.codenmore.entities.statics.Rock;
import fr.tutorial.codenmore.entities.statics.Tree;
import fr.tutorial.codenmore.factory.Factory;
import fr.tutorial.codenmore.items.ItemManager;
import fr.tutorial.codenmore.tiles.Tile;
import fr.tutorial.codenmore.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	// Entities
	private EntityManager entityManager;
	// Item
	private ItemManager itemManager;
	// Factory
	private Factory factory;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		itemManager = new ItemManager(handler);
		// Temporary code!
		entityManager.addEntity(new Tree(handler, 132, 250));
		entityManager.addEntity(new Rock(handler, 132, 450));
		entityManager.addEntity(new Rock(handler, 350, 300));
		entityManager.addEntity(new Rock(handler, 400, 345));
		entityManager.addEntity(new Tree(handler, 625, 325));

		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		// factory
		factory = new Factory(handler, 70, 70);
	}

	public void tick() {
		itemManager.tick();
		entityManager.tick();
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		// Items
		itemManager.render(g);
		// Entities
		entityManager.render(g);
		// Factory
		factory.render(g);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.GRASS;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.DIRT;
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

}
