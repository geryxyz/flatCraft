import flatcraft.Action;
import flatcraft.Player;

public class SmartPlayer extends Player {

	public SmartPlayer(String name) {
		super(name);
	}

	public void act(Action action, int repeat) {
		for(int i = 0; i < repeat; i++) {
			super.act(action);
		}
	}
	
}
