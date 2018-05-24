package fr.tutorial.codenmore.states;

import java.awt.Graphics;

import fr.tutorial.codenmore.Handler;
import fr.tutorial.codenmore.gfx.Assets;
import fr.tutorial.codenmore.ui.ClickListener;
import fr.tutorial.codenmore.ui.UIImageButton;
import fr.tutorial.codenmore.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.start_button, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		// System.out.println(handler.getMouseManager().getMouseX() + " " +
		// handler.getMouseManager().getMouseY());
		// if (handler.getMouseManager().isLeftPressed() &&
		// handler.getMouseManager().isRightPressed()) {
		// getState().setState(handler.getGame().gameState);
		// }
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		// g.setColor(Color.RED);
		// g.fillRect(handler.getMouseManager().getMouseX(),
		// handler.getMouseManager().getMouseY(), 8, 8);
	}

}
