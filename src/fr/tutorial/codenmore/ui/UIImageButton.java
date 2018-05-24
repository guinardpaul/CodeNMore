package fr.tutorial.codenmore.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

	private BufferedImage[] images;
	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (hover) {
			g.drawImage(images[1], (int) x, (int) y, null);
		} else {
			g.drawImage(images[0], (int) x, (int) y, null);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
