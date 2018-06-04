package fr.tutorial.codenmore.tiles;

import fr.tutorial.codenmore.gfx.Assets;

public class WallTile extends Tile {

	public WallTile(int id) {
		super(Assets.wall, id);
	}

	public boolean isSolid() {
		return true;
	}

}
