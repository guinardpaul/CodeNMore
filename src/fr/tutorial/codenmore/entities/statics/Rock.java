package fr.tutorial.codenmore.entities.statics;

import java.awt.Graphics;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.gfx.Assets;
import fr.tutorial.codenmore.items.Item;
import fr.tutorial.codenmore.tiles.Tile;

public class Rock extends StaticEntity {

	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);

		bounds.setBounds(28, getHeight() / 2 + 18, 8, 30);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int) x, (int) y));
	}

}
