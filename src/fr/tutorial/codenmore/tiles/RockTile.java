package fr.tutorial.codenmore.tiles;

import fr.tutorial.codenmore.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.rock, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
