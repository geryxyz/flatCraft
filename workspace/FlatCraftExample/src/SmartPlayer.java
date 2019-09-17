import flatcraft.Key;
import flatcraft.Player;

public class SmartPlayer extends Player {

	public SmartPlayer(String name) {
		super(name);
	}

	// called when a button is pressed
	@Override
	protected void onKeyDown(int keyCode) {
		switch(keyCode) {
			case Key.LEFT:
				move(-1, 0);
				break;
			case Key.RIGHT:
				move(1, 0);
				break;
			case Key.SPACE:
				move(0, 1);
				break;
		}
	}
	
}
