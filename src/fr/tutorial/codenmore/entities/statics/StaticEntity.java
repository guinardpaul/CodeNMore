package fr.tutorial.codenmore.entities.statics;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
