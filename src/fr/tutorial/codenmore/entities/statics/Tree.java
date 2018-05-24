package fr.tutorial.codenmore.entities.statics;

import java.awt.Graphics;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.gfx.Assets;
import fr.tutorial.codenmore.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
