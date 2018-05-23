package fr.tutorial.codenmore.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.gfx.Assets;

public class Player extends Creature {

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.setBounds(16, 32, 32, 32);
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.RED);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

}
