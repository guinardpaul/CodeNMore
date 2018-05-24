package fr.tutorial.codenmore.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.gfx.Animation;
import fr.tutorial.codenmore.gfx.Assets;

public class Player extends Creature {

	private Animation animDown, animUp, animLeft, animRight;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		// bounds.setBounds(16, 32, 32, 32);
		bounds.setBounds(45, 72, 40, 40);

		// Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	}

	@Override
	public void tick() {
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		// Move
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
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		// Collision rectangle
		// g.setColor(Color.RED);
		// g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
		// (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
		// bounds.height);
	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return Assets.player_standing_still;
		}
	}

}
